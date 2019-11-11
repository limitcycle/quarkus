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

@ApplicationScoped
public class BookServiceImpl implements BookService {

  @Inject
  EntityManager em;

  @Transactional
  public void createBook(Book book) {

  }

  @Override
  @Transactional
  public List<Book> findAllBooks() {
    Query query = em.createNativeQuery("select * from book", Book.class);

    List<Book> books = query.getResultList();

    return books;
  }

  @Override
  public Book getBookById(long id) {
    // HQL
    Query query = em.createNativeQuery("select b.* from book b where b.id = :id", Book.class)
        .setParameter("id", id);
    Book book = (Book) query.getSingleResult();
    return book;
  }

  @Override
  @Transactional
  public Book saveBook(Book book) {
    em.persist(book);
    return book;
  }

  @Override
  public Book updateBook(long id, BookDTO bookDTO) {
    return null;
  }

  @Override
  public void deleteBookById(long id) {

  }

  @Override
  public void deleteAllBooks() {

  }

}

