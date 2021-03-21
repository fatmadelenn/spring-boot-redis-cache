package com.fatmadelenn.redis.service;

import com.fatmadelenn.redis.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private List<User> users;

    @PostConstruct
    public void init() {
        users = new ArrayList<>();
        users.add(new User("IDX001", "fatma", User.Gender.FEMALE));
        users.add(new User("IDX002", "beste", User.Gender.FEMALE));
        users.add(new User("IDX003", "leyla", User.Gender.FEMALE));
        users.add(new User("IDX004", "erdem", User.Gender.MALE));
        users.add(new User("IDX005", "hamide", User.Gender.FEMALE));
        users.add(new User("IDX006", "buse", User.Gender.FEMALE));
        users.add(new User("IDX007", "burak", User.Gender.MALE));
        users.add(new User("IDX008", "yusa", User.Gender.MALE));
    }

    public List<User> getAllUsers() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserWithName(String name) throws Exception {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return users.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new Exception("Cannot find user with name:" + name));
    }

    public void deleteUserWithName(String name) {
        users = users.stream().filter(p -> !p.getName().equals(name)).collect(Collectors.toList());
    }

    public void deleteAllUsers() {
        users.removeAll(users);
        logger.info("Successfully deleted all users");
    }

    public User updateUser(User user) {
        users = users.stream().filter(p -> p.getName() != user.getName()).collect(Collectors.toList());
        users.add(user);
        logger.info("Successfully changed group : {}", user);
        return user;
    }
}
