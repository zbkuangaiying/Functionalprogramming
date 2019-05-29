package com.example.functionalprogramming;

/**
 * @author GK
 * @version 创建时间：2019-4-8 上午11:07:41
 * @ClassName 类名称
 * @Description 类描述
 */
public class Track {

	/**
	 * 曲目名字
	 */
	private String name;

	/**
	 * 曲目时间
	 */
	private int duration;

	public Track(){

	}

	public Track(String names,int durations){
		this.name = names;
		this.duration = durations;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Track{" +
				"name='" + name + '\'' +
				", duration=" + duration +
				'}';
	}
}
