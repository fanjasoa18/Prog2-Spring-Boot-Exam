package com.exam.springbootexam.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "artist")
@Data
public class ArtistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
}
