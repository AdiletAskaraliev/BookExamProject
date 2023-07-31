package org.adilet.service;

import org.adilet.entity.Book;

public interface BookService {
    public void saveBook(Book book, Long authorId);
}
