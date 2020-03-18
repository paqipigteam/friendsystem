package com.paqi.friendsystem.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author PQ
 * @Description 管理员
 * @Date 21:04 18/3/2020
 * @version 3.4.4
**/
@Controller
@RequestMapping("/admin")
public class AdminController {
    /**
     * @author PQ
     * @Description 管理员主页
     * @Date 21:48 18/3/2020
     * @version 3.4.4
    **/
    @GetMapping("/index")
    public String adminIndex() {
        return "/admin-index";
    }
}