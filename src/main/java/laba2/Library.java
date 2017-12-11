package laba2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private String address;
    private String name;
    private List<Book> books;

    public Library() {
        this.setAddress("");
        this.setBook(null);
        this.setName("");
    }

    public Library(Library obj) {
        this.address=obj.address;
        this.books=obj.books;
        this.name=obj.name;
    }

    public Library(String address,String name, List<Book> books) {
        this.setAddress(address);
        this.setBook(books);
        this.setName(name);
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Book> getBook() {
        return books;
    }

    public void setBook(List<Book> book) {
        this.books = book;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        return result;
    }


    public List<Book> booksOfAhours(String author) {
        List<Book> listBooksOfAthours = new ArrayList<Book>();
        for(int i=0;i<books.size();i++)
            if(books.get(i).getAthours().contains(author))
                    listBooksOfAthours.add(books.get(i));
        return listBooksOfAthours;
    }

    public void sortOnAthour() {
        Collections.sort(this.books, new Book.SortByAuthours());
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Library other = (Library) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (books == null) {
            if (other.books != null)
                return false;
        } else if (!books.equals(other.books))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public static void main(String... strings) {

        List<Book> book = new ArrayList<Book>();

        ArrayList<String> str1 = new ArrayList<String>();
        str1.add("Aerzlyak A.V.");
        str1.add("Polonskiy V.I.");

        ArrayList<String> str2 = new ArrayList<String>();
        str2.add("Aerzlyak A.V.");
        str2.add("Polonskiy V.I.");
        str2.add("Jakir D.G.");
        Book book1 = new Book(str1,"Zbirnik","Kyiv",1980,500);
        Book book2 = new Book(str2,"Geometriya","Kharkiv",2013,450);
        book.add(0, book1);
        book.add(1, book2);
        Library ob = new Library("chernivtsi","Kyiv",book);
        ob.sortOnAthour();
        for(int i=0;i<2;i++)
            ob.books.get(i).print();


    }
}