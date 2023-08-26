package com.project.jokes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Joke {
    private Long id;
    private String content;
    private String category;
    private Boolean approved;

}
