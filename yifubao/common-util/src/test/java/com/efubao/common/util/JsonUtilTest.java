/**
 * JsonUtilTest.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.common.util;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.efubao.common.util.JsonUtil;

/**
 *
 */
public class JsonUtilTest {
	
	static enum Status {
        ACTIVE, DISABLED;
        public String toString() {
                return name().toLowerCase();
        }
	}
	
	static class User {
	        private String username;
	        private String password;
	        private int age;
	        private Status status;
	        private String info;
	
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
	
	        public int getAge() {
	                return age;
	        }
	
	        public void setAge(int age) {
	                this.age = age;
	        }
	
	        public Status getStatus() {
	                return status;
	        }
	
	        public void setStatus(Status status) {
	                this.status = status;
	        }

			public String getInfo() {
				return info;
			}

			public void setInfo(String info) {
				this.info = info;
			}
	
	}

	/**
	 * test user
	 */
	private User user;
	/**
	 * test json
	 */
	private String json;
	
	/** 
	 * setup
	 * @throws java.lang.Exception 
	 */
	@Before
	public void setUp() throws Exception {
		user = new User();
        user.setUsername("测试");
        user.setPassword("password");
        user.setStatus(Status.ACTIVE);
        user.setAge(2);
        json = "{\"username\":\"测试\",\"password\":\"password\",\"age\":2,\"status\":\"ACTIVE\",\"info\":null}";
	}

	/**
	 * Test method for {@link com.efubao.common.util.JsonUtil#
	 * json2GenericObject(java.lang.String, org.codehaus.jackson.type.TypeReference)}.
	 */
	@Test
	public void testJson2GenericObject() {
		// TODO
	}

	/**
	 * Test method for {@link com.efubao.common.util.JsonUtil#toJson(java.lang.Object)}.
	 */
	@Test
	public void testToJson() {
		String str = JsonUtil.toJson(null);
		Assert.isTrue(str.equals("null"));
		str = JsonUtil.toJson(user);
		Assert.isTrue(str.equals(json));
		User u = (User) JsonUtil.json2Object(str, User.class);
		Assert.isTrue((u.getAge() == 2 && u.getUsername().equals(user.getUsername())));
	}

	/**
	 * Test method for {@link com.efubao.common.util.JsonUtil#json2Object(java.lang.String, java.lang.Class)}.
	 */
	@Test
	public void testJson2Object() {
		User u = (User) JsonUtil.json2Object(json, User.class);
		Assert.isTrue((u.getAge() == 2 && u.getAge() == user.getAge()));
		Assert.isTrue(u.getStatus() == user.getStatus());
	}
	
	/**
	 * test null object
	 */
	@Test
	public void testNull(){
		User u = null;
		String s = JsonUtil.toJson(null);
		User u2 =(User) JsonUtil.json2Object(s, User.class);
		org.junit.Assert.assertEquals(u, u2);
	}

}
