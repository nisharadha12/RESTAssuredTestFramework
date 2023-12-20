package com.apiframework.pojos;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class Users {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
