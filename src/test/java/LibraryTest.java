import laba2.Book;
import laba2.Library;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;

public class LibraryTest {
    Library lib1,lib2;
    @BeforeTest
    public void setObject(){
        Book book1,book2,book3;
        ArrayList<String> str1 = new ArrayList<String>();
        str1.add("Franko I.F.");
        str1.add("Shevchenko T.H.");

        ArrayList<String> str2 = new ArrayList<String>();
        str2.add("Merzlyak A.V.");
        str2.add("Polonskiy V.I.");
        str2.add("Jakir D.G.");

        ArrayList<String> str3 = new ArrayList<String>();
        str3.add("Volochuk A.A.");
        str3.add("Slobodonyuk G.V.");
        str3.add("Fylenko D.G.");

        book1 = new Book(str1,"Zbirnik","Kyiv",1980,500);
        book2 = new Book(str2,"Geometriya","Kharkiv",2013,450);
        book3 = new Book(str3,"Literature","Kharkiv",2012,370);

    }
}
