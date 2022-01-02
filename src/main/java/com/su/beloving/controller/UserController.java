package com.su.beloving.controller;

import com.su.beloving.common.exception.ArgumentsIllegalException;
import com.su.beloving.common.exception.NoResultsException;
import com.su.beloving.dto.CartDetail;
import com.su.beloving.po.User;
import com.su.beloving.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beloving")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public Integer login(@RequestParam String username, @RequestParam String password, @RequestParam int role) throws ArgumentsIllegalException {
        return userService.login(username, password, role);
    }

    @GetMapping("/register")
    public Integer register(@RequestParam String username, @RequestParam String password,
                            @RequestParam String phone, @RequestParam Integer role) throws ArgumentsIllegalException {
        return userService.register(username, password, phone, role);
    }

    @GetMapping("/updateUsername")
    public boolean updateUsername(Integer id, String username) throws ArgumentsIllegalException {
        return userService.updateUsername(id, username);
    }

    @GetMapping("/updatePassword")
    public boolean updatePassword(Integer id, String password, String valid) throws ArgumentsIllegalException {
        return userService.updatePassword(id, password, valid);
    }

    @GetMapping("/deleteUser")
    public int deleteUser(Integer id) throws ArgumentsIllegalException {
        return userService.deleteUser(id);
    }

    @GetMapping("/showUser")
    public List<User> showUser(
            @RequestParam(value = "message", defaultValue = "", required = false) String message)
            throws NoResultsException {
        return userService.showUser(message);
    }

    @GetMapping("/updateAddress")
    public int updateAddress(Integer constant, Integer id, String address) throws ArgumentsIllegalException {
        return userService.updateAddress(constant, id, address);
    }

    @GetMapping("/userDetail")
    public User userDetail(Integer id) throws ArgumentsIllegalException {
        return userService.userDetail(id);
    }

    @GetMapping("/queryCart")
    public List<CartDetail> queryCart(Integer userId) throws ArgumentsIllegalException, NoResultsException {
        return userService.selectCart(userId);
    }

    @GetMapping("/cartInsert")
    public int cartInsert(Integer userId, Integer flowerId) throws ArgumentsIllegalException {
        return userService.insertCart(userId, flowerId);
    }

    @GetMapping("/cartDelete")
    public int cartDelete(Integer id) throws ArgumentsIllegalException {
        return userService.deleteCart(id);
    }
}
