package service;

import model.Book;
import repository.BookRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 07/03/2017.
 */
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean save(Book book) {
        return repository.save(book);
    }

    @Override
    public int getAgeOfBook(Long id) {
        Book book = findById(id);
        Date publishedDate = book.getPublishedDate();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(publishedDate);
        int yearOfPublishing = calendar.get(Calendar.YEAR);
        calendar.setTime(new Date());
        int yearToday = calendar.get(Calendar.YEAR);

        return yearToday - yearOfPublishing;
    }


}
