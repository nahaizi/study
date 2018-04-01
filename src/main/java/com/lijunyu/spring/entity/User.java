package com.lijunyu.spring.entity;

import java.sql.Date;

/**
 * 
 * @Description: TODO
 * @version 1.0.2
 * @author lijunyu
 * @date 2018年3月1日上午11:24:59
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
