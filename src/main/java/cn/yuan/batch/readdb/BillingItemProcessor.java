package cn.yuan.batch.readdb;

import org.springframework.batch.item.ItemProcessor;

import cn.yuan.batch.User;
import cn.yuan.mybatis.entity.Bill;

public class BillingItemProcessor implements ItemProcessor<User,Bill>{

	public Bill process(User item) throws Exception {
		Bill b = new Bill();
		b.setUserId(item.getId());
		b.setFees(70.00);
		b.setPaidFees(2.0);
		b.setUnpaidFees(70.00);
		b.setPayStatus(1);
		return b;
	}

}
