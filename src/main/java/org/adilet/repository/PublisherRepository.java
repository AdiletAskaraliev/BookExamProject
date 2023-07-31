package org.adilet.repository;

import org.adilet.entity.Publisher;

import java.util.List;

public interface PublisherRepository {
    Publisher savePublisher(Publisher publisher);
    Publisher getPublisherById(Long publisherId);
    List<Publisher> getAllPublishers(String ascOrDesc);
    void updatePublisher(Long id, Publisher publisher);
    void deletePublisherByName(String name);
}
