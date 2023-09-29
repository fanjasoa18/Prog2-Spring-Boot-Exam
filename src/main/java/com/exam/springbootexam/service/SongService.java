package com.exam.springbootexam.service;

import com.exam.springbootexam.model.SongModel;
import com.exam.springbootexam.repository.SongRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final SongRepository repository;

    @Autowired
    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    public List<SongModel> searchSongByKeywords(String keyword) {
        return repository.findByLyricsContaining(keyword);
    }

    public List<SongModel> getAllSongs() {
        return repository.findAll();
    }

    public SongModel getSongById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public SongModel createOrUpdateSong(Long id, SongModel updatedSong) {
        Optional<SongModel> existingSong = repository.findById(id);
        if (existingSong.isPresent()) {
            SongModel songToUpdate = existingSong.get();
            songToUpdate.setTitle(updatedSong.getTitle());
            songToUpdate.setLyrics(updatedSong.getLyrics());
            songToUpdate.setAlbum(updatedSong.getAlbum());
            songToUpdate.setReleaseYear(updatedSong.getReleaseYear());

            return repository.save(songToUpdate);
        }else {
            return repository.save(updatedSong);
        }
    }

    public boolean deleteSong(Long id) {
        SongModel existingSong = repository.findById(id).orElse(null);
        if (existingSong != null) {
            repository.delete(existingSong);
            return true;
        } else {
            return false;
        }
    }
}
