package com.sgdp.sys.resource.service;

import com.sgdp.sys.resource.model.Resource;

import java.util.List;
import java.util.Map;

/**
 * Created by ZQ on 2018/3/22.
 */
public interface IResourceService {
    int deleteByPrimaryKey(String resourceid);

    int batchDelete(List<String> resourceids);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String resourceid);

    List <Resource> selectAll(Map paramMap);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}
