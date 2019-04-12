package com.zhe.pojo;

public class Sick {

	private int uid;
	private String uname;
	private String sex;
	private int age;
	private String sickroom ;
	private String advice;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSickroom() {
		return sickroom;
	}
	public void setSickroom(String sickroom) {
		this.sickroom = sickroom;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advice == null) ? 0 : advice.hashCode());
		result = prime * result + age;
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result
				+ ((sickroom == null) ? 0 : sickroom.hashCode());
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sick other = (Sick) obj;
		if (advice == null) {
			if (other.advice != null)
				return false;
		} else if (!advice.equals(other.advice))
			return false;
		if (age != other.age)
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (sickroom == null) {
			if (other.sickroom != null)
				return false;
		} else if (!sickroom.equals(other.sickroom))
			return false;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sick [uid=" + uid + ", uname=" + uname + ", sex=" + sex
				+ ", age=" + age + ", sickroom=" + sickroom + ", advice="
				+ advice + "]";
	}
	
	
	public Sick() {
		super();
	}
	public Sick(int uid, String uname, String sex, int age, String sickroom,
			String advice) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.sex = sex;
		this.age = age;
		this.sickroom = sickroom;
		this.advice = advice;
	}
	
	
}
