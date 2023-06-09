package npc.martin.librarymanagement.controller;

import lombok.extern.slf4j.Slf4j;
import npc.martin.librarymanagement.entity.Book;
import npc.martin.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(value = "/book/create")
    public boolean createBook(@RequestBody Book book) {
        bookService.createBookRecord(book);
        log.info("Created book record...");

        return Boolean.TRUE;
    }

    @PutMapping(value = "/book/update")
    public Book updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        log.info("Update book record...");

        return updatedBook;
    }

    @GetMapping(value = "/book/get/{id}")
    public Book getBook(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        log.info("Get book with that id...");

        return book;
    }

    @DeleteMapping(value = "/book/delete/{id}")
    public boolean deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        log.info("Delete book with that id...");

        return Boolean.TRUE;
    }
}
