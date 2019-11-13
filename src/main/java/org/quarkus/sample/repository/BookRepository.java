package org.quarkus.sample.repository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.quarkus.sample.domain.Book;

@ApplicationScoped
public class BookRepository {

  @Inject
  EntityManager em;

  public List<Book> findAll() {
    Query query = em.createNativeQuery("select * from book", Book.class);

    List<Book> books = query.getResultList();

    return books;
  }

  public Book findById(long id) {
    Query query = em.createNativeQuery("select b.* from book b where b.id = :id", Book.class)
        .setParameter("id", id);
    Book book = (Book) query.getSingleResult();
    return book;
  }

  public void save(Book book) {
    em.persist(book);
  }

  public void deleteById(Book book) {
    em.remove(book);
  }

  public void deleteAll() {
    Query query = em.createNativeQuery("delete from book");
  }
}
