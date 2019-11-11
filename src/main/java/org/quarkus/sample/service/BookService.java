package org.quarkus.sample.service;

import java.util.List;
import org.quarkus.sample.DTO.BookDTO;
import org.quarkus.sample.domain.Book;

public interface BookService {

  List<Book> findAllBooks();

  Book getBookById(long id);

  Book saveBook(Book book);

  Book updateBook(long id, BookDTO bookDTO);

  void deleteBookById(long id);

  void deleteAllBooks();
}
