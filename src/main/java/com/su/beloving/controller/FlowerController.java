package com.su.beloving.controller;

import com.su.beloving.common.exception.ArgumentsIllegalException;
import com.su.beloving.common.exception.NoResultsException;
import com.su.beloving.po.Flower;
import com.su.beloving.service.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beloving")
@RequiredArgsConstructor
public class FlowerController {
    private final FlowerService flowerService;

    @GetMapping("/showFlower")
    public List<Flower> showFlower(@RequestParam(value = "message", required = false, defaultValue = "") String message) throws NoResultsException, NoResultsException {
        return flowerService.showFlower(message);
    }

    @GetMapping("/flowerDetail")
    public Flower flowerDetail(Integer id) throws ArgumentsIllegalException {
        return flowerService.selectById(id);
    }

    @PostMapping("/updateFlower")
    public int updateFlower(@RequestBody Flower flower) throws ArgumentsIllegalException {
        System.out.println(">> " + flower);
        return flowerService.updateFlower(flower);
    }

    @PostMapping("/insertFlower")
    public int insertFlower(@RequestBody Flower flower) throws ArgumentsIllegalException {
        return flowerService.insertFlower(flower);
    }

    @GetMapping("/deleteFlower")
    public int deleteFlower(Integer id) throws ArgumentsIllegalException {
        return flowerService.deleteFlower(id);
    }
}
