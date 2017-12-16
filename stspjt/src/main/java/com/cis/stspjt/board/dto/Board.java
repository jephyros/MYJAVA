package com.cis.stspjt.board.dto;

public class Board {
	
	private int num;
	private String title;
	private String content;
	private String lst_modify_id;
	private String lst_modify_dt;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLst_modify_id() {
		return lst_modify_id;
	}
	public void setLst_modify_id(String lst_modify_id) {
		this.lst_modify_id = lst_modify_id;
	}
	public String getLst_modify_dt() {
		return lst_modify_dt;
	}
	public void setLst_modify_dt(String lst_modify_dt) {
		this.lst_modify_dt = lst_modify_dt;
	}
	

}
