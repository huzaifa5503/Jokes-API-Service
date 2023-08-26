package com.project.jokes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JokeRequestDto {
    private String content;
    private String category;
}
