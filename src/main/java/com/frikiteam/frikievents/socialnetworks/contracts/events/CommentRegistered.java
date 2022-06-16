package com.frikiteam.frikievents.socialnetworks.contracts.events;

import com.frikiteam.frikievents.socialnetworks.command.domain.valueObjects.CommentId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRegistered {
    private CommentId commentId;
    private String content;

    public CommentRegistered() {
    }

    public CommentRegistered(CommentId commentId, String content) {
        this.commentId = commentId;
        this.content = content;
    }
}
