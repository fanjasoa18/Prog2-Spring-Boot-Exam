package com.exam.springbootexam.repository;

import com.exam.springbootexam.model.ArtistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistModel, Long> {
}
