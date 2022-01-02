package com.su.beloving.controller;

import com.su.beloving.common.exception.ArgumentsIllegalException;
import com.su.beloving.common.exception.NoResultsException;
import com.su.beloving.dto.OrderDetail;
import com.su.beloving.po.Order;
import com.su.beloving.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/beloving")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/insertOrder")
    public int insertOrder(Integer userId,Integer flowerId,Integer money,String oaddress,Integer pay) throws ArgumentsIllegalException {
        return orderService.insertOrder(userId,flowerId,money,oaddress,pay);
    }

    @GetMapping("/showOrder")
    public List<Order> showOrder(
            @RequestParam(value = "message", defaultValue = "", required = false) String message
    ) throws NoResultsException {
        return orderService.showOrder(message);
    }

    @GetMapping("/deleteOrder")
    public int deleteOrder(int id) throws ArgumentsIllegalException {
        return orderService.deleteOrder(id);
    }

    @GetMapping("/payOrder")
    public int payOrder(Integer id) throws ArgumentsIllegalException {
        return orderService.payOrder(id);
    }

    @GetMapping("/queryOrder")
    public List<OrderDetail> queryOrder(Integer userId)throws ArgumentsIllegalException,NoResultsException {
        return orderService.selectOrder(userId);
    }
}
