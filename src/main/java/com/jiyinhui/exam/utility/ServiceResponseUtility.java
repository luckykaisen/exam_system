package com.jiyinhui.exam.utility;

import com.jiyinhui.exam.controller.user.api.ServiceResponse;

public class ServiceResponseUtility {

    public static ServiceResponse success() {
        ServiceResponse response = new ServiceResponse();
        response.setCode("200");
        response.setMessage("成功");

        return response;
    }

    public static ServiceResponse success(String message) {
        ServiceResponse response = new ServiceResponse();
        response.setCode("200");
        response.setMessage(message);

        return response;
    }

    public static ServiceResponse fail() {
        ServiceResponse response = new ServiceResponse();
        response.setCode("500");
        response.setMessage("失败");

        return response;
    }

    public static ServiceResponse fail(String message) {
        ServiceResponse response = new ServiceResponse();
        response.setCode("500");
        response.setMessage(message);

        return response;
    }

    public static ServiceResponse fail(String code, String message) {
        ServiceResponse response = new ServiceResponse();
        response.setCode(code);
        response.setMessage(message);

        return response;
    }
}
