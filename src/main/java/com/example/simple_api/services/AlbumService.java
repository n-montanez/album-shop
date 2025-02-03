package com.example.simple_api.services;

import java.util.List;
import org.springframework.stereotype.Service;
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
}
