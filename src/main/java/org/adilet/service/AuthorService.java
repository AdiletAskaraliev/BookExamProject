package org.adilet.service;

import org.adilet.entity.Author;

import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    void updateAuthor(Long id, Author author);
    Author getAuthorById(Long id);

    List<Author> getAuthorsByPublisherId(Long publisherId);
    void deleteAuthorById(Long id);
    void assignAuthorToPublisher(Long authorId, Long publisherId);
}
