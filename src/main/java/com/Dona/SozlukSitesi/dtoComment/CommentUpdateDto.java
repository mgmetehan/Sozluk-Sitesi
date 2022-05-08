package com.Dona.SozlukSitesi.dtoComment;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CommentUpdateDto {
    @NotBlank(message = "Text cannot be null")
    @Size(min = 5, max = 50, message = "Text size must be between {min} and {max}")
    private String text;

    public CommentUpdateDto(String text) {
        this.text = text;
    }
}
