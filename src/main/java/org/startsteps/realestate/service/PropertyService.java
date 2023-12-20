package org.startsteps.realestate.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.startsteps.realestate.model.Property;
import org.startsteps.realestate.model.Realtor;
import org.startsteps.realestate.repository.PropertyRepository;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PropertyService {
    Optional<Property> findByPropertyId(Long propertyId);
    List<Property> findAllProperties();
    Property addProperty(Property property);
    Property updateProperty(Long id, Property property);
    void deleteProperty(Long id);
    List<Property> getPropertiesBetweenDates(Date startDate, Date endDate);

    }
