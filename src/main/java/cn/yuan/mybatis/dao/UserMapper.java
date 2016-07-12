package cn.yuan.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import cn.yuan.mybatis.entity.User;
import cn.yuan.mybatis.util.MyMapper;

public interface UserMapper extends MyMapper<User>{

	User selectUserByName(@Param("name")String name);
}
