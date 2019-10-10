package com.instai.open.mapper;


import com.instai.open.model.AccessToken;

public interface AccessTokenMapper {
    int insert(AccessToken record);

    int insertSelective(AccessToken record);
}