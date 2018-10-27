package devopsdemo.demo.service;


import devopsdemo.demo.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
