package laba2;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.*;

public class Book {
    private String name;
    private List<String> authours = new ArrayList<String>();
    private String publish;
    private int year;
    private int cntPage;
    private final  String ATHOURS_PATTERN = "^([A-Z][a-z]{1,8})(\\s)([A-Z])(\\.)([A-Z])(\\.)$";
    private final  String NAME_PATTERN = "(([A-Z][a-z]{1,10}\\s)|([A-Z][a-z]{1,10})|[0-9]+\\s|[0-9]+){1,5}";
    private final  String PUBLISH_PATTERN = "((\\w+\\s)|(\\w+)){1,5}";


    public Book() {
        this.setName("");
        this.setPublish("");
        this.setAthours(null);
        this.setcntPage(0);
        this.setYear(0);
    }

    public Book(ArrayList<String> athours,String name, String publish, int year, int cntPage){
        this.setName(name);
        this.setPublish(publish);
        this.setcntPage(cntPage);
        this.setYear(year);
        this.setAthours(athours);
    }

    public Book(Book book) {
        this.authours = book.authours;
        this.name = book.name;
        this.publish=book.publish;
        this.cntPage=book.cntPage;
        this.year=book.year;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Book other = (Book) obj;
        if (authours == null) {
            if (other.authours != null)
                return false;
        } else if (!authours.equals(other.authours))
            return false;
        if (cntPage != other.cntPage)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (publish == null) {
            if (other.publish != null)
                return false;
        } else if (!publish.equals(other.publish))
            return false;
        if (year != other.year) {

            return false;
        }
        return true;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getAthours() {
        return this.authours;
    }
    public void setAthours(ArrayList<String> athours) {
        this.authours = athours;
    }
    public String getPublish() {
        return publish;
    }
    public void setPublish(String publish) {
        this.publish = publish;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getcntPage() {
        return cntPage;
    }
    public void setcntPage(int cntPage) {
        this.cntPage = cntPage;
    }

    public  int age() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year-this.year;
    }

    public boolean isAthour( String name) {
        for(int i=0;i<authours.size();i++) {
            if(name.equals(authours.get(i)))
                return true;
        }
        return false;
    }

    public void addAuthor(String surname) {

        boolean isAuthourExist=false;
        for(int i=0;i<authours.size();i++)
            if(surname.equals(authours.get(i)))
                isAuthourExist=true;
        if(!isAuthourExist)
            authours.add(surname);
    }

    public boolean checkName(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public boolean checkAthours(String authors) {
        Pattern pattern = Pattern.compile(ATHOURS_PATTERN);
        Matcher matcher = pattern.matcher(authors);
        return matcher.matches();
    }

    public boolean checkPublish(String publish) {
        Pattern pattern = Pattern.compile(PUBLISH_PATTERN);
        Matcher matcher = pattern.matcher(publish);
        return matcher.matches();
    }

    public static class SortByAuthours implements Comparator<Book> {

        @Override
        public int compare(Book arg0, Book arg1) {
            int i;
            for(i=0;i<arg0.getAthours().size() && i<arg1.getAthours().size();i++) {
                if(arg0.getAthours().get(i).compareTo(arg1.getAthours().get(i))>0) return 1;
                else if(arg0.getAthours().get(i).compareTo(arg1.getAthours().get(i))<0) return -1;
            }
            if(i==arg0.getAthours().size() && i!=arg1.getAthours().size()) return -1;
            if(i==arg1.getAthours().size() && i!=arg0.getAthours().size()) return 1;
            return 0;
        }

    }


    public void print() {
        System.out.println(this.authours);
        System.out.println(this.name);
        System.out.println(this.cntPage);
    }



    public static void main(String... strings) {
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

        Collections.sort(book, new Book.SortByAuthours());
        for(int i=0;i<2;i++)
            book.get(i).print();
    }


}
