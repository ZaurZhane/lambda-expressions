package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {

        List<Authorities> authorizationList = new ArrayList<>();
        if (user.equals("admin") && password.equals("123")) {
            Collections.addAll(authorizationList, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("guest") && password.equals("111")) {
            Collections.addAll(authorizationList, Authorities.READ);
        }
        return authorizationList;
    }
}
