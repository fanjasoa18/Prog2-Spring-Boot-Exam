package com.exam.springbootexam.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "song")
@Data
public class SongModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String duration;
    private String album;
    private int releaseYear;
    private String lyrics;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistModel artist;
}
