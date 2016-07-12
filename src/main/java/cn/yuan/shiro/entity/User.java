package cn.yuan.shiro.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class User {
	
	private Long id;
	
	private String username;
	
	private String password;
	
	private List<Role> roleList;
	
	public User() {
	}
	
	public User(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	public Set<String> getRolesName(){
		List<Role> roles = getRoleList();
		Set<String> set = new HashSet<>();
		for (Role role : roles) {
			set.add(role.getRoleName());
		}
		return set;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	
	
}
