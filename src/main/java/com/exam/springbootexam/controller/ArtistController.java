package com.exam.springbootexam.controller;

import com.exam.springbootexam.model.ArtistModel;
import com.exam.springbootexam.service.ArtistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    private final ArtistService service;

    @Autowired
    public ArtistController(ArtistService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<ArtistModel>> getAllArtists() {
        List<ArtistModel> artists = service.getAllArtists();
        return ResponseEntity.ok(artists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistModel> getArtistById(@PathVariable Long id) {
        ArtistModel artist = service.getArtistById(id);
        if (artist != null) {
            return ResponseEntity.ok(artist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ArtistModel> createOrUpdateArtist(@RequestBody ArtistModel artist) {
        ArtistModel createdArtist = service.createOrUpdateArtist(artist);
        return ResponseEntity.ok(createdArtist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        boolean deleted = service.deleteArtist(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
