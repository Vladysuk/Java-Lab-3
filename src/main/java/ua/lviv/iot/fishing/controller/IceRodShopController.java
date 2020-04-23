package ua.lviv.iot.fishing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.fishing.model.IceRodShop;
import ua.lviv.iot.fishing.service.IceRodShopService;

import java.util.ArrayList;


@RequestMapping("/IceRodShop")
@RestController
public class IceRodShopController {

    @Autowired
    private IceRodShopService iceRodShopService;

    @GetMapping
    public ArrayList<IceRodShop> getIceRodShops() {
        return iceRodShopService.findAll();
    }

    @GetMapping(path = "/{id}")
    public IceRodShop getIceRodShop(final @PathVariable("id") Integer id) {
        return iceRodShopService.findById(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<IceRodShop> updateIceRodShop(final @PathVariable("id") Integer id, final @RequestBody IceRodShop iceRodShop) {
        IceRodShop previousIceRodShop = getIceRodShop(id);
        if (previousIceRodShop != null) {
            IceRodShop returnedIceRodShop = new IceRodShop(previousIceRodShop.getShopName(), previousIceRodShop.getLocationInTown());
            returnedIceRodShop.setId(id);
            iceRodShop.setId(id);
            iceRodShopService.update(iceRodShop);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<IceRodShop> deleteIceRodShop(final @PathVariable("id") Integer id) {
        if (iceRodShopService.checkIfExists(id)) {
            iceRodShopService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public IceRodShop createIceRodShop(final @RequestBody IceRodShop iceRodShop) {
        iceRodShopService.create(iceRodShop);
        return iceRodShop;
    }


}
