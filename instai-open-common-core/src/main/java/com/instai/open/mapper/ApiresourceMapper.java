package com.instai.open.mapper;

import com.instai.open.model.Apiresource;

public interface ApiresourceMapper {
    int insert(Apiresource record);

    int insertSelective(Apiresource record);
}