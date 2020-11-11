package com.sripiranavan.springboot.test.dto;

import org.springframework.web.multipart.MultipartFile;

public class UserDetailWithFile {

	private Long id;

	private String name;

	private MultipartFile image;

	public UserDetailWithFile() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
