package ua.lviv.iot.fishing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.fishing.service.IceRodService;
import ua.lviv.iot.fishing.model.IceRod;

import java.util.ArrayList;

@RequestMapping("/IceRods")
@RestController
public class FishingRodController {

    @Autowired
    private IceRodService iceRodService;

    @GetMapping
    public ArrayList<IceRod> getIceRods() {
        return iceRodService.findAll();
    }

    @GetMapping(path = "/{id}")
    public IceRod getIceRod(final @PathVariable("id") Integer id) {
        return iceRodService.findById(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<IceRod> updateIceRod(final @PathVariable("id") Integer id, final @RequestBody IceRod iceRod) {
        IceRod previousIceRod = getIceRod(id);
        if (previousIceRod != null) {
            IceRod returnedIceRod = new IceRod(previousIceRod.getLengthInMeters(), previousIceRod.getSeason(), previousIceRod.getFoldedLengthInMeters(),
                    previousIceRod.getNumberOfSection(), previousIceRod.getWeightInKg(), previousIceRod.getTypeOfFishingLure(), previousIceRod.getIceRodSet());
            returnedIceRod.setId(id);
            iceRod.setId(id);
            iceRodService.update(iceRod);
            return ResponseEntity.ok(returnedIceRod);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<IceRod> deleteIceRod(final @PathVariable("id") Integer id) {
        if (iceRodService.checkIfExists(id)) {
            iceRodService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public IceRod createIceRod(final @RequestBody IceRod iceRod) {
        iceRodService.create(iceRod);
        return iceRod;
    }

}
