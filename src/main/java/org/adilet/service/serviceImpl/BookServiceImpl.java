package org.adilet.service.serviceImpl;

import org.adilet.entity.Book;
import org.adilet.repository.BookRepository;
import org.adilet.repository.repositoryImpl.BookRepositoryImpl;
import org.adilet.service.BookService;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();
    @Override
    public void saveBook(Book book, Long authorId) {
        bookRepository.saveBook(book, authorId);
    }
}
