package laba2.serialize;

import laba2.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
       Book obj = new Book();
        ArrayList<String> str = new ArrayList<String>();
        str.add("Franko I.F.");
        str.add("Shevchenko T.H.");
       obj.setcntPage(50);
       obj.setAthours(str);
       obj.setYear(1970);
       obj.setPublish("kyiv");
       obj.setName("war and peace");

       SerializeBookJson ob=new SerializeBookJson();
        Writer out = new FileWriter("temp.json");
       ob.serializingObj(obj,out);

       Book obj2 = new Book();
       Reader in = new FileReader("temp.json");
       obj2 = ob.deserializingObj(in);
       System.out.println(obj2.getYear());
    }
}
