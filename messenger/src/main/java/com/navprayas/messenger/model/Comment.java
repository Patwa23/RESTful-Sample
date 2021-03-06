package com.navprayas.messenger.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Comment {
	@Id
	private long id;
	private String message;
	private Date created;
	private String author;
	
	public Comment(){
	}
	
	/**
	 * @param id
	 * @param message
	 * @param created
	 * @param author
	 */
	public Comment(long id, String message, Date created, String author) {
		this.id = id;
		this.message = message;
		this.created = created;
		this.author = author;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}
