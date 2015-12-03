package nc.onlinelibrary.mvc.service;

import nc.onlinelibrary.mvc.domain.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> listUsers();
    void deleteUser(String username);
}
