package classifier.mysql.controller;

import classifier.mysql.domain.User;
import classifier.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public User addUser(String name) {
        User n = new User();
        n.setIdentifier(name);
        userRepository.save(n);
        return n;
    }

    public User updateUser(User u) {
        User findUser = userRepository.findOne(u.getId());
        findUser.setAttetionTotalScore(u.getAttetionTotalScore());
        findUser.setLearningStyle(u.getLearningStyle());
        findUser.setMeasuresCount(u.getMeasuresCount());
        userRepository.save(findUser);
        return findUser;
    }

    public User updateUserAttention(Long id, Float attention) {
        User findUser = userRepository.findOne(id);
        float newAttention = findUser.getAttetionTotalScore() + attention;
        int count = findUser.getMeasuresCount() + 1;
        findUser.setAttetionTotalScore(newAttention);
        findUser.setMeasuresCount(count);
        userRepository.save(findUser);
        return findUser;
    }

    public User updateUserLearning(Long id, int learning){
        User findUser = userRepository.findOne(id);
        findUser.setLearningStyle(learning);
        userRepository.save(findUser);
        return findUser;
    }

    public boolean deleteUser(Long id){
        userRepository.delete(id);
        return true;
    }

    public User findByIdentifier(String identifier){
        User u = userRepository.findByIdentifier(identifier);
        return u;
    }

    public ArrayList<User> findAll(){
        ArrayList<User> listUser = new ArrayList<User>();
        userRepository.findAll().forEach(user -> listUser.add(user));
        return listUser;
    }

    public User findById(long id){
        return userRepository.findOne(id);
    }

}
