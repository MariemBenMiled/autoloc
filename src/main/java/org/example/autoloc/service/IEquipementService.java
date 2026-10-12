package org.example.autoloc.service;

import org.example.autoloc.entities.Equipement;
import java.util.List;

public interface IEquipementService {
    Equipement addEquipement(Equipement equipement);
    Equipement updateEquipement(Equipement equipement);
    void deleteEquipement(Long id);
    Equipement getEquipementById(Long id);
    List<Equipement> getAllEquipements();
}