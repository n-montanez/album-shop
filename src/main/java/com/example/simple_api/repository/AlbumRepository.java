package com.example.simple_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.simple_api.model.Album;

public interface AlbumRepository extends JpaRepository<Album, UUID> {

}
