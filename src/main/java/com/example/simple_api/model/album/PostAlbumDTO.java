package com.example.simple_api.model.album;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotEmpty(message = "Album title cannot be empty")
    private String title;

    @NotEmpty(message = "Artist name cannot be empty")
    private String artistName;

    @NotNull(message = "Release date cannot be empty")
    private Date releaseDate;

    @Min(value = 1, message = "Need at least 1 track")
    private Integer tracks;

    @Min(value = 10, message = "Album cannot be shorter than 10 minutes")
    private Integer durationMinutes;
}
