package org.example.autoloc.service.impl;

import org.example.autoloc.entities.Paiement;
import org.example.autoloc.repository.PaiementRepository;
import org.example.autoloc.service.IPaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImpl implements IPaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Override
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement updatePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }

    @Override
    public Paiement getPaiementById(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }
}