package serializingTest;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import laba2.Book;
import laba2.Library;
import laba2.serialize.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarySerializationTest{
    private Library lib1,lib2;

    @BeforeTest
    public void setObject() throws Exception {
        Book book1,book2,book3;
        ArrayList<String> str1 = new ArrayList<String>();
        str1.add("Franko I.F.");
        str1.add("Shevchenko T.H.");

        ArrayList<String> str2 = new ArrayList<String>();
        str2.add("Merzlyak A.V.");
        str2.add("Polonskiy V.I.");
        str2.add("Jakir D.G.");

        book1 = new Book(str1,"Zbirnik","Kyiv",1980,500);
        book2 = new Book(str2,"Geometriya","Kharkiv",2013,450);
        book3 = new Book(str1,"Mathematica","Chernivtsi",2012,350);
        List<Book> books1 = new ArrayList<Book>();
        books1.add(0,book1);
        books1.add(1,book2);

        List<Book> books2 = new ArrayList<Book>();
        books2.add(book2);
        books2.add(book3);
        lib1 = new Library("Chernivtsi","Central", (List<Book>) books1);
        lib2 = new Library("Kyiv","Student's", (List<Book>) books2);


        SerializeLibraryJson ob=new SerializeLibraryJson();
        Writer out = new FileWriter("test_library.json");
        ob.serializingObj(lib1,out);

        Writer out1 = new FileWriter("test_library.xml");
        ob.serializingObj(lib2,out1);

    }

    @DataProvider
    Object[][] JsonSerializationData() throws IOException{
        String filename = "test_library.json";
        return new Object[][]{
                {new SerializeLibraryJson(),filename}
        };
    }

    @Test(dataProvider = "JsonSerializationData")
    public void JsonSerializationTest(Serializing<Library> libJson,String filename) throws IOException, JAXBException {
        Assert.assertEquals(libJson.deserializingObj(new FileReader(new File(filename))),lib1);
    }

    @DataProvider
    Object[][] XMLSerializationData() throws IOException{
        String filename = "test_library.xml";
        return new Object[][]{
                {new SerializeLibraryXML(),filename}
        };
    }
    @Test(dataProvider = "XMLSerializationData")
    public void XMLSerializationTest(Serializing<Library> libXML,String filename) throws IOException,JAXBException{
        Assert.assertEquals(libXML.deserializingObj(new FileReader(new File(filename))),lib2);
    }


}
