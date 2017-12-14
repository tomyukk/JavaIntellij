package laba2.DB;

import com.thoughtworks.xstream.io.binary.Token;
import laba2.Book;
import laba2.Library;

import java.sql.*;
import java.util.ArrayList;

public class MySQLBook {
    private final static String URL = "jdbc:mysql://localhost:3306/bookdb";
    private final static String USER_NAME = "root";
    private final static String PASSWORD ="kOlyan1905";
    private final static String INSERT_INTO_BOOK = "INSERT INTO books(name,publish,authors,year,cntPage,libraryId)"
            + "VALUES(?,?,?,?,?,?);";
    private final static String INSERT_INTO_LIBRARY = "INSERT INTO library(address,name)"+"VALUES(?,?);";

    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Connection connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        return connection;
    }

    public void addBook(Book book, int libraryId)throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BOOK);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getPublish());
        preparedStatement.setString(3, String.valueOf(book.getAthours()));
        preparedStatement.setInt(4, book.getYear());
        preparedStatement.setInt(5, book.getcntPage());
        preparedStatement.setInt(6, libraryId);
        preparedStatement.execute();

        ResultSet resultSet = statement.executeQuery("SELECT bookId FROM books WHERE year="+"'"
                +book.getYear()+"';");
        resultSet.next();
        book.setbookId(resultSet.getInt("bookId"));
        connection.close();
    }

    public ArrayList<Book> getAllBooks()throws SQLException, ClassNotFoundException{
        ArrayList<Book> books = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books;");
        while (resultSet.next()){
            Book book = new Book();
            book.setbookId(resultSet.getInt("bookId"));
            book.setName(resultSet.getString("name"));
            book.setPublish(resultSet.getString("name"));
            String temp = new String();
            temp =(String.valueOf(resultSet.getString("authors")));
            String[] tempParse = temp.split(", ");
            ArrayList<String> tempList =new ArrayList<>();
            int i=0;
            while (i<tempParse.length)
                tempList.add(tempParse[i++]);
            book.setAthours(tempList);
            book.setYear(resultSet.getInt("year"));
            book.setcntPage(resultSet.getInt("cntPage"));
            books.add(book);
        }
        connection.close();
        return books;
    }

    public void deleteBook(int bookId)throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        int deleteInfo =  statement.executeUpdate("DELETE FROM books WHERE bookId=" + bookId + ";");
        connection.close();
    }

    public ArrayList<Book> getBookByYear(int year)throws SQLException, ClassNotFoundException{
        ArrayList<Book> books = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books WHERE books.year LIKE " +
                "'" + year + "%'" +";");
        while (resultSet.next()){
            Book book = new Book();
            book.setbookId(resultSet.getInt("bookId"));
            book.setName(resultSet.getString("name"));
            book.setPublish(resultSet.getString("name"));
            String temp = new String();
            temp =(String.valueOf(resultSet.getString("authors")));
            String[] tempParse = temp.split(", ");
            ArrayList<String> tempList =new ArrayList<>();
            int i=0;
            while (i<tempParse.length)
                tempList.add(tempParse[i++]);
            book.setAthours(tempList);
            book.setYear(resultSet.getInt("year"));
            book.setcntPage(resultSet.getInt("cntPage"));
            books.add(book);
        }
        connection.close();
        return books;
    }

    public int getYearByNameOfBook(String name)throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT books.year FROM books WHERE books.name LIKE " +
                "'" + name + "%'" +";");
        resultSet.next();
        return resultSet.getInt("year");
    }

    public void addLibrary(Library library)throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_LIBRARY);
        preparedStatement.setString(1,library.getAddress());
        preparedStatement.setString(2,library.getName());
        preparedStatement.execute();

        ResultSet resultSet = statement.executeQuery("SELECT libraryId FROM library WHERE address=" +
                "'"+library.getAddress()+"';");
        resultSet.next();
        library.setLibraryId(resultSet.getInt("garageId"));
        connection.close();
    }

    public void deleteLibrary(int libraryId)throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        int deleteInfo = statement.executeUpdate("DELETE FROM library WHERE libraryId =" + libraryId + ";");
        connection.close();
    }




    public static void main(String... strings) throws SQLException, ClassNotFoundException {
       MySQLBook obj = new MySQLBook();

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

        Book book1 = new Book(str1,"Zbirnik","Kyiv",1980,500);
        Book book2 = new Book(str2,"Geometriya","Kharkiv",2013,450);
        Book book3 = new Book(str3,"Literature","Kharkiv",2012,370);
        obj.getConnection();
        ArrayList<Book> objBook = new ArrayList<>();
        ArrayList<Book> objBookByYear = new ArrayList<>();
       obj.addBook(book1,1);
        objBook=obj.getAllBooks();
        int i=0;
        while (i<objBook.size())
            objBook.get(i++).print();
        objBookByYear=obj.getBookByYear(2013);
        i=0;
        while (i<objBookByYear.size())
            objBookByYear.get(i++).print();
        System.out.println(obj.getYearByNameOfBook("Zbirnik"));
        //obj.deleteBook(8);

    }

}
