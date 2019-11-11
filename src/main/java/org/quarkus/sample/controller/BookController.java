package org.quarkus.sample.controller;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.quarkus.sample.domain.Book;
import org.quarkus.sample.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
public class BookController {

  private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

  @Inject
  BookService service;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "hello";
  }

  @GET
  @Path("books")
  public List<Book> listAllBooks() {
    return service.findAllBooks();
  }

  @GET
  @Path("book/{id}")
  public Book getBookById(@PathParam("id") Long id) {
    return service.getBookById(id.longValue());
  }

}