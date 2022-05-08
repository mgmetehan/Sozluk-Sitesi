package com.Dona.SozlukSitesi.dtoComment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentUpdateDto {
    private String text;

    public CommentUpdateDto(String text) {
        this.text = text;
    }
}
