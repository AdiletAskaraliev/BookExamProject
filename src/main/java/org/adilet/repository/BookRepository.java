package org.adilet.repository;

import org.adilet.entity.Book;

public interface BookRepository {
    void saveBook(Book book, Long authorId);



//    deleteBookByAuthorId()

//    getBookAndPublisherByBookId();

//    updateBookAuthor();
}
