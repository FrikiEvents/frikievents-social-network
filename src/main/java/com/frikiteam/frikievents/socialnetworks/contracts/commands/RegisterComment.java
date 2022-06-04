package com.frikiteam.frikievents.socialnetworks.contracts.commands;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
public class RegisterComment {
    @TargetAggregateIdentifier
    private String commentId;
    private String content;

    public RegisterComment() {
    }

    public RegisterComment(String commentId, String content) {
        this.commentId = commentId;
        this.content = content;
    }
}
