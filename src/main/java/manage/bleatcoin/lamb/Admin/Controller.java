package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.IUserRepository;
import manage.bleatcoin.lamb.Admin.entities.Credentials;
import manage.bleatcoin.lamb.Admin.entities.Response;
import manage.bleatcoin.lamb.Admin.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    IUserRepository userRepository;

    @GetMapping("/allUsers", produces="application/json")
    public Object getAll() {
        List<User> userList = userRepository.findAll();
        if(userList == null)
            return new Response(true, "No Users Found");
        return userList;
    }

    @GetMapping("/getUserById/{id}", produces="application/json")
    public Object getUserById(@PathVariable String id) {
        Optional user = userRepository.findById(id);
        if(!user.isPresent())
            return new Response(true, "Invalid User ID");
        return user.get();
    }

    @PostMapping("/getUserByCredentials/{username}/{password}", produces="application/json")
    public Object getUserByCredentials(@PathVariable String username, @PathVariable String password) {
        Credentials credentials = new Credentials(username, password);
        User temp = userRepository.findByCredentials(credentials);
        if(temp == null){
            return new Response(true, "Invalid Credentials");
        }
        return temp;
    }
}
