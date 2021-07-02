package taxi.service;

import javax.naming.AuthenticationException;
import taxi.model.Driver;

public interface AuthenticationService {
    Driver login(String username, String password) throws AuthenticationException;
}
