package com.example.functionalprogramming;

import java.util.List;



/**
 * @author GK
 * @version 创建时间：2019-4-8 上午11:08:05
 * @ClassName 类名称
 * @Description 类描述
 */
public class Album {

	/**
	 * 专辑的名字
	 */
	private String name;
	/**
	 * 专辑所包含的曲目
	 */
	private List<Track> tracks ;
	/**
	 * 专辑所包含的艺术家
	 */
	private List<Artist> musicians;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	public List<Artist> getMusicians() {
		return musicians;
	}
	public void setMusicians(List<Artist> musicians) {
		this.musicians = musicians;
	}
	public String toString() {
		return "Album [name=" + name + ", tracks=" + tracks.toString() + ", musicians=" + musicians.toString()+ "]";
	}
	
	
}
