package org.quarkus.sample.service;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.quarkus.sample.DTO.BookDTO;
import org.quarkus.sample.domain.Book;
import org.quarkus.sample.repository.BookRepository;

@ApplicationScoped
public class BookServiceImpl implements BookService {

  @Inject
  BookRepository bookRepository;


  @Override
  @Transactional
  public List<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  @Transactional
  public Book getBookById(long id) {

    return bookRepository.findById(id);
  }

  @Override
  @Transactional
  public Book saveBook(Book book) {
    bookRepository.save(book);
    return book;
  }

  @Override
  @Transactional
  public Book updateBook(long id, BookDTO bookDTO) {
    Book book = getBookById(id);
    saveBook(book);
    return book;
  }

  @Override
  @Transactional
  public void deleteBookById(long id) {
    Book book = getBookById(id);
    bookRepository.deleteById(book);
  }

  @Override
  public void deleteAllBooks() {

  }

}

