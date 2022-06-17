package com.frikiteam.socialnetworkboot.service;

import com.frikiteam.frikievents.socialnetworks.command.application.services.EventQualificationApplicationService;
import com.frikiteam.frikievents.socialnetworks.command.domain.Comment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


public class EventQualificationServiceImplTest {

    private final Comment comment = new Comment();

    //@Autowired
    //EventQualificationApplicationService eventQualificationApplicationService;

    @Test
    public void obtenerComentario() {
        String expected = "Este evento es fabuloso";
        comment.setContent(expected);
        String actual = comment.getContent();
        assertEquals(expected, actual);
    }

}
