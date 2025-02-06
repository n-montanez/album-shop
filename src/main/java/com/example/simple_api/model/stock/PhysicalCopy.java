package com.example.simple_api.model.stock;

import java.util.UUID;

import com.example.simple_api.model.album.Album;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

@Entity
@Table(name = "physical_copies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhysicalCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Available copies should be specified")
    @Min(value = 0, message = "Available copies value should be positive")
    @Max(value = 25, message = "Internal policies do not allow acquiring more than 25 albums")
    private Integer availableCopies;

    @NotNull(message = "Media type should be specified")
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @Min(value = 0, message = "Price value should be positive")
    private Integer price;

    @Default
    private Boolean signed = false;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;
}
