package service;

import model.Book;
import model.Member;
import notification.Notifier;
import repository.BookRepository;
import strategy.LateFeeStrategy;

public class BorrowService {

    private BookRepository repository;
    private LateFeeStrategy feeStrategy;
    private Notifier notifier;

    public BorrowService(BookRepository repository,
                         LateFeeStrategy feeStrategy,
                         Notifier notifier) {

        this.repository = repository;
        this.feeStrategy = feeStrategy;
        this.notifier = notifier;
    }

    public void borrowBook(Book book, Member member) {

        if (!book.isAvailable()) {
            System.out.println("Book is not available.");
            return;
        }

        book.setAvailable(false);
        repository.update(book);

        notifier.notifyMember(member,
                "You borrowed: " + book.getTitle());

        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(Book book,
                           Member member,
                           int lateDays) {

        book.setAvailable(true);
        repository.update(book);

        double fee = feeStrategy.calculateFee(lateDays);

        System.out.println("Late Fee = ₹" + fee);

        notifier.notifyMember(member,
                "Book returned successfully.");

        System.out.println("Book returned.");
    }

}