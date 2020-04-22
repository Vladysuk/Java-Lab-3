package ua.lviv.iot.fishing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.fishing.model.IceRodSet;
import ua.lviv.iot.fishing.service.IceRodSetService;

import java.util.ArrayList;


@RequestMapping("/IceRodSet")
@RestController
public class IceRodSetController {

    @Autowired
    private IceRodSetService iceRodSetService;

    @GetMapping
    public ArrayList<IceRodSet> getIceRodSets() {
        return iceRodSetService.findAll();
    }

    @GetMapping(path = "/{id}")
    public IceRodSet getIceRodSet(final @PathVariable("id") Integer id) {
        return iceRodSetService.findById(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<IceRodSet> updateIceRodSet(final @PathVariable("id") Integer id, final @RequestBody IceRodSet iceRodSet) {
        IceRodSet previousIceRodSet = getIceRodSet(id);
        if (previousIceRodSet != null) {
            IceRodSet returnedIceRodSet = new IceRodSet(previousIceRodSet.getName(), previousIceRodSet.getPrice());
            returnedIceRodSet.setId(id);
            iceRodSet.setId(id);
            iceRodSetService.update(iceRodSet);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<IceRodSet> deleteIceRodSet(final @PathVariable("id") Integer id) {
        if (iceRodSetService.checkIfExists(id)) {
            iceRodSetService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public IceRodSet createIceRodSet(final @RequestBody IceRodSet iceRodSet) {
        iceRodSetService.create(iceRodSet);
        return iceRodSet;
    }

}
