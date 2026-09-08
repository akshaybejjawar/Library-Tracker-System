package main;

import model.Book;
import model.Member;
import notification.MultiNotifier;
import notification.Notifier;
import repository.BookRepository;
import repository.memory.MemoryBookRepository;
import service.BorrowService;
import strategy.FlatFeeStrategy;
import strategy.LateFeeStrategy;

public class Main {

    public static void main(String[] args) {

        BookRepository repository = new MemoryBookRepository();
        // BookRepository repository = new SqlBookRepository();

        LateFeeStrategy strategy = new FlatFeeStrategy();
        // LateFeeStrategy strategy = new TieredFeeStrategy();

        Notifier notifier = new MultiNotifier();

        BorrowService service =
                new BorrowService(repository, strategy, notifier);

        Book book =
                new Book(101, "Java Programming", true);

        Member member =
                new Member(1, "Srujitha", "9876543210");

        repository.save(book);

        service.borrowBook(book, member);

        service.returnBook(book, member, 3);

    }
}