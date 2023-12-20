package org.startsteps.realestate.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;
import org.startsteps.realestate.model.Realtor;
import org.startsteps.realestate.repository.PropertyRepository;
import org.startsteps.realestate.repository.RealtorRepository;

import java.util.List;
import java.util.Optional;
@Service
public class RealtorServiceImpl implements RealtorService{
    private RealtorRepository realtorRepository;

    @Override
    public Optional<Realtor> findByRealtorId(Long realtorId) {

        return Optional.ofNullable(realtorRepository.findById(realtorId).orElseThrow(() -> new EntityNotFoundException("Realtor not found")));
    }

    @Override
    public List<Realtor> findAllRealtors() {

        return realtorRepository.findAll();
    }

    @Override
    public Realtor addRealtor(Realtor realtor) {
        return realtorRepository.save(realtor);
    }

    @Override
    public Realtor updateRealtor(Long id, Realtor realtorInfo) {
        Realtor realtor = realtorRepository.findById(id).orElseThrow(() ->  new EntityNotFoundException("Realtor not found"));
        realtor.setName(realtorInfo.getName());
        realtor.setEmail(realtorInfo.getEmail());
        realtor.setPhone(realtorInfo.getPhone());
        realtor.setPropertyList(realtorInfo.getPropertyList());
        return realtorRepository.save(realtor);
    }

    @Override
    public void deleteRealtor(Long id) {
        realtorRepository.deleteById(id);
    }
}
