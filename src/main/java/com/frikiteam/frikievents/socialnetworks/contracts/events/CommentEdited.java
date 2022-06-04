package com.frikiteam.frikievents.socialnetworks.contracts.events;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentEdited {
    private String commentId;
    private String content;

    public CommentEdited() {
    }

    public CommentEdited(String commentId, String content) {
        this.commentId = commentId;
        this.content = content;
    }
}
