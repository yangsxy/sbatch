package cn.yuan.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.yuan.mybatis.dao.BillMapper;
import cn.yuan.mybatis.entity.Bill;

@Component("billService")
public class BillService {
	@Autowired
	private BillMapper billMapper;
	
	public List<Bill> getAll(){
		return billMapper.selectAll();
	}
}
