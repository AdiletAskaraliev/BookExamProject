package org.adilet.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.adilet.entity.Reader;
import org.adilet.hibernateConfig.HibernateConfig;
import org.adilet.repository.ReaderRepository;

public class ReaderRepositoryImpl implements ReaderRepository {

    EntityManager entityManager = HibernateConfig.createEntityManager();

    @Override
    public void saveReader(Reader reader) {
        entityManager.getTransaction().begin();
        entityManager.persist(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(reader + " is saved!");
    }
}
