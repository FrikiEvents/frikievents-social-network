package com.frikiteam.socialnetworkboot.application.commands;

import lombok.Value;

@Value
public class EditComment {
    private String id;
    private String content;
}
