package com.example.functionalprogramming;

import android.provider.MediaStore;

import java.lang.reflect.Member;

/**
 * @author GK
 * @version 创建时间：2019-4-8 上午11:06:04
 * @ClassName 类名称
 * @Description 类描述
 */
public class Artist {

	/**
	 * 名字
	 */
	private String name;
	/**
	 * 乐队成员
	 */
	private Members members;
	/**
	 * 出生地 城市
	 */
	private String origin;
	/**
	 * 国家
	 */
	private String nationality;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public boolean isFrom(String citys){
		return this.origin.equals(citys);
	}
	public String toString() {
		return "Artist [name=" + name + ", members=" + members + ", origin=" + origin + "]";
	}
	
	
}
