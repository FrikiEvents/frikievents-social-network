package com.frikiteam.frikievents.socialnetworks.command.domain.valueObjects;

import lombok.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Value(staticConstructor = "of")
public class CommentId implements Serializable {
    private UUID value;

    private CommentId(UUID value) {
        this.value = value;
    }

    protected CommentId() {
        this.value = UUID.randomUUID();
    }
}
