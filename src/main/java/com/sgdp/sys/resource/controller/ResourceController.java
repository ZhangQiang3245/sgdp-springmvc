package com.sgdp.sys.resource.controller;

import com.sgdp.sys.resource.model.Resource;
import com.sgdp.sys.resource.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZQ on 2018/3/22.
 */
@Controller
@RequestMapping("resouces")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Resource> listResources() {
        Resource resource = resourceService.selectByPrimaryKey("a");
        List lst = new ArrayList<Resource>();
        lst.add(resource);
        lst.add(resource);
        lst.add(resource);
        lst.add(resource);
        lst.add(resource);
        lst.add(resource);
        lst.add(resource);
        lst.add(resource);
        lst.add(resource);
        lst.add(resource);
        lst.add(resource);
        lst.add(resource);
        return lst;
    }
}
