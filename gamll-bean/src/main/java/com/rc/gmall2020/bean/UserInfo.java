package com.rc.gmall2020.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
public class UserInfo implements Serializable {
	
	
	//调用mapper注解
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id //表示主键
		@Column //普通的字段列
		@GeneratedValue(strategy = GenerationType.IDENTITY) //获取数据库主键自增
		private String id;
		
		@Column
		
		private String  loginName;
		
		@Column
		
		private String nickName;
		
		@Column
		
		private String passwd;
		
	     @Column
		
		private String name;
	     
	     @Column
	 	
	 	private String phoneNum;
	       
	     @Column
	 	
	 	private String email;
	     
	     @Column
	 	
	 	private String headImg;
	     
	     @Column
	 	
	 	private String userLevel;
	     
	     
		
		
		
		
		

}
