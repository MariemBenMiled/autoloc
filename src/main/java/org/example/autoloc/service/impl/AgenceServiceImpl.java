package org.example.autoloc.service.impl;

import org.example.autoloc.entities.Agence;
import org.example.autoloc.repository.AgenceRepository;
import org.example.autoloc.service.IAgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceServiceImpl implements IAgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence updateAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void deleteAgence(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public Agence getAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }
}