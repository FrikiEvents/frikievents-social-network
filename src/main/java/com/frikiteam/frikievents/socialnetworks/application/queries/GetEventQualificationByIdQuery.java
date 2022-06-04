package com.frikiteam.frikievents.socialnetworks.application.queries;


import lombok.Data;

@Data
public class GetEventQualificationByIdQuery {
    private String id;

    public GetEventQualificationByIdQuery(String id) {
        this.id = id;
    }
}
