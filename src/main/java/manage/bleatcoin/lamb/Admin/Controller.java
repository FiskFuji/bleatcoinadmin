package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.IUserRepository;
import manage.bleatcoin.lamb.Admin.entities.Credentials;
import manage.bleatcoin.lamb.Admin.entities.Response;
import manage.bleatcoin.lamb.Admin.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api", produces="application/json")
public class Controller {
    @Autowired
    IUserRepository userRepository;

    @CrossOrigin
    @PostMapping("/getUserByCredentials/{username}/{password}")
    public Object getUserByCredentials(@PathVariable String username, @PathVariable String password) {
        Credentials credentials = new Credentials(username, password);
        User temp = userRepository.findByCredentials(credentials);
        if(temp == null) {
            return new Response(true, "Invalid Credentials");
        }
        return new Response(false, temp.toString());
    }
}
