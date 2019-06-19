package manage.bleatcoin.lamb.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class UserDbSeeder implements CommandLineRunner {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // --- Database seeding complete. Do nothing. ---
    }
}
