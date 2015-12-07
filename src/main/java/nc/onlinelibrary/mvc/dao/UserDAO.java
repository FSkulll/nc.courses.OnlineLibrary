package nc.onlinelibrary.mvc.dao;

import nc.onlinelibrary.mvc.domain.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    List listUsers();
    void deleteUser(String username);
    User getUser(String username);

}
