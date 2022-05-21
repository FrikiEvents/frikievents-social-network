package com.frikiteam.socialnetworkboot.application.queries;


import lombok.Data;

@Data
public class GetEventQualificationByIdQuery {
    private String id;

    public GetEventQualificationByIdQuery(String id) {
        this.id = id;
    }
}
