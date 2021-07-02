package taxi.service.impl;

import java.util.Optional;
import javax.naming.AuthenticationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.lib.Injector;
import taxi.lib.Service;
import taxi.model.Driver;
import taxi.service.AuthenticationService;
import taxi.service.DriverService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Injector injector = Injector.getInstance("taxi");
    private static final Logger logger = LogManager.getLogger(AuthenticationService.class);
    private DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Optional<Driver> driverByLogin = driverService.findByLogin(login);
        if (driverByLogin.isPresent() && driverByLogin.get().getPassword().equals(password)) {
            Driver driver = driverByLogin.get();
            logger.info("Successful login with login: " + login + ", password: " + password);
            return driver;
        }
        logger.error(new AuthenticationException("Can't login with login: " + login
                + ", password: " + password));
        throw new AuthenticationException("Can't login with login: " + login
                + ", password: " + password);
    }
}
