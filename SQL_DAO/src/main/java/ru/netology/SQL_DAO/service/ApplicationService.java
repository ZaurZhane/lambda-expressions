package ru.netology.SQL_DAO.service;

import org.springframework.stereotype.Service;
import ru.netology.SQL_DAO.repository.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<String> getProductName(String name) {
        return applicationRepository.getProductName(name);
    }

}
