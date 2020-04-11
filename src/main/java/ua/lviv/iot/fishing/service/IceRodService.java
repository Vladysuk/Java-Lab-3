package ua.lviv.iot.fishing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.fishing.dataaccess.IceRodRepository;
import ua.lviv.iot.fishing.model.IceRod;

import java.util.ArrayList;

@Service
public class IceRodService {

    @Autowired
    private IceRodRepository iceRodRepository;

    public IceRod createIceRod(IceRod iceRod) {
        return iceRodRepository.save(iceRod);
    }

    public void deleteIceRod(Integer iceRodId) {
        iceRodRepository.deleteById(iceRodId);
    }

    public boolean checkIfIceExists(Integer iceRodId) {
        return iceRodRepository.existsById(iceRodId);
    }

    public IceRod findIceRod(Integer iceRodId) {
        return iceRodRepository.findById(iceRodId).get();
    }

    public ArrayList<IceRod> findAllIceRods() {
        return (ArrayList<IceRod>) iceRodRepository.findAll();
    }

    public IceRod updateIceRod(Integer iceRodId, IceRod iceRod) {
        IceRod oldIceRod = iceRodRepository.findById(iceRodId).get();
        IceRod returnedIceRod = new IceRod(oldIceRod.getLengthInMeters(),oldIceRod.getSeason(),
                oldIceRod.getFoldedLengthInMeters(),oldIceRod.getNumberOfSection(),
                oldIceRod.getWeightInKg(),oldIceRod.getTypeOfFishingLure());
        returnedIceRod.setId(iceRodId);
        iceRod.setId(iceRodId);
        iceRodRepository.save(iceRod);
        return returnedIceRod;
    }


}
