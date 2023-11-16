package com.dilson.blogtunesapi.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private String image;
}
