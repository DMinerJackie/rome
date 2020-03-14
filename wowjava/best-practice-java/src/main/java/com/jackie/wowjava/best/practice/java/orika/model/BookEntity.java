package com.jackie.wowjava.best.practice.java.orika.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    private String bookName;

    private String authorName;

    private Date authorBirthday;

    private String bookInformation;

    private Integer type;

}
