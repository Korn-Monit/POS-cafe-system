package gp8.itc.cafe.Controller.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gp8.itc.cafe.Controller.DB.RepositoryUser;
import gp8.itc.cafe.Controller.DataStructure.User;

@Service
public class UserService {
    
    @Autowired
    private RepositoryUser userRepository;

    public boolean loginTest(String username, String password, String type){
        User user = userRepository.getUserByUsername(username);
        return user != null && user.getPassword().equals(password) && user.getType().equals(type);
    }
}
