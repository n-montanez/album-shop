package com.example.simple_api.handlers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.simple_api.controllers.AlbumController;
import com.example.simple_api.model.album.Album;

@Component
public class AlbumModelAssembler implements RepresentationModelAssembler<Album, EntityModel<Album>> {

    @Override
    public @NonNull EntityModel<Album> toModel(@NonNull Album album) {
        return EntityModel.of(album,
                linkTo(methodOn(AlbumController.class).getAlbumById(album.getId())).withSelfRel(),
                linkTo(methodOn(AlbumController.class).getAllAlbums()).withRel("albums"));
    }
}
