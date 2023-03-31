package com.example.JWT.Authentication.using.Spring.Boot.service;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
public class ApiResponse<T> {
    private String message;
    private boolean success;
    private T payload;

    public static <P> ApiResponse<P> failure (String message) {
        ApiResponse<P> response = new ApiResponse<> ();
        response.setMessage (message);
        response.payload = null;
        response.success = false;
        return response;
    }

    public static ApiResponse success (String message) {
        ApiResponse response = withMessage (message);
        response.success = true;
        return response;
    }

    public static <P> ApiResponse<P> successWithPayload (P payload, String msg) {
        ApiResponse<P> response = new ApiResponse<> ();
        response.setPayload (payload);
        response.setMessage (msg);
        response.success = true;
        return response;
    }

    private static ApiResponse withMessage (String message) {
        ApiResponse response = new ApiResponse ();
        response.message = message;
        return response;
    }


}
