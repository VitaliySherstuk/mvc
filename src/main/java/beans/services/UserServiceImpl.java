package beans.services;

import beans.daos.UserDAO;
import beans.models.Ticket;
import beans.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/1/2016
 * Time: 7:30 PM
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;


    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(@Qualifier("userDAO") UserDAO userDAO,  @Qualifier("encoder") BCryptPasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(
            User user) {

        String password = user.getPassword();
        String encodedPass = passwordEncoder.encode(password);
        user.setPassword(encodedPass);
        return userDAO.create(user);
    }

    public void remove(User user) {
        userDAO.delete(user);
    }

    public User getById(long id) {
        return userDAO.get(id);
    }

    public User getUserByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    public List<User> getUsersByName(String name) {
        return userDAO.getAllByName(name);
    }

    public List<Ticket> getBookedTickets() {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
