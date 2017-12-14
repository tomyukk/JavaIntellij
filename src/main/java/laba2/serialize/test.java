package laba2.serialize;

import laba2.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {

    public static void main(String... strings) throws IOException {
        Book ob = new Book();
        System.out.println(ob.checkPublish("War 12"));
        System.out.println("Program is done!!!");

        List<Book> book = new ArrayList<Book>();

        ArrayList<String> str1 = new ArrayList<String>();
        str1.add("Franko I.F.");
        str1.add("Shevchenko T.H.");

        ArrayList<String> str2 = new ArrayList<String>();
        str2.add("Aerzlyak A.V.");
        str2.add("Polonskiy V.I.");
        str2.add("Jakir D.G.");
        Book book1 = new Book(str1,"Zbirnik","Kyiv",1980,500);
        Book book2 = new Book(str2,"Geometriya","Kharkiv",2013,450);
        book.add(0, book1);
        book.add(1, book2);

        SerializeBookXML objSerialize=new SerializeBookXML();
        Writer out = new FileWriter("test_book2.json");
        objSerialize.serializingObj(book1,out);


    }

}
