package com.su.beloving.service.Impl;

import com.su.beloving.common.exception.ArgumentsIllegalException;
import com.su.beloving.common.exception.NoResultsException;
import com.su.beloving.dao.FlowerDao;
import com.su.beloving.po.Flower;
import com.su.beloving.service.FlowerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlowerServiceImpl implements FlowerService {
    private final FlowerDao flowerDao;

    @Override
    public int updateFlower(Flower flower) throws ArgumentsIllegalException {
        if (!flower.valid()) {
            throw new ArgumentsIllegalException("有参数为空");
        }
        log.info("修改id为'{}'的花", flower.getId());
        return flowerDao.updateOne(flower);
    }


    @Override
    public int insertFlower(Flower flower) throws ArgumentsIllegalException {
        if (!flower.valid()) {
            throw new ArgumentsIllegalException("有参数为空");
        }
        if (flowerDao.insertOne(flower) == 1) {
            log.info("新增{}", flower);
        }
        return flower.getId();
    }

    @Override
    public int deleteFlower(Integer id) throws ArgumentsIllegalException {
        if (flowerDao.selectById(id) == null) {
            throw new ArgumentsIllegalException("无id为" + id + "的花");
        }
        log.info("删除id为'{}'的商品", id);
        return flowerDao.deleteById(id);
    }

    @Override
    public List<Flower> showFlower(String message) throws NoResultsException {
        if (message == null || message.isEmpty()) {
            log.info("展示所有商品");
            return flowerDao.selectAll();
        } else {
            if (flowerDao.select(message) == null || flowerDao.select(message).isEmpty()) {
                log.info("无信息为'{}'的flower", message);
                throw new NoResultsException("查询无结果");
            }
            log.info("展示标签为'{}'的商品", message);
        }
        return flowerDao.select(message);
    }

    @Override
    public Flower selectById(int id) throws ArgumentsIllegalException {
        log.info("查询id为'{}'的flower", id);
        if (flowerDao.selectById(id) == null) {
            throw new ArgumentsIllegalException("无id为" + id + "的flower");
        }
        return flowerDao.selectById(id);
    }
}
