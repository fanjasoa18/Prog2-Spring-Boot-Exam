package com.exam.springbootexam.controller;

import com.exam.springbootexam.model.SongModel;
import com.exam.springbootexam.service.SongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    private final SongService service;

    @Autowired
    public SongController(SongService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public ResponseEntity<List<SongModel>> searchSongByKeyword(@RequestParam("keyword") String keyword) {
        List<SongModel> matchingSongs = service.searchSongByKeywords(keyword);
        return ResponseEntity.ok(matchingSongs);
    }

    @GetMapping("/")
    public ResponseEntity<List<SongModel>> getAllSongs() {
        List<SongModel> songs = service.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongModel> getSongById(@PathVariable Long id) {
        SongModel song = service.getSongById(id);
        if (song != null) {
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<SongModel> createOrUpdateSong(@PathVariable(required = false) Long id,
                                                        @RequestBody SongModel updatedSong) {
        SongModel song = service.createOrUpdateSong(id, updatedSong);
        return ResponseEntity.ok(song);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        boolean deleted = service.deleteSong(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
