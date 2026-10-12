package org.example.autoloc.service.impl;

import org.example.autoloc.entities.Contrat;
import org.example.autoloc.repository.ContratRepository;
import org.example.autoloc.service.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements IContratService {

    @Autowired
    private ContratRepository contratRepository;

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(Long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat getContratById(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }
}