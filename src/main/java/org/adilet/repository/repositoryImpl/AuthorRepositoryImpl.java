package org.adilet.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.adilet.entity.Author;
import org.adilet.entity.Publisher;
import org.adilet.hibernateConfig.HibernateConfig;
import org.adilet.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

import static org.adilet.hibernateConfig.HibernateConfig.createEntityManager;

public class AuthorRepositoryImpl implements AuthorRepository {
    EntityManager entityManager = createEntityManager();
    @Override
    public Author saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public void updateAuthor(Long id, Author author) {
        entityManager.getTransaction().begin();
        Author newAuthor = entityManager.find(Author.class, id);
        newAuthor.setFirstName(author.getFirstName());
        newAuthor.setLastName(author.getLastName());
        newAuthor.setEmail(author.getEmail());
        newAuthor.setDateOfBirth(author.getDateOfBirth());
        newAuthor.setCountry(author.getCountry());
        newAuthor.setGender(author.getGender());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(author +  " is updated");
    }

    @Override
    public Author getAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public void assignAuthorToPublisher(Long authorId, Long publisherId) {

            entityManager = HibernateConfig.createEntityManager();
            entityManager.getTransaction().begin();

            Author author = entityManager.find(Author.class, authorId);
            Publisher publisher = entityManager.find(Publisher.class, publisherId);

            publisher.setAuthor(author);
            author.setPublisher(publisher);

            entityManager.getTransaction().commit();

            System.out.println(author + " assigned to " + publisher);

    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherId) {
        entityManager.getTransaction().begin();
        List<Author> resultList = entityManager.createQuery(
                "select a from Author a join a.publishers ap where ap.id = :pubId ",
                        Author.class)
                .setParameter("pubId", publisherId).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public void deleteAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(id + " is deleted");
    }


}
