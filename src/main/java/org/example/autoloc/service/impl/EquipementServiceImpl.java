package org.example.autoloc.service.impl;

import org.example.autoloc.entities.Equipement;
import org.example.autoloc.repository.EquipementRepository;
import org.example.autoloc.service.IEquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementServiceImpl implements IEquipementService {

    @Autowired
    private EquipementRepository equipementRepository;

    @Override
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement updateEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }

    @Override
    public Equipement getEquipementById(Long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }
}