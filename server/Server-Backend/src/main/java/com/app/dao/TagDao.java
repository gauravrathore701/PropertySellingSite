package com.app.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Tags;


public interface TagDao extends JpaRepository<Tags, Long> {

	Optional<Tags> findByTagName(String tagName);

}
