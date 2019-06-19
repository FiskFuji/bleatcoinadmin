package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.entities.Credentials;
import manage.bleatcoin.lamb.Admin.entities.Response;
import manage.bleatcoin.lamb.Admin.entities.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersApplicationTests {

    @Autowired
    Controller controller;

    @MockBean
    IUserRepository userRepository;

    private User u1 = new User("11111", 0, new Credentials("u1", "abc"));

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getUserWhenCredentialInvalid() {
        when(userRepository.findByCredentials(new Credentials("u2", "abc"))).thenReturn(null);
        Assert.assertEquals(new Response(true, "Invalid Credentials"), controller.getUserByCredentials("u2", "abc"));
    }

    @Test
    public void getByUserWhenCredentialsValid() {
        when(userRepository.findByCredentials(new Credentials("u1", "abc"))).thenReturn(u1);
        Assert.assertEquals(u1, controller.getUserByCredentials("u1", "abc"));
    }
}
