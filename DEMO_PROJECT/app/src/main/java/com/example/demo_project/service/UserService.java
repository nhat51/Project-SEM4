package com.example.demo_project.service;

import com.example.demo_project.entity.LoginDto;
import com.example.demo_project.entity.LoginToken;
import com.example.demo_project.entity.User;
import com.example.demo_project.entity.UserDto;
import com.example.demo_project.entity.UserResponse;
import com.example.demo_project.entity.WordResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {
    @POST("api/v1/users/login")
    Call<UserResponse> login(@Body LoginDto loginDto);

    @POST("/api/v1/user/users/save")
    Call<UserDto> register(@Body UserDto user);

    @POST("/api/v1/user/users/setRemindTime")
    Call<UserDto> setRemindTime(@Query("startTime")String startTime,@Query("endTime")String endTime);

    @GET("/api/v1/user/users/get-profile")
    Call<UserDto> getUserAccountDetails(@Query("user-id") int userId);
}
