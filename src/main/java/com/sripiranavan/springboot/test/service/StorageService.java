package com.sripiranavan.springboot.test.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	void init();

	void store(MultipartFile file,String newFileName);

	Stream<Path> loadAll();

	Path load(String filename);

	Resource LoadAsResource(String filename);

	void deleteAll();
}
