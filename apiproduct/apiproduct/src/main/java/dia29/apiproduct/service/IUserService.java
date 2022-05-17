package dia29.apiproduct.service;

import java.util.List;

import dia29.apiproduct.model.User;

public interface IUserService {
    List<User> getAll();
    boolean save(User u);
    boolean delete(long id);
    boolean update(User u);
    
}
