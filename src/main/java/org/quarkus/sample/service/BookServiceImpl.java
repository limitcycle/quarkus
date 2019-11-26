package org.quarkus.sample.service;

import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.quarkus.sample.DTO.BookDTO;
import org.quarkus.sample.domain.Book;

@ApplicationScoped
public class BookServiceImpl implements BookService {

    @Inject
    DataService dataService;

    @Override
    @Transactional
    public List<Book> findAllBooks() {
        return dataService.findByNamedQuery(Book.class, Book.QUERY_ALL_BOOK);
    }

    @Override
    @Transactional
    public Book getBookById(long id) {
        Optional<Book> optionalBook = dataService.findById(Book.class, Long.valueOf(id));
        return optionalBook.isPresent() ? optionalBook.get() : new Book();
    }

    @Override
    @Transactional
    public Book saveBook(Book book) {
        Optional<Book> optionBook = dataService.save(book);
        return optionBook.isPresent() ? optionBook.get() : new Book();
    }

    @Override
    @Transactional
    public Book updateBook(long id, BookDTO bookDTO) {
        Book book = getBookById(id);

        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setStatus(bookDTO.getStatus());

        Optional<Book> optionalBook = dataService.update(book);
        return optionalBook.isPresent() ? optionalBook.get() : new Book();
    }

    @Override
    @Transactional
    public void deleteBookById(long id) {
        Book book = getBookById(id);
        dataService.delete(book);
    }

    @Override
    @Transactional
    public void deleteAllBooks() {
        dataService.findByNamedQuery(Book.class, Book.DELETE_ALL_BOOK);
    }

}

