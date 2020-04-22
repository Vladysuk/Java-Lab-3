package ua.lviv.iot.fishing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.fishing.dataaccess.IceRodShopRepository;
import ua.lviv.iot.fishing.model.IceRodShop;

@Service
public class IceRodShopService extends AbstractService<IceRodShop> {

    @Autowired
    private IceRodShopRepository iceRodShopRepository;

    @Override
    protected JpaRepository<IceRodShop, Integer> getRepository() {
        return iceRodShopRepository;
    }

}
