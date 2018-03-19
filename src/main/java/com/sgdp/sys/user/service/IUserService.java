package com.sgdp.sys.user.service;

import com.sgdp.sys.user.model.User;

/**
 * Created by ZQ on 2018/3/19.
 */
public interface IUserService {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
