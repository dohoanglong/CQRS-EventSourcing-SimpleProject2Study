package repository;

import dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> store = new HashMap<>();


    public void addUser(String userId, User user) {
        store.put(userId,user);
    }

    public User getUser(String userId) {
        return store.get(userId);
    }
}
