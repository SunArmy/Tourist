package com.sunarmy.cn.controller;

import com.sunarmy.cn.datatype.ResponseType;
import com.sunarmy.cn.entity.User;
import com.sunarmy.cn.responsemodel.ResponseDto;
import com.sunarmy.cn.service.UserService;
import com.sunarmy.cn.utils.PasswordUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * Created by wb-wsj429645 on 2018/8/23.
 */
@RestController(value = "/")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping(value = "login")
    public ResponseDto login(User user,String verifyCode,Boolean rememberMe, HttpServletRequest request){

        if (request.getSession().getAttribute(request.getSession().getId()).toString() != verifyCode){
            new ResponseDto(ResponseType.VERIFICATION_CODE_ERROR);
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(rememberMe == Boolean.TRUE ? true:false);
        try {
            SecurityUtils.getSubject().login(token);
        }catch (UnknownAccountException e){
            return new ResponseDto(ResponseType.USER_PASSWORD_INCORRECT,"用户名错误");
        }catch (IncorrectCredentialsException e){
            return new ResponseDto(ResponseType.USER_PASSWORD_INCORRECT,"密码错误");
        }
        request.getSession().setAttribute("userName",user.getUsername());
        request.getSession().setAttribute("token",user.getToken());
        ResponseDto dto = new ResponseDto(ResponseType.SUCCESS);
        dto.setData(user);
        return dto;
    }


    /**
     * 注册用户
     * @param user
     * @return
     */
    @GetMapping(value = "register")
    public ResponseDto register(User user){
        User byUsername = userService.findByUsername(user.getUsername());
        if (byUsername != null){
            return new ResponseDto(ResponseType.FAIL,"用户已存在");
        }
        //获取一个随机盐
        String salt = PasswordUtils.getSalt();
        //加密密码
        String password = PasswordUtils.encryPassword(user.getPassword(),salt);

        user.setSalt(salt);
        user.setPassword(password);
        user.setToken(UUID.randomUUID().toString().replaceAll("-","").toUpperCase());
        user.setCreatedate(new Date().getTime());
        User user1 = userService.insertUser(user);
        ResponseDto responseDto = new ResponseDto(ResponseType.SUCCESS);
        responseDto.setData(user1);
        return responseDto;
    }

    /**
     * 验证改用户是否存在
     * @param username 用户名
     * @return
     */
    @RequestMapping(value = "user/exists",method = RequestMethod.GET)
    public ResponseDto exists(String username){
        User byUsername = userService.findByUsername(username);
        if (byUsername==null){
            return new ResponseDto(ResponseType.SUCCESS);
        }else {
            return new ResponseDto(ResponseType.FAIL);
        }
    }
}
