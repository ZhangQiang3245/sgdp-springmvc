package com.sgdp.sys.resource.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sgdp.sys.resource.model.Resource;
import com.sgdp.sys.resource.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ZQ on 2018/3/22.
 */
@Controller
@RequestMapping("resources")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map listResources(int limit, int offset,String sort,String order) {
        Map paramMap = new HashMap();
        paramMap.put("sort", sort);
        paramMap.put("order", order);
        PageHelper.startPage(offset, limit);
        List <Resource> resourceLst = resourceService.selectAll(paramMap);
        PageInfo pageInfo = new PageInfo(resourceLst);
        Map <String, Object> result = new HashMap <String, Object>();
        result.put("total", pageInfo.getTotal());
        result.put("rows", resourceLst);
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map addResource(Resource resource) {
        resource.setResourceid(UUID.randomUUID().toString());
        int n = resourceService.insert(resource);
        Map map = new HashMap();
        if (n < 1) {
            map.put("code", -1);
        } else {
            map.put("code", 1);
        }
        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map deleteResource(@RequestBody Map <String, Object> maps) {
        List <String> ids = (List <String>) maps.get("resourceids");
        int n = resourceService.batchDelete(ids);
        Map map = new HashMap(16);
        if (n < 1) {
            map.put("code", -1);
        } else {
            map.put("code", 1);
        }
        return map;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map updateResource(Resource resource) {
        int n = resourceService.updateByPrimaryKey(resource);
        Map map = new HashMap(16);
        if (n < 1) {
            map.put("code", -1);
        } else {
            map.put("code", 1);
        }
        return map;
    }
}
