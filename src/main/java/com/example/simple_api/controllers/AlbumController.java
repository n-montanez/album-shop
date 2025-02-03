package com.example.simple_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.simple_api.model.Album;
import com.example.simple_api.services.AlbumService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/album")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.allAlbums();
    }

    @GetMapping("/{id}")
    public Album getAlbumById(@PathVariable UUID id) {
        return albumService.albumById(id);
    }

}
