package com.Dona.SozlukSitesi.dtoPost;

import com.Dona.SozlukSitesi.model.Post;
import lombok.Data;

import java.util.Date;

@Data
public class PostViewDto {

    private Long id;
    private Long userId;
    private String title;
    private String text;
    private Date createDate;

    public PostViewDto(Long id, Long userId, String title, String text, Date createDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.createDate = createDate;
    }

    public static PostViewDto of(Post post) {
        return new PostViewDto(post.getId(), post.getUser().getId(), post.getTitle(), post.getText(), post.getCreateDate());
    }
}
