package com.exam.springbootexam.service;

import com.exam.springbootexam.model.ArtistModel;
import com.exam.springbootexam.repository.ArtistRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private final ArtistRepository repository;

    @Autowired
    public ArtistService(ArtistRepository repository) {
        this.repository = repository;
    }

    public List<ArtistModel> getAllArtists() {
        return repository.findAll();
    }

    public ArtistModel getArtistById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ArtistModel createOrUpdateArtist(ArtistModel artist) {
        return repository.save(artist);
    }

    public boolean deleteArtist(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
