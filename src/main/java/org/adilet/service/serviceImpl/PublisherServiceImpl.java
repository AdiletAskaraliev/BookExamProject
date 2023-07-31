package org.adilet.service.serviceImpl;

import org.adilet.entity.Publisher;
import org.adilet.repository.PublisherRepository;
import org.adilet.repository.repositoryImpl.PublisherRepositoryImpl;
import org.adilet.service.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    PublisherRepository publisherRepository = new PublisherRepositoryImpl();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.savePublisher(publisher);
    }

    @Override
    public Publisher getPublisherById(Long publisherId) {
        return publisherRepository.getPublisherById(publisherId);
    }

    @Override
    public List<Publisher> getAllPublishers(String ascOrDesc) {
        return publisherRepository.getAllPublishers(ascOrDesc);
    }

    @Override
    public void updatePublisher(Long id, Publisher publisher) {
        publisherRepository.updatePublisher(id, publisher);
    }

    @Override
    public void deletePublisherByName(String name) {
        publisherRepository.deletePublisherByName(name);
    }
}
