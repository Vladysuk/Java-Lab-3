package ua.lviv.iot.fishing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.fishing.dataaccess.IceRodSetRepository;
import ua.lviv.iot.fishing.model.IceRodSet;

@Service
public class IceRodSetService extends AbstractService<IceRodSet> {

    @Autowired
    private IceRodSetRepository iceRodSetRepository;

    @Override
    protected JpaRepository<IceRodSet, Integer> getRepository() {
        return iceRodSetRepository;
    }

}
