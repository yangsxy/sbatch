package cn.yuan.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yuan.jndi.DataSource;
import cn.yuan.mybatis.dao.CustomerMapper;
import cn.yuan.mybatis.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public int deleteByPrimaryKey(Long customerid) {
		return customerMapper.deleteByPrimaryKey(customerid);
	}

	@Override
	public int insert(Customer record) {
		return customerMapper.insert(record);
	}

	@Override
	public int insertSelective(Customer record) {
		return customerMapper.insertSelective(record);
	}

	@Override
	@DataSource
	public Customer selectByPrimaryKey(Long customerid) {
		return customerMapper.selectByPrimaryKey(customerid);
	}

	@Override
	public int updateByPrimaryKeySelective(Customer record) {
		return customerMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Customer record) {
		return customerMapper.updateByPrimaryKey(record);
	}

}
