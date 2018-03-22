package com.sgdp.sys.resource.service;

import com.sgdp.sys.resource.model.Resource;

/**
 * Created by ZQ on 2018/3/22.
 */
public interface IResourceService {
    int deleteByPrimaryKey(String resourceid);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String resourceid);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}
