package com.instai.open.mapper;

import com.instai.open.model.OpenId;

public interface OpenIdMapper {
    int insert(OpenId record);

    int insertSelective(OpenId record);
}