package com.jackie.wowjava.best.practice.java.orika.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDTO {

    private String bookName;

    private AuthorDTO author;

    private BookType bookType;

    private BookInfo bookInfo;
}
