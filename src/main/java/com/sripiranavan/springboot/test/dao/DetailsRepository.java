package com.sripiranavan.springboot.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sripiranavan.springboot.test.entity.Details;

public interface DetailsRepository extends JpaRepository<Details, Long> {

}
