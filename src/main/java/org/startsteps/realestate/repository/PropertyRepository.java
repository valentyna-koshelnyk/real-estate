package org.startsteps.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.startsteps.realestate.model.Property;
import org.startsteps.realestate.model.PropertyType;
import org.startsteps.realestate.model.Realtor;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property findByAddress(String address);

    Optional<Property> findByPropertyId(Long propertyId);
    List<Property> findAll();
    List<Property> findByPropertyType(PropertyType type);
    List<Property> findByPriceLessThan(double a);
    List<Property> findByPriceBetween(double a, double b);
    List<Property> findByBedrooms(int amount);
    List<Property> findByBathrooms(int amount);
    List<Property> findByListingDateBetween(Date start, Date end);


}
