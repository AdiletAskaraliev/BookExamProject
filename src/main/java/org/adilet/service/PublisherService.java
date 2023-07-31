package org.adilet.service;

import org.adilet.entity.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher savePublisher(Publisher publisher);
    Publisher getPublisherById(Long publisherId);
    List<Publisher> getAllPublishers(String ascOrDesc);
    void updatePublisher(Long id, Publisher publisher);
    void deletePublisherByName(String name);

}
