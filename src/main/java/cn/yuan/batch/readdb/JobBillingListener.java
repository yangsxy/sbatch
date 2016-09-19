package cn.yuan.batch.readdb;

import java.util.List;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yuan.jndi.DataSource;
import cn.yuan.mybatis.entity.Bill;
import cn.yuan.mybatis.service.BillService;

public class JobBillingListener extends JobExecutionListenerSupport{
	
	@Autowired
	private BillService billService;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		super.beforeJob(jobExecution);
	}
	
	@Override
	@DataSource
	public void afterJob(JobExecution jobExecution) {
		/*
		 List<Bill> results = dao.query("select * from bills", new RowMapper<Bill>() {  
             @Override  
             public Bill mapRow(ResultSet rs, int row) throws SQLException {  
            	 Bill bill = new Bill();
            	 bill.setId(rs.getLong("id"));
            	 bill.setFees(rs.getDouble("fees"));
            	 bill.setPaidFees(rs.getDouble("paid_fees"));
            	 bill.setUnpaidFees(rs.getDouble("unpaid_fees"));
                 return bill;  
             }  
         });*/  
		List<Bill> results = billService.getAll();
		for (Bill bill : results) {
			System.out.println(bill);
		}
	}

}
