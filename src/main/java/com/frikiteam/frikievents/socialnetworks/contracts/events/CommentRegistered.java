package com.frikiteam.frikievents.socialnetworks.contracts.events;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRegistered {
    private String commentId;
    private String content;

    public CommentRegistered() {
    }

    public CommentRegistered(String commentId, String content) {
        this.commentId = commentId;
        this.content = content;
    }
}
