package taxi.service.impl;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.DriverDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;
import taxi.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    private static final Logger logger = LogManager.getLogger(DriverService.class);
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        Driver driverFromDB = driverDao.create(driver);
        logger.info("A new driver was created in DB. Driver id " + driverFromDB.getId());
        return driverFromDB;
    }

    @Override
    public Driver get(Long id) {
        return driverDao.get(id)
                .orElseThrow(() -> new RuntimeException("No driver with id " + id + " was found"));
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        Driver updatedDriver = driverDao.update(driver);
        logger.info("Driver with id " + updatedDriver.getId() + " was updated");
        return updatedDriver;
    }

    @Override
    public boolean delete(Long id) {
        logger.info("Deleting driver with id " + id);
        return driverDao.delete(id);
    }

    @Override
    public Optional<Driver> findByLogin(String login) {
        return driverDao.findByLogin(login);
    }
}
