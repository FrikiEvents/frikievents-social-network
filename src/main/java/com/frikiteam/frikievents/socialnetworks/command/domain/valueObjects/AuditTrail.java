package com.frikiteam.frikievents.socialnetworks.command.domain.valueObjects;



import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import lombok.Value;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Embeddable
@Value
public class AuditTrail {
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "created_by"))
    })
    private CommentId createdBy;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "updated_by"))
    })
    private CommentId updatedBy;

    private AuditTrail(LocalDateTime createdAt, LocalDateTime updatedAt, CommentId createdBy, CommentId updatedBy) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    protected AuditTrail() {
        this.createdAt = null;
        this.updatedAt = null;
        this.createdBy = null;
        this.updatedBy = null;
    }

    public static Result<AuditTrail, Notification> create(UUID createdBy) {
        return Result.success(new AuditTrail(LocalDateTime.now(ZoneOffset.UTC), null, CommentId.of(createdBy), null));
    }
}
