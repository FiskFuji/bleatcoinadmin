package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.entities.Credentials;
import manage.bleatcoin.lamb.Admin.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class UserDbSeeder implements CommandLineRunner {
    private static HashMap<String, Integer> createMap(String key, Integer val)
    {
        HashMap<String,Integer> myMap = new HashMap<>();
        myMap.put(key, val);
        return myMap;
    }

    @Autowired
    IUserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("11111", createMap("111", 2), new Credentials("u1", "abc"));
        User u2 = new User("22222", createMap("222", 1), new Credentials("u2", "abc"));
        User u3 = new User("33333", createMap("333", 3), new Credentials("u3", "abc"));
        userRepository.deleteAll();
        List<User> users = Arrays.asList(u1, u2, u3);
        userRepository.saveAll(users);
    }
}
