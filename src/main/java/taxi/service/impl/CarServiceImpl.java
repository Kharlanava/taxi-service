package taxi.service.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.CarDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.service.CarService;

@Service
public class CarServiceImpl implements CarService {
    private static final Logger logger = LogManager.getLogger(CarService.class);
    @Inject
    private CarDao carDao;

    @Override
    public void addDriverToCar(Driver driver, Car car) {
        car.getDrivers().add(driver);
        carDao.update(car);
        logger.info("Driver with id " + driver.getId() + " was added to car with id "
                + car.getId());
    }

    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        car.getDrivers().remove(driver);
        carDao.update(car);
        logger.info("Driver with id " + driver.getId() + " was removed from car with id "
                + car.getId());
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        return carDao.getAllByDriver(driverId);
    }

    @Override
    public Car create(Car car) {
        Car carFromDB = carDao.create(car);
        logger.info("A new car was created in DB. Car id " + carFromDB.getId());
        return carFromDB;
    }

    @Override
    public Car get(Long id) {
        return carDao.get(id)
                .orElseThrow(() -> new RuntimeException("No car with id " + id + " was found"));
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public Car update(Car car) {
        Car updatedCar = carDao.update(car);
        logger.info("Car with id " + updatedCar.getId() + " was updated");
        return updatedCar;
    }

    @Override
    public boolean delete(Long id) {
        logger.info("Deleting car with id " + id);
        return carDao.delete(id);
    }
}
