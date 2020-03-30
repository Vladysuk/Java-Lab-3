package ua.lviv.iot.fishing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.fishing.model.IceRod;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@RequestMapping("/IceRods")
@RestController
public class FishingRodController {

    private static Map<Integer, IceRod> iceRods = new HashMap<>();
    private static AtomicInteger counter = new AtomicInteger();

    @GetMapping
    public LinkedList<IceRod> getIceRods() {
        return new LinkedList<>(iceRods.values());
    }

    @GetMapping(path = "/{id}")
    public IceRod getIceRod(final @PathVariable("id") Integer id) {
        return iceRods.get(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> putIceRod(final @PathVariable("id") Integer id, final @RequestBody IceRod iceRod) {
        iceRod.setId(id);
        if (iceRods.containsKey(id)) {
            return ResponseEntity.ok(iceRods.put(id, iceRod));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteIceRod(final @PathVariable("id") Integer id) {
        HttpStatus status = iceRods.remove(id) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public IceRod createIceRod(final @RequestBody IceRod iceRod) {
        iceRod.setId(counter.incrementAndGet());
        iceRods.put(iceRod.getId(), iceRod);
        return iceRod;
    }

}
