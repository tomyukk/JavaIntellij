package serializingTest;

import laba2.Book;
import laba2.serialize.SerializeBookJson;
import laba2.serialize.SerializeBookXML;
import laba2.serialize.Serializing;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;

public class BookSerializationTest {
    private Book book1,book2,book3;

    @BeforeTest
    public void setObject() throws IOException {
        ArrayList<String> str1 = new ArrayList<String>();
        str1.add("Franko I.F.");
        str1.add("Shevchenko T.H.");

        ArrayList<String> str2 = new ArrayList<String>();
        str2.add("Merzlyak A.V.");
        str2.add("Polonskiy V.I.");
        str2.add("Jakir D.G.");

        book1 = new Book(str1,"Zbirnik","Kyiv",1980,500);
        book2 = new Book(str2,"Geometriya","Kharkiv",2013,450);
        SerializeBookJson ob=new SerializeBookJson();
        Writer out = new FileWriter("test_book.json");
        ob.serializingObj(book1,out);

        Writer out1 = new FileWriter("test_book.xml");
        ob.serializingObj(book2,out1);
    }

    @DataProvider
    Object[][] JsonSerializationData() throws IOException{
        String filename = "test_book.json";
        return new Object[][] {
                {new SerializeBookJson(),filename}
        };
    }

    @Test(dataProvider = "JsonSerializationData")
    public  void JsonSerializationTest(Serializing<Book> bookJson,String filename) throws IOException, JAXBException {
        Assert.assertEquals(bookJson.deserializingObj(new FileReader(new File(filename))),book1);
    }

    @DataProvider
    Object[][] XMLSerializationData() throws IOException{
        String filename ="test_book.xml";
        return new Object[][]{
                {new SerializeBookXML(),filename}
        };
    }

    @Test(dataProvider = "XMLSerializatonData")
    public void XMLSerializationTest(Serializing<Book> bookXML,String filename) throws IOException, JAXBException{
        Assert.assertEquals(bookXML.deserializingObj(new FileReader(new File(filename))),book2);

    }


}
