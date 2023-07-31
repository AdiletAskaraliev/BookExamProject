package org.adilet.service.serviceImpl;

import org.adilet.entity.Reader;
import org.adilet.repository.ReaderRepository;
import org.adilet.repository.repositoryImpl.ReaderRepositoryImpl;
import org.adilet.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {

    ReaderRepository readerRepository = new ReaderRepositoryImpl();

    @Override
    public void saveReader(Reader reader) {
        readerRepository.saveReader(reader);
    }
}
