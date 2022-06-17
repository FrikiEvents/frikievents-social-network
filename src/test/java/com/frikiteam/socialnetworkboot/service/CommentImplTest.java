package com.frikiteam.socialnetworkboot.service;

import com.frikiteam.frikievents.socialnetworks.command.domain.Comment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommentImplTest {
    private final Comment comment = new Comment();

    @Test
    public void obtenerComentario() {
        String expected = "Este evento es fabuloso";
        comment.setContent(expected);
        String actual = comment.getContent();
        assertEquals(expected, actual);
    }
}
