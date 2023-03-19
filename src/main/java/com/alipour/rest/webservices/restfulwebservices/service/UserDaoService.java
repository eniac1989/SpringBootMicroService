package com.alipour.rest.webservices.restfulwebservices.service;

import com.alipour.rest.webservices.restfulwebservices.user.User;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Paniz Alipour
 */
@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Paniz", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Pedram", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "Azam", LocalDate.now().minusYears(55)));
        users.add(new User(++userCount, "Alireza", LocalDate.now().minusYears(60)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteUser(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
