package com.sgdp.sys.resource.dao;

import com.sgdp.sys.resource.model.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(String resourceid);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String resourceid);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}