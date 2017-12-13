package laba2.DB;

import com.thoughtworks.xstream.io.binary.Token;
import laba2.Book;

import java.sql.*;

public class MySQLBook {
    private final static String URL = "jdbc:mysql://localhost:3306/book_app";
    private final static String USER_NAME = "root";
    private final static String PASSWORD ="kOlyan1905";
    private final static String INSERT_INTO_BOOK = "INSERT INTO book(name,authors,publish,year,cntpage,libraryId)"+ "VALUES(?,?,?,?,?,?);";
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

        ResultSet resultSet = statement.executeQuery("SELECT bookId FROM book WHERE year=");
        resultSet.next();
        book.setId(resultSet.getInt("busId"));
        connection.close();
    }






}
