package com.example.backend.controller;

import com.example.backend.service.UserService;
import com.example.backend.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    /*localhost:8083 시 login 으로 redirect
    @return*/
    @GetMapping
    public String root() {
        return "redirect:/login";
    }

    /*로그인 폼
    @return*/
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /*로그인 실패 폼
    @return*/
    @GetMapping("/denied")
    public String accessDenied() {
        return "denied";
    }

    /*유저 페이지
    @param model
    @param authentication
    @return*/
    @GetMapping("/access")
    public String userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        UserVo userVo = (UserVo) authentication.getPrincipal(); //userDetail 객체를 가져옴
        model.addAttribute("info", userVo.getUserId() +"의 "+ userVo.getUserName()+ "님"); //유저 아이디
        return "access";
    }

    /*회원가입 폼
    @return*/
    @GetMapping("/signup")
    public String signUpForm() {
        return "signup";
    }

    /*회원가입 진행
    @param user
    @return*/
    @PostMapping("/signup")
    public String signUp(UserVo userVo) {
        userService.joinUser(userVo);
        return "redirect:/login";
    }
}
