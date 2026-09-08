package repository;

import model.Book;

public interface BookRepository {

    void save(Book book);

    Book findBook(int id);

    void update(Book book);
}