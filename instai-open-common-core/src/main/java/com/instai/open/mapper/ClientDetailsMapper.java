package com.instai.open.mapper;
import com.instai.open.model.ClientDetails;

public interface ClientDetailsMapper {
    int insert(ClientDetails record);

    int insertSelective(ClientDetails record);
}