package com.jiyinhui.exam.controller.user;

import com.jiyinhui.exam.controller.user.api.CaptchaCodeRequest;
import com.jiyinhui.exam.controller.user.api.LoginRequest;
import com.jiyinhui.exam.controller.user.api.ModifyPasswordRequest;
import com.jiyinhui.exam.controller.user.api.ServiceResponse;
import com.jiyinhui.exam.entity.User;
import com.jiyinhui.exam.entity.UserCO;
import com.jiyinhui.exam.exception.CaptchaCodeException;
import com.jiyinhui.exam.exception.IllegalRequestException;
import com.jiyinhui.exam.service.MailServiceImpl;
import com.jiyinhui.exam.service.api.IUserService;
import com.jiyinhui.exam.utility.Base64Utility;
import com.jiyinhui.exam.utility.SMSCode;
import com.jiyinhui.exam.utility.ServiceResponseUtility;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private MailServiceImpl mailService;

    @RequestMapping(value = "/user/toNewPassword")
    public String gotoNewPassword() {
        return "user/user_newPassword";
    }

    @RequestMapping(value = "/toForget")
    public String gotoForget() {
        return "user/user_forget";
    }

    @RequestMapping(value = "/toRegist")
    public String gotoRegist() {
        return "user/user_regist";
    }

    @RequestMapping(value = "/toLogin")
    public String gotoLoginPage(HttpSession session) {

        UserCO user = (UserCO)session.getAttribute("user");

        if (user == null) {
            return "user/user_login";
        } else {
           return "menu";
        }
    }

    @RequestMapping(value = "/toMenu")
    public String gotoMenu() {
        return "menu";
    }

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ServiceResponse login(LoginRequest request, HttpSession session) throws Exception {
        String mobile = request.getMobile();
        String password = request.getPassword();

        // base64 加密
        password = new String(Base64Utility.encode(password.getBytes("UTF-8")), "UTF-8");

        User user = new User();
        user.setMobile(mobile);
        user.setPassword(password);

        user = userService.getUserByMobileAndPassword(user);

        ServiceResponse response = new ServiceResponse();
        if (user != null) {

            UserCO userCO = new UserCO();
            userCO.setId(user.getId());
            userCO.setName(user.getName());
            userCO.setUserStatus(user.getUserStatus());

            session.setAttribute("user", userCO);

            return ServiceResponseUtility.success();
        } else {
           return ServiceResponseUtility.fail("用户名或密码错误");
        }
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResponse logout(HttpSession session) {

        session.setAttribute("user", null);

        return ServiceResponseUtility.success();
    }

    /**
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResponse regist(User user) throws Exception {

        String password = user.getPassword();
        password = password = new String(Base64Utility.encode(password.getBytes("UTF-8")), "UTF-8");
        user.setPassword(password);

        User searchUser = userService.getUserByMobile(user.getMobile());

        if (searchUser == null) {
            userService.insertUser(user);
        } else {
            return ServiceResponseUtility.fail("电话: " + user.getMobile() + "已被注册");
        }

        return ServiceResponseUtility.success();
    }

    /**
     * 发送邮件验证码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/email/send", method = RequestMethod.POST)
    public ServiceResponse emailCaptchaSend(@RequestParam("mobile") String mobile, HttpSession session) {

        User user = userService.getUserByMobile(mobile);

        if (user == null) {
            return ServiceResponseUtility.fail("手机号： " + mobile + "不存在");
        }

        String emailCapthcha = SMSCode.getSMSCode(4);

        System.out.println(emailCapthcha);

        mailService.sendSimpleMail(user.getEmail(), "学生考试系统找回密码", emailCapthcha);

        session.setAttribute(mobile, emailCapthcha);

        return ServiceResponseUtility.success("验证码已发送到" + user.getEmail());
    }

    /**
     * 验证邮箱验证码
     */
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResponse verify(CaptchaCodeRequest request, HttpSession session) {


        if (StringUtils.isEmpty(request.getCode())
                || StringUtils.isEmpty(request.getMobile())) {
            throw new IllegalRequestException("参数错误");
        }

        String code = (String)session.getAttribute(request.getMobile());



        if (StringUtils.isEmpty(code)
                || !request.getCode().equals(code)) {
           throw new CaptchaCodeException("验证码不正确");
        }
        session.setAttribute("mobile", request.getMobile());
        return ServiceResponseUtility.success();
    }

    /**
     * 修改密码
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/user/password/modify", method = RequestMethod.POST)
    public ServiceResponse userPasswordModify(ModifyPasswordRequest request, HttpSession session) throws Exception {
        String mobile = (String)session.getAttribute("mobile");

        if (!StringUtils.isBlank(mobile) && request.getPassword1().equals(request.getPassword2())) {
            User user = new User();
            user.setMobile(mobile);
            String password = new String(Base64Utility.encode(request.getPassword1().getBytes("UTF-8")), "UTF-8");
            user.setPassword(password);

            userService.updateUser(user);
        } else {
            return ServiceResponseUtility.fail("修改密码错误");
        }

        return ServiceResponseUtility.success();
    }
}
