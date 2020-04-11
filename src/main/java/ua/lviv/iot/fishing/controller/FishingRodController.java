package ua.lviv.iot.fishing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.fishing.service.IceRodService;
import ua.lviv.iot.fishing.model.IceRod;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/IceRods")
@RestController
public class FishingRodController {

    private static AtomicInteger counter = new AtomicInteger();

    @Autowired
    private IceRodService iceRodService;

    @GetMapping
    public ArrayList<IceRod> getIceRods() {
        return iceRodService.findAllIceRods();
    }

    @GetMapping(path = "/{id}")
    public IceRod getIceRod(final @PathVariable("id") Integer id) {
        return iceRodService.findIceRod(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<IceRod> putIceRod(final @PathVariable("id") Integer id, final @RequestBody IceRod iceRod) {
        iceRod.setId(id);
        if (iceRodService.checkIfIceExists(id)) {
            return ResponseEntity.ok(iceRodService.updateIceRod(id, iceRod));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<IceRod> deleteIceRod(final @PathVariable("id") Integer id) {
        if (iceRodService.checkIfIceExists(id)) {
            iceRodService.deleteIceRod(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public IceRod createIceRod(final @RequestBody IceRod iceRod) {
        iceRodService.createIceRod(iceRod);
        iceRod.setId(counter.incrementAndGet());
        return iceRod;
    }

}
