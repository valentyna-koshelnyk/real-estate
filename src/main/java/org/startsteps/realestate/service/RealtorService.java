package org.startsteps.realestate.service;

import org.startsteps.realestate.RealEstateApplication;
import org.startsteps.realestate.model.Property;
import org.startsteps.realestate.model.Realtor;
import org.startsteps.realestate.repository.RealtorRepository;

import java.util.List;
import java.util.Optional;

public interface RealtorService {
    Optional<Realtor> findByRealtorId(Long realtorId);
    List<Realtor> findAllRealtors();
    Realtor addRealtor(Realtor realtor);
    Realtor updateRealtor(Long id, Realtor realtor);
    void deleteRealtor(Long id);
}
