package com.sgdp.sys.resource.service.impl;

import com.sgdp.sys.resource.dao.ResourceMapper;
import com.sgdp.sys.resource.model.Resource;
import com.sgdp.sys.resource.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ZQ on 2018/3/22.
 */
@Service("resouceService")
public class ResourceServiceImpl implements IResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    public int deleteByPrimaryKey(String resourceid) {
        return resourceMapper.deleteByPrimaryKey(resourceid);
    }

    public int batchDelete(List<String> resourceids) {
        return resourceMapper.batchDelete(resourceids);
    }

    public int insert(Resource record) {
        return resourceMapper.insert(record);
    }

    public int insertSelective(Resource record) {
        return resourceMapper.insertSelective(record);
    }

    public Resource selectByPrimaryKey(String resourceid) {
        return resourceMapper.selectByPrimaryKey(resourceid);
    }

    public List <Resource> selectAll(Map paramMap) {
        return resourceMapper.selectAll(paramMap);
    }

    public int updateByPrimaryKeySelective(Resource record) {
        return resourceMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Resource record) {
        return resourceMapper.updateByPrimaryKey(record);
    }
}

