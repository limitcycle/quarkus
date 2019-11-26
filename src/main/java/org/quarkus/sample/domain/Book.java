package org.quarkus.sample.domain;


import javax.persistence.*;


@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name = Book.QUERY_ALL_BOOK, query = "select b from Book b"),
        @NamedQuery(name = Book.QUERY_BOOK_BY_ID, query = "select b from Book b where b.id = ?1"),
        @NamedQuery(name = Book.DELETE_ALL_BOOK, query = "delete from Book")

})
public class Book {

  public static final String QUERY_ALL_BOOK = "Book.findAll";
  public static final String QUERY_BOOK_BY_ID = "Book.findByID";
  public static final String DELETE_ALL_BOOK = "book.deleteAll";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String author;

  private String description;

  private String name;

  private int status;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

}
