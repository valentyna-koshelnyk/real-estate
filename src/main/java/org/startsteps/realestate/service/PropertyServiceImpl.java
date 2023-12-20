package org.startsteps.realestate.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.startsteps.realestate.model.Property;
import org.startsteps.realestate.model.Realtor;
import org.startsteps.realestate.repository.PropertyRepository;

import java.util.*;

@Service
public class PropertyServiceImpl implements PropertyService{

    PropertyRepository propertyRepository;
@Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Optional<Property> findByPropertyId(Long id) {
        return Optional.ofNullable(propertyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Property not found")));
    }


    @Override
    public List<Property> findAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property updateProperty(Long id, Property propertyInfo) {
        Property property = propertyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Property not found"));
        property.setPropertyType(propertyInfo.getPropertyType());
        property.setArea(propertyInfo.getArea());
        property.setAddress(propertyInfo.getAddress());
        property.setBedrooms(propertyInfo.getBedrooms());
        property.setBathrooms(propertyInfo.getBathrooms());
        property.setPrice(propertyInfo.getPrice());
        property.setRealtor(propertyInfo.getRealtor());
        return propertyRepository.save(property);
    }


    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public List<Property> getPropertiesBetweenDates(java.sql.Date startDate, java.sql.Date endDate) {
      return propertyRepository.findByListingDateBetween((java.sql.Date) startDate, (java.sql.Date) endDate);

    }
//@Override
//    public Map<Realtor, List<Property>> getPropertiesGroupedByRealtor() {
//        List<Property> properties = propertyRepository.findAll();
//        Map<Realtor, List<Property>> propertiesByRealtor = new HashMap<>();
//
//        for (Property property : properties) {
//            propertiesByRealtor.computeIfAbsent(property.getRealtor(), k -> new ArrayList<>()).add(property);
//        }
//
//        return propertiesByRealtor;
//    }





}
