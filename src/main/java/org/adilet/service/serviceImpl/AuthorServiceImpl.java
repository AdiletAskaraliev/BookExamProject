package org.adilet.service.serviceImpl;

import org.adilet.entity.Author;
import org.adilet.repository.AuthorRepository;
import org.adilet.repository.repositoryImpl.AuthorRepositoryImpl;
import org.adilet.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository = new AuthorRepositoryImpl();
    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.saveAuthor(author);

    }

    @Override
    public void updateAuthor(Long id, Author author) {
        authorRepository.updateAuthor(id, author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public void assignAuthorToPublisher(Long authorId, Long publisherId) {
        authorRepository.assignAuthorToPublisher(authorId, publisherId);
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherId) {
        return authorRepository.getAuthorsByPublisherId(publisherId);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteAuthorById(id);
    }
}
