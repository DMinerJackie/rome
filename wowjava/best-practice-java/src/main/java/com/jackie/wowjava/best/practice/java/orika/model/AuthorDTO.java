package com.jackie.wowjava.best.practice.java.orika.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private String name;

    private Date birthday;
}
