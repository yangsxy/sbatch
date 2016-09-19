package cn.yuan.mybatis.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="bills")
public class Bill {
	@Id
	private Long id;
	@Column
	private Double fees;
	@Column(name="paid_fees")
	private Double paidFees;
	@Column(name="unpaid_fees")
	private Double unpaidFees;
	@Column(name="pay_status")
	private int payStatus;
	@Column(name="user_id")
	private Long userId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public Double getPaidFees() {
		return paidFees;
	}

	public void setPaidFees(Double paidFees) {
		this.paidFees = paidFees;
	}

	public Double getUnpaidFees() {
		return unpaidFees;
	}

	public void setUnpaidFees(Double unpaidFees) {
		this.unpaidFees = unpaidFees;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", fees=" + fees + ", paidFees=" + paidFees + ", unpaidFees=" + unpaidFees
				+ ", payStatus=" + payStatus + ", userId=" + userId + "]";
	}

}
