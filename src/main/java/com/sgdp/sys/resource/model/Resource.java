package com.sgdp.sys.resource.model;

public class Resource {
    private String resourceid;

    private String resourcename;

    private String resourcecode;

    private String resourcepath;

    private Integer resourcetype;

    private String resourcesymbol;

    private String remark;

    private String parentresourceid;

    private String resourceicon;

    public String getResourceid() {
        return resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid == null ? null : resourceid.trim();
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename == null ? null : resourcename.trim();
    }

    public String getResourcecode() {
        return resourcecode;
    }

    public void setResourcecode(String resourcecode) {
        this.resourcecode = resourcecode == null ? null : resourcecode.trim();
    }

    public String getResourcepath() {
        return resourcepath;
    }

    public void setResourcepath(String resourcepath) {
        this.resourcepath = resourcepath == null ? null : resourcepath.trim();
    }

    public Integer getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(Integer resourcetype) {
        this.resourcetype = resourcetype;
    }

    public String getResourcesymbol() {
        return resourcesymbol;
    }

    public void setResourcesymbol(String resourcesymbol) {
        this.resourcesymbol = resourcesymbol == null ? null : resourcesymbol.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getParentresourceid() {
        return parentresourceid;
    }

    public void setParentresourceid(String parentresourceid) {
        this.parentresourceid = parentresourceid == null ? null : parentresourceid.trim();
    }

    public String getResourceicon() {
        return resourceicon;
    }

    public void setResourceicon(String resourceicon) {
        this.resourceicon = resourceicon == null ? null : resourceicon.trim();
    }
}