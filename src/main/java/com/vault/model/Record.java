package com.vault.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.vault.model.Record;
@Entity
public class Record {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private long id;
	@Column(unique = true)
	private String title;
	private String password;
	private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String key) {
		this.title = key;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String content) {
		this.password = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String note) {
		this.description = note;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Entry [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", password=");
		builder.append(password);
		builder.append(", note=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	
}
