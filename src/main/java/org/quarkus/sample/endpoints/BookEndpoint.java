package org.quarkus.sample.endpoints;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.quarkus.sample.DTO.BookDTO;
import org.quarkus.sample.domain.Book;
import org.quarkus.sample.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
public class BookEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookEndpoint.class);

    @Inject
    BookService service;

    @GET
    @Path("books")
    public Response listAllBooks() {
        List<Book> books = service.findAllBooks();
        return Response.ok(books).build();
    }

    @GET
    @Path("book/{id}")
    public Response getBookById(@PathParam("id") Long id) {
        Book book = service.getBookById(id.longValue());
        return Response.ok(book).build();
    }

    @POST
    @Path("book")
    @Consumes("application/json")
    public Response createBook(@Valid BookDTO bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book.setDescription(bookDto.getDescription());
        book.setStatus(bookDto.getStatus());

        service.saveBook(book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @PUT
    @Path("book/{id}")
    @Consumes("application/json")
    public Response updateBook(@PathParam("id") Long id, @Valid BookDTO bookDTO) {
        Book book = service.updateBook(id.longValue(), bookDTO);

        return Response.ok(book).build();
    }

    @DELETE
    @Path("book/{id}")
    public Response deleteBookById(@PathParam("id") Long id) {
        Book book = service.getBookById(id.longValue());
        if (book != null) {
            service.deleteBookById(id.longValue());
        }
        return Response.noContent().build();
    }

    @DELETE
    @Path("books")
    public Response deleteAllBooks() {
        service.deleteAllBooks();
        return Response.noContent().build();
    }
}