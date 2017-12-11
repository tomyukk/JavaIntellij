package laba2.serialize;

import com.thoughtworks.xstream.XStream;
import laba2.Library;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class SerializeLibraryXML implements Serializing<Library> {


    @Override
    public void serializingObj(Library obj, Writer out) throws IOException, Exception {
        XStream xs = new XStream();
        xs.toXML(obj,out);
    }

    @Override
    public Library deserializingObj(Reader in) throws IOException, JAXBException {
        XStream xs= new XStream();
        Library library = new Library();
        xs.fromXML(in, library);
        return library;

    }
}
