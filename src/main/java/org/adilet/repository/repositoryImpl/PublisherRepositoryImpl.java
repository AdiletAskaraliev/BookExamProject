package org.adilet.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.adilet.entity.Publisher;
import org.adilet.hibernateConfig.HibernateConfig;
import org.adilet.repository.PublisherRepository;

import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository {
    private final EntityManager entityManager = HibernateConfig.createEntityManager();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public Publisher getPublisherById(Long publisherId) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public List<Publisher> getAllPublishers(String ascOrDesc) {
        entityManager.getTransaction().begin();
        String query = "SELECT p FROM Publisher p ORDER BY p.name " +
                (ascOrDesc.equalsIgnoreCase("desc") ? "DESC" : "ASC");
        List<Publisher> publisherList = entityManager.createQuery(query, Publisher.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisherList;
    }

    @Override
    public void updatePublisher(Long id, Publisher publisher) {
        entityManager.getTransaction().begin();
        Publisher newPublisher = entityManager.find(Publisher.class, id);
        newPublisher.setName(publisher.getName());
        newPublisher.setAddress(publisher.getAddress());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(publisher + " is updated to " + newPublisher);
    }

    @Override
    public void deletePublisherByName(String name) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.name = :aty",
                        Publisher.class).setParameter("aty", name).getSingleResult();
        entityManager.remove(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(name + " is deleted!");
    }
}
