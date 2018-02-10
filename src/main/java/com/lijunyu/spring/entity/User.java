package com.lijunyu.spring.entity;

import java.sql.Date;

/**
 * 
 * @Description: TODO
 * @version 1.0.2
 * @author lijunyu
 * @date 2017��8��21������10:24:59
 */
public class User {
	private Integer userId;
	private String username;
	private String password;
	private String userEmail;

	private Date createtime;
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getUserPassword() {
		return password;
	}

	public void setUserPassword(String userPassword) {
		this.password = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + username + ", userPassword=" + password + ", userEmail="
				+ userEmail + "]";
	}
}
