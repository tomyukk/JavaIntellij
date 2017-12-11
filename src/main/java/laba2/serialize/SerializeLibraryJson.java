package laba2.serialize;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import laba2.Library;

import javax.xml.bind.JAXBException;
import java.io.*;

public class SerializeLibraryJson implements  Serializing<Library>{

    @Override
    public void serializingObj(Library library, Writer out) throws IOException, Exception {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.writeValue(out,library);

    }

    @Override
    public Library deserializingObj(Reader in) throws IOException, JAXBException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        return objectMapper.readValue(in, Library.class);
    }
}
