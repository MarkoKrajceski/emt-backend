package mk.ukim.finki.library.service.impl;

import mk.ukim.finki.library.model.Author;
import mk.ukim.finki.library.model.Book;
import mk.ukim.finki.library.model.Category;
import mk.ukim.finki.library.model.dto.BookDto;
import mk.ukim.finki.library.model.excepitons.AuthorNotFoundException;
import mk.ukim.finki.library.model.excepitons.BookNotFoundException;
import mk.ukim.finki.library.model.excepitons.CategoryNotFoundException;
import mk.ukim.finki.library.repository.AuthorRepository;
import mk.ukim.finki.library.repository.BookRepository;
import mk.ukim.finki.library.repository.CategoryRepository;
import mk.ukim.finki.library.service.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findBookByName(name);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Transactional
    @Override
    public Optional<Book> saveBook(String name, Long categoryId, Long authorId, int availableCopies) {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        Book book = new Book(name, category, author, availableCopies);
        this.bookRepository.save(book);

        return Optional.of(book);

    }

    @Override
    public Optional<Book> saveBook(BookDto bookDto) {
        Category category = this.categoryRepository.findById(bookDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(bookDto.getCategory()));

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        //deletebyName

        Book book = new Book(bookDto.getName(), category, author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {

        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        Category category = this.categoryRepository.findById(bookDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(bookDto.getCategory()));

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        book.setName(bookDto.getName());
        book.setCategory(category);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setAuthor(author);

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Transactional
    public Optional<Book> edit(Long id, String name, Long categoryId, Long authorId, int availableCopies) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);

        return Optional.of(book);
    }


    @Override
    public void deleteById(Long id) {

        this.bookRepository.deleteById(id);

    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        book.setAvailableCopies(book.getAvailableCopies()-1);
        this.bookRepository.save(book);

        return Optional.of(book);
    }
}
