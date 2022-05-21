package com.frikiteam.socialnetworkboot.application.enums;

public enum RequestBodyType {
  VALID {
    public String toString() {
      return "VALID";
    }
  },
  INVALID {
    public String toString() {
      return "INVALID";
    }
  },
}