package repository.memory;

import java.util.HashMap;
import java.util.Map;

import model.Book;
import repository.BookRepository;

public class MemoryBookRepository implements BookRepository {

    private Map<Integer, Book> books = new HashMap<>();

    @Override
    public void save(Book book) {
        books.put(book.getId(), book);
        System.out.println("Book saved in Memory.");
    }

    @Override
    public Book findBook(int id) {
        return books.get(id);
    }

    @Override
    public void update(Book book) {
        books.put(book.getId(), book);
        System.out.println("Memory updated.");
    }
}