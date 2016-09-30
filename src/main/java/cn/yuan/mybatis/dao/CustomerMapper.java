package cn.yuan.mybatis.dao;

import cn.yuan.mybatis.entity.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Long customerid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Long customerid);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}