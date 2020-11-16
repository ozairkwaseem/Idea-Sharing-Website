package com.ozair.javaspringbasics.GreatIdeas.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozair.javaspringbasics.GreatIdeas.models.Ideas;

@Repository
public interface IdeasRepository extends CrudRepository<Ideas, Long> {
	List<Ideas> findAll();
}