package laba2.serialize;

import javax.xml.bind.JAXBException;
import java.io.*;

public interface Serializing<T> {

    void serializingObj(T obj, Writer out) throws IOException, Exception;

    T deserializingObj(Reader in)throws IOException, JAXBException;

}