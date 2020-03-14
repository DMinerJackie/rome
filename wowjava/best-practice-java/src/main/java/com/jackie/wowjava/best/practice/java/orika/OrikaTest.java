package com.jackie.wowjava.best.practice.java.orika;

import com.alibaba.fastjson.JSON;
import com.jackie.wowjava.best.practice.java.orika.model.BookDTO;
import com.jackie.wowjava.best.practice.java.orika.model.BookEntity;
import com.jackie.wowjava.best.practice.java.orika.model.BookInfo;
import com.jackie.wowjava.best.practice.java.orika.model.BookType;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class OrikaTest {

    private static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    public static void main(String[] args) {

        BookEntity bookEntity = new BookEntity(
                "银河系漫游指南",
                "道格拉斯·亚当斯",
                Date.from(LocalDate.of(1952, Month.MARCH, 11).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                "{\"ISBN\": \"9787532754687\", \n \"page\": 279\n }",
                1);


        mapperFactory.getConverterFactory().registerConverter("bookTypeConvert", new BidirectionalConverter<BookType, Integer>() {
            @Override
            public Integer convertTo(BookType bookType, Type<Integer> type, MappingContext mappingContext) {
                return bookType.getValue();
            }

            @Override
            public BookType convertFrom(Integer value, Type<BookType> type, MappingContext mappingContext) {
                return BookType.getBookType(value);
            }
        });

        mapperFactory.getConverterFactory().registerConverter("bookInfoConvert", new BidirectionalConverter<BookInfo, String>() {
            @Override
            public String convertTo(BookInfo bookInfo, Type<String> type, MappingContext mappingContext) {
                return JSON.toJSONString(bookInfo);
            }

            @Override
            public BookInfo convertFrom(String s, Type<BookInfo> type, MappingContext mappingContext) {
                return JSON.parseObject(s, BookInfo.class);
            }
        });

        mapperFactory.classMap(BookDTO.class, BookEntity.class)
                .field("author.name", "authorName")
                .field("author.birthday", "authorBirthday")
                .fieldMap("bookType", "type").converter("bookTypeConvert").add()
                .fieldMap("bookInfo", "bookInformation").converter("bookInfoConvert").add()
                .byDefault()
                .register();

        BookDTO bookDTO = mapperFactory.getMapperFacade().map(bookEntity, BookDTO.class);

        System.out.println(JSON.toJSONString(bookDTO));
    }
}
