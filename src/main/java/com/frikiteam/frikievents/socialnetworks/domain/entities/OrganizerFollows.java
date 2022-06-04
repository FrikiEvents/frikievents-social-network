package com.frikiteam.frikievents.socialnetworks.domain.entities;


import com.frikiteam.frikievents.socialnetworks.domain.values.OrganizerFollowsId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "organizer_follws")
@Data
public class OrganizerFollows {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
    })
    private OrganizerFollowsId id;

    public OrganizerFollows(OrganizerFollowsId organizerFollowsId) {
        this.id = organizerFollowsId;
    }

    public OrganizerFollows() {}

}
