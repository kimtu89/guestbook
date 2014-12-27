package com.mycompany.myapp;

import java.util.Date;

public class page {
	protected int index;
	protected String email;
	protected String password;
	protected String content;
	protected Date createdDate;
	protected Date modifiedDate;
	public int getIndex(){return index;}
	public String getEmail(){return email;}
	public String getPassword(){return password;}
	public String getContent(){return content;}	
	public Date getCreatedDate(){return createdDate;}
	public Date getModifiedDate(){return modifiedDate;}
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
	public page setCreatedDate(Date CreatedDate){
		this.createdDate = CreatedDate;
		return this;
	}
	public page setModifiedDate(Date ModifiedDate){
		this.modifiedDate = ModifiedDate;
		return this;
	}
}
