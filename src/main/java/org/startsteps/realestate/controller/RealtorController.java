package org.startsteps.realestate.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.startsteps.realestate.model.Property;
import org.startsteps.realestate.model.Realtor;
import org.startsteps.realestate.service.RealtorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/realtors")
public class RealtorController {
    private RealtorService realtorService;

@Autowired
    public RealtorController(RealtorService realtorService) {
        this.realtorService = realtorService;
    }

    @GetMapping(path = "/realtors")
    ResponseEntity<List<Realtor>> findAllRealtors() {
    List<Realtor> realtors = realtorService.findAllRealtors();
    return new ResponseEntity<>(realtors, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Realtor> findById(@PathVariable Long id) {
        Optional<Realtor> realtor = realtorService.findByRealtorId(id);
        if (realtor.isPresent()) {
            return ResponseEntity.ok(realtor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity<Realtor> createRealtor(@RequestBody Realtor realtor) {
        Realtor newRealtor = realtorService.addRealtor(realtor);
        return new ResponseEntity<>(newRealtor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Realtor> putRealtor(@PathVariable Long id,
                                       @RequestBody Realtor realtor) {
        Realtor updatedRealtor = realtorService.updateRealtor(id, realtor);
        return new ResponseEntity<>(updatedRealtor, HttpStatus.OK);
    }

    @DeleteMapping("/id")
    ResponseEntity<Void> removeRealtor(@PathVariable Long id){
    realtorService.deleteRealtor(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
