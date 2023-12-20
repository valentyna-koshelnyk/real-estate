package org.startsteps.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.startsteps.realestate.model.Property;
import org.startsteps.realestate.service.PropertyService;
import org.startsteps.realestate.service.RealtorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    private PropertyService propertyService;
    private RealtorService realtorService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    ResponseEntity<List<Property>> findAllProperties() {
        List<Property> properties = propertyService.findAllProperties();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Property> findById(@PathVariable Long id) {
        Optional<Property> property = propertyService.findByPropertyId(id);
        if (property.isPresent()) {
            return ResponseEntity.ok(property.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity<Property> createProperty(@RequestBody Property property){
            Property newProperty = propertyService.addProperty(property);
            return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Property> putProperty(@PathVariable Long id, @RequestBody Property property){
        Property updatedProperty = propertyService.updateProperty(id, property);
        return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> removeProperty(@PathVariable Long id){
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}





