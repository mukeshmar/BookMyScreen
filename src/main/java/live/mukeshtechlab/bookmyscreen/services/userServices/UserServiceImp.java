package live.mukeshtechlab.bookmyscreen.services.userServices;

import live.mukeshtechlab.bookmyscreen.exceptions.UserAlreadyExistException;
import live.mukeshtechlab.bookmyscreen.models.User;
import live.mukeshtechlab.bookmyscreen.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImp(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signUp(String name, String email, String password) throws UserAlreadyExistException {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if(userOptional.isPresent()){
            // User already exists
            throw new UserAlreadyExistException("User already exists");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }
}
