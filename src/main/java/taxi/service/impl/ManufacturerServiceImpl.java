package taxi.service.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.ManufacturerDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Manufacturer;
import taxi.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private static final Logger logger = LogManager.getLogger(ManufacturerService.class);
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        Manufacturer manufacturerFromDB = manufacturerDao.create(manufacturer);
        logger.info("A new manufacturer was created in DB. Manufacturer id "
                + manufacturerFromDB.getId());
        return manufacturerFromDB;
    }

    @Override
    public Manufacturer get(Long id) {
        return manufacturerDao.get(id)
                .orElseThrow(() -> new RuntimeException("No manufacturer with id "
                        + id + " was found"));
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        Manufacturer updatedManufacturer = manufacturerDao.update(manufacturer);
        logger.info("Manufacturer with id " + updatedManufacturer.getId() + " was updated");
        return updatedManufacturer;
    }

    @Override
    public boolean delete(Long id) {
        logger.info("Deleting manufacturer with id " + id);
        return manufacturerDao.delete(id);
    }
}
