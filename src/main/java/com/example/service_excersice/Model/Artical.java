package com.example.service_excersice.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Artical {

    @NotNull(message = " ID can not be null ")
    private int id;

    @NotEmpty(message = " Title cannot be empty ")
    @Size(min = 20 , max = 100 , message ="Title Max length between 20-100 characters")
    private String title;

    @NotEmpty(message = " Author Can not be Empty ")
    @Size(min = 5 ,max = 20 , message = " Author must be more than 4 - 20 characters  ")
    private String author;

    @NotEmpty(message =  "Content can not be empty ")
    @Size(min = 20 , message = "Content must be more than 200 characters ")
    private String content;

    @NotEmpty(message = " Category Can not be Empty ")
    @Pattern(regexp = "^(politics|sports|technology)$", message = " Category Must be either politics, sports or technology only. ")
    private String category;

    @NotEmpty(message = "imageURL Can not be Empty  ")
    private String imageURL;

    @AssertFalse(message = "isPublished must be initial false")
    private Boolean isPublished;

    private LocalDate publishDate;

}
