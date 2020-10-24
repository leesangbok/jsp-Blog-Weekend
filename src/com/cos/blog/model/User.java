package com.cos.blog.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getter, Setter
@Builder //생성자
@NoArgsConstructor //기본생성자
@AllArgsConstructor // 풀생성자
// Project lombok 라이브러리 쓰면 Getter, Setter만들어줄 필요도 없이 쓸수 있음
public class User {
	private int id; // 넘버링 1, 2, 3, 4
	private String username; //ssarmango
	private String password;
	private String email;
	private String address;
	private Timestamp createDate;
	
	/*
	 * @Override public String toString() { return "User [id=" + id + ", username="
	 * + username + ", password=" + password + ", email=" + email + ", address=" +
	 * address + ", createDate=" + createDate + "]"; }
	 * 
	 * public User(String username, String password) { this.username = username;
	 * this.password = password; }
	 * 
	 * public User(int id, String username, String email, String address) { this.id
	 * = id; this.username = username; this.email = email; this.address = address; }
	 * 
	 * public User(int id, String username, String password, String email, String
	 * address, Timestamp createDate) { this.id = id; this.username = username;
	 * this.password = password; this.email = email; this.address = address;
	 * this.createDate = createDate; }
	 * 
	 * public User(String username, String password, String email, String address) {
	 * this.username = username; this.password = password; this.email = email;
	 * this.address = address; }
	 */


}
