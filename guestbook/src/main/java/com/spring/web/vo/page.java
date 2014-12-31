package com.spring.web.vo;

public class page {
	protected int index;
	protected String email;
	protected String password;
	protected String content;
	protected String writetime;
	protected String modifytime;
	public int getIndex(){return index;}
	public String getEmail(){return email;}
	public String getPassword(){return password;}
	public String getContent(){return content;}	
	public String getWritetime(){return writetime;}
	public String getModifytime(){return modifytime;}
	public page setIndex(int Index){
		this.index = Index;
		return this;
	}
	public page setEmail(String Email){
		this.email = Email;
		return this;
	}
	public page setPassword(String Password){
		this.password = Password;
		return this;
	}
	public page setContent(String Content){
		this.content = Content;
		return this;
	}
	public page setWritetime(String writetime){
		this.writetime = writetime;
		return this;
	}
	public page setModifytime(String modifytime){
		this.modifytime = modifytime;
		return this;
	}
}
