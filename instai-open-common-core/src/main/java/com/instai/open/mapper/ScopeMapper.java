package com.instai.open.mapper;
import com.instai.open.model.Scope;

public interface ScopeMapper {
    int insert(Scope record);

    int insertSelective(Scope record);
}