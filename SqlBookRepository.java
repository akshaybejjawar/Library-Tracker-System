package repository.sql;

import model.Book;
import repository.BookRepository;

public class SqlBookRepository implements BookRepository {

    @Override
    public void save(Book book) {
        System.out.println("Book saved in SQL Database.");
    }

    @Override
    public Book findBook(int id) {
        System.out.println("Fetching Book from SQL Database...");
        return new Book(id, "Java Programming", true);
    }

    @Override
    public void update(Book book) {
        System.out.println("SQL Database updated.");
    }
}