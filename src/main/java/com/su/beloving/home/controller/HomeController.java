package com.su.beloving.home.controller;

import com.su.beloving.home.entity.Flower;
import com.su.beloving.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beloving")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;
    @GetMapping("/home")
    public List<Flower> show(@RequestParam(value = "message",required = false,defaultValue ="") String message){
        return homeService.show(message);
    }
    @GetMapping("/flowerDetail")
    public Flower detail(@RequestParam Integer id){
        return homeService.selectOne(id);
    }



}
