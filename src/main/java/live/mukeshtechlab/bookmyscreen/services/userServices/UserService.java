package live.mukeshtechlab.bookmyscreen.services.userServices;

import live.mukeshtechlab.bookmyscreen.exceptions.UserAlreadyExistException;
import live.mukeshtechlab.bookmyscreen.models.User;

public interface UserService {
    public User signUp(String name, String email, String password) throws UserAlreadyExistException;
}
