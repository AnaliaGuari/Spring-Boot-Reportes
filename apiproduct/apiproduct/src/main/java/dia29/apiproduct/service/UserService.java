package dia29.apiproduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia29.apiproduct.model.User;
import dia29.apiproduct.repositories.IUserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userR;

    @Override
    public List<User> getAll() {
        return userR.findAll();
    }

    @Override
    public boolean save(User u) {
        if (userR.existsById(u.getId()))
            return false;
        else {
            userR.save(u);
            return true;
        }
    }

    @Override
    public boolean delete(long id) {
        if (userR.existsById(id)) {
            userR.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(User u) {
        if (userR.existsById(u.getId())) {
            userR.save(u);
            return true;
        }

        else {

            return false;
        }

    }
}
