package org.adilet.repository;

import org.adilet.entity.Author;

import java.util.List;

public interface AuthorRepository {
    Author saveAuthor(Author author);
    void updateAuthor(Long id, Author author);
    Author getAuthorById(Long id);
    List<Author> getAuthorsByPublisherId(Long publisherId);
    void deleteAuthorById(Long id);
    void assignAuthorToPublisher(Long authorId, Long publisherId);
}
