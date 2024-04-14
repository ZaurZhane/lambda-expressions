package ru.netology.SQL_DAO.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ApplicationRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String scriptSelectProductName = read("product_name.sql");
    public ApplicationRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {

        return namedParameterJdbcTemplate.queryForList(scriptSelectProductName, Map.of("name", name), String.class);
    }
}
