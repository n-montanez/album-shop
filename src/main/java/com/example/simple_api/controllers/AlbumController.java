package com.example.simple_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple_api.handlers.AlbumModelAssembler;
import com.example.simple_api.model.album.Album;
import com.example.simple_api.model.album.PostAlbumDTO;
import com.example.simple_api.services.AlbumService;
import lombok.RequiredArgsConstructor;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/album")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;
    private final AlbumModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Album>> getAllAlbums() {
        List<EntityModel<Album>> albums = albumService.allAlbums().stream()
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(albums,
                linkTo(methodOn(AlbumController.class).getAllAlbums()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Album> getAlbumById(@PathVariable UUID id) {
        return assembler.toModel(albumService.albumById(id));
    }

    @PostMapping
    public EntityModel<Album> newAlbum(@RequestBody PostAlbumDTO albumDTO) {
        return assembler.toModel(albumService.createAlbum(albumDTO));
    }

}
