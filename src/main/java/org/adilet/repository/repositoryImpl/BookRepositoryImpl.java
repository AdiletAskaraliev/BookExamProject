package org.adilet.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.adilet.entity.Author;
import org.adilet.entity.Book;
import org.adilet.hibernateConfig.HibernateConfig;
import org.adilet.repository.BookRepository;

public class BookRepositoryImpl implements BookRepository {
    EntityManager entityManager = HibernateConfig.createEntityManager();
    @Override
    public void saveBook(Book book, Long authorId) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, authorId);
        book.setAuthor(author);
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(book + " is saved!");
    }
}
