package com.frikiteam.socialnetworkboot.service;

import com.frikiteam.frikievents.socialnetworks.command.domain.Comment;
import com.frikiteam.frikievents.socialnetworks.command.domain.EventQualification;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EventQualificationServiceImplTest {

    private final EventQualification eventQualification = new EventQualification();


    @Test
    public void obtenerComentario() {
        Integer expected = 10;
        eventQualification.setStarsQuantity(expected);
        Integer actual = eventQualification.getStarsQuantity();
        assertEquals(expected, actual);
    }

}
