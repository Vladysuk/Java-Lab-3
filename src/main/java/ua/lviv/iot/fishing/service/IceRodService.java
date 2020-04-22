package ua.lviv.iot.fishing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.fishing.dataaccess.IceRodRepository;
import ua.lviv.iot.fishing.model.IceRod;

@Service
public class IceRodService extends AbstractService<IceRod> {

    @Autowired
    private IceRodRepository iceRodRepository;

    @Override
    protected JpaRepository<IceRod, Integer> getRepository() {
        return iceRodRepository;
    }

}
