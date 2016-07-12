package cn.yuan.batch.method2;

import org.springframework.batch.item.ItemProcessor;

import cn.yuan.batch.User;

public class BillingItemProcessor implements ItemProcessor<User,Bill>{

	public Bill process(User item) throws Exception {
		Bill b = new Bill();
		b.setUser(item);
		b.setFees(70.00);
		b.setPaidFees(0.0);
		b.setUnpaidFees(70.00);
		b.setPayStatus(0);
		return b;
	}

}
