package com.example.simple_api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.simple_api.errors.ResourceNotFoundException;
import com.example.simple_api.model.Album;
import com.example.simple_api.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    public List<Album> allAlbums() {
        return albumRepository.findAll();
    }

    public Album albumById(UUID id) {
        return albumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Album", id));
    }
}
