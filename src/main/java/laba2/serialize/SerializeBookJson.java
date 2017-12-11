package laba2.serialize;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import laba2.Book;
import java.io.*;

public class SerializeBookJson implements Serializing<Book> {

    @Override
    public void serializingObj(Book book, Writer out) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.writeValue(out,book);
    }

    @Override
    public Book deserializingObj(Reader in) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        return objectMapper.readValue(in,Book.class);
    }
}