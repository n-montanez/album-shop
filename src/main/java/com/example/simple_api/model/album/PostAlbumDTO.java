package com.example.simple_api.model.album;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostAlbumDTO {
    private String title;
    private String artistName;
    private Date releaseDate;
    private int tracks;
    private int durationMinutes;
}
