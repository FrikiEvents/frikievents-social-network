package com.frikiteam.frikievents.socialnetworks.command.application.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditEventQualificationResponse {

    private Integer starsQuantity;



    public EditEventQualificationResponse( Integer starsQuantity) {

        this.starsQuantity = starsQuantity;
    }
}
