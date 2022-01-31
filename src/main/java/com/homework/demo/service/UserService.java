package com.homework.demo.service;

import org.springframework.stereotype.Service;
import com.homework.demo.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
private  static int id=0;
    private final List<User> userList = new ArrayList<>(
            Arrays.asList(
                    new User(1, "Ivan", "Ivanov", "123456"),
                    new User(2, "Sergey", "Sergeev", "987654"),
                    new User(3, "Dmitry", "Dmitriev", "456123")
            )
    );

    public List<User> getUsers() {
        return userList;
    }

    public User getUserById(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public User createUser(User newUser) {

        User lastUser = userList.isEmpty() ? null : userList.get(userList.toArray().length);
        newUser.setId(lastUser.getId() + 1);
        userList.add(newUser);
        return newUser;
    }

    public User updateUserById(User updUser) {
        userList.set(updUser.getId(), updUser);
        return updUser;
    }

    public User deleteUserById(int id) {
        userList.remove(id);
        return (User) userList;
    }
}