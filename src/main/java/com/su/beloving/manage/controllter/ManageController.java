package com.su.beloving.manage.controllter;

import com.su.beloving.login.entity.User;
import com.su.beloving.manage.service.ManageService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beloving")
@RequiredArgsConstructor
public class ManageController {
    private final ManageService manageService;
    @GetMapping("/updateFlower")
    public int updateFlower(String jsonObj){
        return manageService.updateFlower(jsonObj);
    }
    @GetMapping("/insertFlower")
    public int insertFlower(String jsonObj){
        return manageService.insertFlower(jsonObj);
    }
    @GetMapping("/deleteFlower")
    public int deleteFlower(Integer id){
        return manageService.deleteFlower(id);
    }
    @GetMapping("/deleteUser")
    public int deleteUser(Integer id){
        return manageService.deleteUser(id);
    }
    @GetMapping("/showUser")
    public List<User> showUser(@RequestParam(value = "message",defaultValue = "",required = false) String message){
        return manageService.showUser(message);
    }
}
