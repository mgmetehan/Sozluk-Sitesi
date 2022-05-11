package com.Dona.SozlukSitesi.dto.dtoComment;

import com.Dona.SozlukSitesi.model.Comment;
import lombok.Data;

import java.util.Date;

@Data
public class CommentViewDto {
    private Long id;

    private Long postId;

    private Long userId;

    private String userName;

    private String text;

    private Date createDate;


    public CommentViewDto(Long id, Long postId, Long userId, String userName, String text, Date createDate) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.createDate = createDate;
    }

    public static CommentViewDto of(Comment comment) {
        return new CommentViewDto(comment.getId(), comment.getPost().getId(), comment.getUser().getId(),
                comment.getUser().getUserName(), comment.getText(), comment.getCreateDate());
    }
}
