package cn.yuan.mybatis.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="users")
public class User {
		@Id
	    @Column(name = "Id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column
	    private String name;
		@Column
	    private String age;
		@Column
	    private Double balance;
		@Column(name="is_delete")
		private Integer isDelete;
		
	    public Integer getIsDelete() {
			return isDelete;
		}

		public void setIsDelete(Integer isDelete) {
			this.isDelete = isDelete;
		}

		public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }

	    public String getAge() {
	        return age;
	    }

	    public void setAge(String age) {
	        this.age = age == null ? null : age.trim();
	    }

	    public Double getBalance() {
	        return balance;
	    }

	    public void setBalance(Double balance) {
	        this.balance = balance;
	    }

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", age=" + age + ", balance=" + balance + ", isDelete="
					+ isDelete + "]";
		}
	    
}
