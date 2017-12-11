package laba2;

public class LibraryService {
    private  Library library;

    public  LibraryService(Library library){
        this.library=library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }


    public int OldestBook(){
        return library.getBook().stream().mapToInt(Book :: getYear).min().getAsInt();
    }

    public int BiggestBook(){
        return library.getBook().stream().mapToInt(Book :: getcntPage).max().getAsInt();
    }

    public double AverageNumberOfPage(){
        return library.getBook().stream().mapToInt(Book :: getcntPage).average().getAsDouble();
    }

    public double AverageAgeOfBooks(){
        return library.getBook().stream().mapToInt(Book :: getYear).average().getAsDouble();
    }

    /*public static void main(String... strings) {

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


    }*/


}
