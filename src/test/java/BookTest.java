import java.util.ArrayList;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import laba2.Book;

public class BookTest {
    private Book ob1,ob2,ob3;

    @BeforeTest
    public void setObject() {
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

        ob1 = new Book(str1,"Zbirnik","Kyiv",1980,500);
        ob2 = new Book(str2,"Geometriya","Kharkiv",2013,450);
        ob3 = new Book(str3,"Literature","Kharkiv",2012,370);
    }

    @DataProvider
    public Object[][] ageData(){

        return new Object[][] {
                {37,ob1},
                { 4,ob2},
                { 5,ob3}
        };

    }
    @Test(dataProvider="ageData")
    public void testage(int val,Book ob) {
        Assert.assertEquals(val, ob.age());
    }



    //////////////////////////////////////////////
    @DataProvider
    public Object[][] isAthoursData(){
        return new Object[][] {
                {true, "Merzlyak A.V.",ob2},
                {false,"Øèäëò Ã.Ä.",ob2},
                {true, "Volochuk A.A.", ob3},
                {false,"Merzlyak A.V.", ob3},
                {true, "Shevchenko T.H.",ob1}
        };
    }

    @Test(dataProvider="isAthoursData")
    public void testisAthours(boolean val ,String author, Book ob) {
        Assert.assertEquals(val,ob.isAthour(author));

    }


    /////////////////////////////
    @DataProvider
    public Object[][] athoursRegExData(){
        return new Object[][] {
                {"Merzlyak T.H.",true},
                {"Bayron D.B.",true},
                {"shekspir W.H.",false},
                {"BayronD.B.",false}
        };
    }

    @Test(dataProvider = "athoursRegExData")
    public void athoursRegExTest(String athours, boolean rezult) {
        Assert.assertEquals(ob1.checkAthours(athours), rezult);
    }

    ////////////////////////
    @DataProvider
    public Object[][] nameRegExData(){
        return new Object[][] {
                {"Sherlock Holmes", true},
                {"sher45ck 7olmes",false},
        };
    }

    @Test(dataProvider = "nameRegExData")
    public void nameRegExTest(String name, boolean rezult) {
        Assert.assertEquals(ob1.checkName(name), rezult);
    }

    ///////////////
    @DataProvider
    public Object[][] publishRegExData(){
        return new Object[][] {
                {"Prosvita",true},
                {"1984",true},
                {"Happy reading",true}
        };
    }

    @Test(dataProvider = "publishRegExData")
    public void publishRegExTest(String publish,boolean rezult){
        Assert.assertEquals(ob1.checkPublish(publish), rezult);
    }


}