package mk.ukim.finki.library.service;

import mk.ukim.finki.library.model.Author;
import mk.ukim.finki.library.model.Book;
import mk.ukim.finki.library.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findByName(String name);

    Optional<Book> findById(Long id);

    Optional<Book> saveBook(String name, Long categoryId, Long authorId, int availableCopies);

    Optional<Book> saveBook(BookDto bookDto);


    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> markAsTaken(Long id);


}
