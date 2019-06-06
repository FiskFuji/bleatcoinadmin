package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.entities.Credentials;
import manage.bleatcoin.lamb.Admin.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
    User findByCredentials(Credentials credentials);
}
