package laba2.serialize;

import com.thoughtworks.xstream.XStream;
import javax.xml.bind.JAXBException;
import java.io.*;
import laba2.Book;

public class SerializeBookXML implements Serializing<Book>{
    @Override
    public void serializingObj(Book book,Writer out) throws IOException{
        XStream xs= new XStream();
        xs.toXML(book,out);
    }

    @Override
    public Book deserializingObj(Reader in)throws IOException,JAXBException{
        XStream xs = new XStream();
        Book book = new Book();
        xs.fromXML(in,book);
        return  book;
    }


}
