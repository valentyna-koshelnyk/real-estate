package org.startsteps.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.startsteps.realestate.model.Property;
import org.startsteps.realestate.model.Realtor;

import java.util.Optional;

public interface RealtorRepository extends JpaRepository<Realtor, Long> {

    Realtor findByName(String name);
    Optional<Realtor> findByRealtorId(Long realtorId);
    Realtor findByEmailOrPhone (String email, String phone);


}
