package com.sgdp.sys.resource.dao;

import com.sgdp.sys.resource.model.Resource;

import java.util.List;
import java.util.Map;

public interface ResourceMapper {
    int deleteByPrimaryKey(String resourceid);

    int batchDelete(List<String> resourceids);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String resourceid);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List <Resource> selectAll(Map paramMap);

}