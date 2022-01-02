package com.su.beloving.service.Impl;

import com.su.beloving.common.exception.ArgumentsIllegalException;
import com.su.beloving.common.exception.NoResultsException;
import com.su.beloving.dao.CartDao;
import com.su.beloving.dao.FlowerDao;
import com.su.beloving.dao.ManagerDao;
import com.su.beloving.dao.UserDao;
import com.su.beloving.dto.CartDetail;
import com.su.beloving.po.Cart;
import com.su.beloving.po.Flower;
import com.su.beloving.po.Manager;
import com.su.beloving.po.User;
import com.su.beloving.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Accessors(chain = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final ManagerDao managerDao;
    private final CartDao cartDao;
    private final FlowerDao flowerDao;

    @Override
    public Integer login(String username, String password, int role) throws ArgumentsIllegalException {
        log.info("username={},password={}", username, password);
        if (role == 0) {
            User user = userDao.selectup(username, password);
            if (user == null) {
                throw new ArgumentsIllegalException("账号或密码错误");
            }
            log.info("用户登录");
            return user.getId();
        } else if (role == 1) {
            Manager manager = managerDao.selectup(username, password);
            if (manager == null) {
                throw new ArgumentsIllegalException("账号或密码错误");
            }
            log.info("管理员登录");
            return manager.getId();
        }
        return -1;
    }

    @Override
    public Integer register(String username, String password, String phone, int role) throws ArgumentsIllegalException {
        log.info("username={},password={},phone={}", username, password, phone);
        if (role == 0) {
            log.info("用户注册");
            User user1 = userDao.selectByUsername(username);
            //用户名不可重名
            if (user1 != null) {
                throw new ArgumentsIllegalException("用户名已存在");
            } else {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setPhone(phone);
                userDao.insertOne(user);
            }
            return userDao.selectByUsername(username).getId();
        } else if (role == 1) {
            log.info("管理员注册");
            Manager manager1 = managerDao.selectByUsername(username);
            //用户名不可重名
            if (manager1 != null)
                throw new ArgumentsIllegalException("用户名已存在");
            else {
                Manager manager = new Manager();
                manager.setUsername(username);
                manager.setPassword(password);
                manager.setPhone(phone);
                managerDao.insertOne(manager);
            }
            return managerDao.selectByUsername(username).getId();
        }
        return -1;
    }

    @Override
    public boolean updateUsername(Integer id, String username) throws ArgumentsIllegalException {
        User user = userDao.selectById(id);
        if (user == null) {
            throw new ArgumentsIllegalException("无用户id为" + id + "的用户");
        }
        if (userDao.selectByUsername(username) == null) {
            log.info("用户'{}'将用户名修改为'{}'", user.getUsername(), username);
            return (userDao.updateUsername(id, username) == 1);
        }
        log.error("重名,修改失败");
        return false;
    }

    @Override
    public boolean updatePassword(Integer id, String password, String valid) throws ArgumentsIllegalException {
        User user = userDao.selectById(id);
        if (user == null) {
            throw new ArgumentsIllegalException("无用户id为" + id + "的用户");
        }
        if (password.equals(valid)) {
            log.info("用户'{}'修改密码", user.getUsername());
            return (userDao.updatePassword(id, password) == 1);
        }
        log.error("两次输入的密码不一样");
        return false;
    }

    @Override
    public int deleteUser(Integer id) throws ArgumentsIllegalException {
        if (userDao.selectById(id) == null) {
            throw new ArgumentsIllegalException("无id为" + id + "的用户");
        }
        log.info("删除id为'{}'的用户", id);
        return userDao.deleteById(id);
    }

    @Override
    public List<User> showUser(String message) throws NoResultsException {
        if (message == null || message.isEmpty()) {
            log.info("展示所有用户");
            return userDao.selectAll();
        } else {
            if (userDao.select(message).size() == 0) {
                log.error("无信息为'{}'的用户", message);
                throw new NoResultsException("查询无结果");
            }
            log.info("展示信息为'{}'的用户", message);
            return userDao.select(message);
        }
    }

    @Override
    public int updateAddress(int constant, int id, String address) throws ArgumentsIllegalException {
        if (userDao.selectById(id) == null) {
            throw new ArgumentsIllegalException("无id为" + id + "的用户");
        } else if (constant != 1 && constant != 2 && constant != 3) {
            throw new ArgumentsIllegalException("入参常量只能是1,2,3");
        } else if (address.length() < 15) {
            throw new ArgumentsIllegalException("入参地址可能不对");
        }
        log.info("用户id为'{}'的用户修改地址", id);
        if (constant == 1)
            return userDao.updateAddress1(id, address);
        else if (constant == 2)
            return userDao.updateAddress2(id, address);
        else
            return userDao.updateAddress3(id, address);
    }

    @Override
    public User userDetail(Integer id) throws ArgumentsIllegalException {
        if (userDao.selectById(id) == null) {
            throw new ArgumentsIllegalException("无用户id为 >>" + id + "的用户");
        }
        log.info("查看用户id为'{}'的用户信息", id);
        return userDao.selectById(id);
    }

    /**
     * 获取购物车的主键id用于删除;获取花的详情用于展示
     *
     * @param userId 用户id
     * @return CartDetail列表
     */

    @Override
    public List<CartDetail> selectCart(int userId) throws ArgumentsIllegalException, NoResultsException {
        log.info("进入查询购物车,用户id>>{}", userId);
        if (userDao.selectById(userId) == null) {
            log.error("异常");
            throw new ArgumentsIllegalException("无id为" + userId + "的用户");
        }
        List<CartDetail> res = new ArrayList<>();
        List<Cart> cartList = cartDao.selectFlower(userId);
        log.info(String.valueOf(cartList));

        for (Cart cart : cartList) {
            int id = cart.getId();
            int flowerId = cart.getFlowerId();
            Flower flower = flowerDao.selectById(flowerId);
            CartDetail cartDetail = new CartDetail();
            log.info("{},{}", id, flower);
            cartDetail.setId(id);
            cartDetail.setFlower(flower);
            res.add(cartDetail);
        }
        if (res == null || res.isEmpty()) {
            throw new NoResultsException("此用户购物车为空");
        }
        return res;
    }

    @Override
    public int insertCart(int userId, int flowerId) throws ArgumentsIllegalException {
        if (userDao.selectById(userId) == null) {
            throw new ArgumentsIllegalException("无id为" + userId + "的用户");
        } else if (flowerDao.selectById(flowerId) == null) {
            throw new ArgumentsIllegalException("无id为" + flowerId + "的花");
        }
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setFlowerId(flowerId);
        if (cartDao.insertOne(cart) == 1)
            log.info("用户id为'{}'的用户将id为'{}'的花加入购物车", userId, flowerId);
        else return -1;
        return cart.getId();
    }

    @Override
    public int deleteCart(int id) throws ArgumentsIllegalException {
        if (cartDao.selectById(id) == null) {
            throw new ArgumentsIllegalException("无id为" + id + "的购物车");
        }
        log.info("删除购物车中id为的'{}'的花", id);
        return cartDao.deleteOne(id);
    }
}
