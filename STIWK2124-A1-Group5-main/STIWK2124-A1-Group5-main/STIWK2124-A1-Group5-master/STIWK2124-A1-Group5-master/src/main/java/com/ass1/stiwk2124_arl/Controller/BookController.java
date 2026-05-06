package com.ass1.stiwk2124_arl.Controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ass1.stiwk2124_arl.model.Book;
import com.ass1.stiwk2124_arl.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
public ResponseEntity<?> getBookById(@PathVariable Long id) {

    Book book = bookService.getBookById(id);

    if (book == null) {
        return ResponseEntity.status(404).body("Book not found");
    }

    return ResponseEntity.ok(book);
}

    @GetMapping
public List<Book> getAllBooks(
        @RequestParam(required = false) String q,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
) {
    if (q != null && !q.isEmpty()) {
        return bookService.searchBooks(q);
    }

    return bookService.getAllBooks(PageRequest.of(page, size))
            .getContent();
}

    @PostMapping
    public String createBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return "Book Created Successfully";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book book) {
        String updated = bookService.updateBook(id, book);
        return updated;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book Deleted Successfully";
    }
}