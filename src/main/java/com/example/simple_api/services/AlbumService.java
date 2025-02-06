package com.example.simple_api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.example.simple_api.model.album.Album;
import com.example.simple_api.model.album.PostAlbumDTO;
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
        return albumRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Album " + id));
    }

    public Album createAlbum(PostAlbumDTO albumDTO) {
        Album newAlbum = Album.builder()
                .title(albumDTO.getTitle())
                .artistName(albumDTO.getArtistName())
                .durationMinutes(albumDTO.getDurationMinutes())
                .releaseDate(albumDTO.getReleaseDate())
                .tracks(albumDTO.getTracks())
                .build();

        return albumRepository.save(newAlbum);
    }
}
