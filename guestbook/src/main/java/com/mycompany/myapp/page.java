package com.mycompany.myapp;

import java.sql.Timestamp;

public class page {
	protected int index;
	protected String email;
	protected String password;
	protected String content;
	protected Timestamp createdDate;
	protected Timestamp modifiedDate;
	public int getIndex(){return index;}
	public String getEmail(){return email;}
	public String getPassword(){return password;}
	public String getContent(){return content;}	
	public Timestamp getCreatedDate(){return createdDate;}
	public Timestamp getModifiedDate(){return modifiedDate;}
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
	public page setCreatedDate(Timestamp CreatedDate){
		this.createdDate = CreatedDate;
		return this;
	}
	public page setModifiedDate(Timestamp ModifiedDate){
		this.modifiedDate = ModifiedDate;
		return this;
	}
}
