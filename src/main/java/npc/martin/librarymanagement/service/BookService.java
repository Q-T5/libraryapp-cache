package npc.martin.librarymanagement.service;

import lombok.extern.slf4j.Slf4j;
import npc.martin.librarymanagement.entity.Book;
import npc.martin.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void createBookRecord(Book book) {
        bookRepository.save(book);
    }

    @Cacheable(cacheNames = "book", key = "#id")
    public Book getBookById(Integer id) {
        log.info("getting book from database...");
        return bookRepository.findById(id).get();
    }

    @CachePut(cacheNames = "book", key = "#book.id")
    public Book updateBook(Book book) {
        log.info("Updating in database...");
        return bookRepository.save(book);
    }

    @CacheEvict(cacheNames = "book", key = "#book.id")
    public void deleteBook(Integer bookId) {
        log.info("deleting from database...");
        bookRepository.deleteById(bookId);
    }
}
