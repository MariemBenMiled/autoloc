package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule create(Vehicule vehicule);
    Vehicule update(Long id, Vehicule vehicule);
    void delete(Long id);
    Vehicule findById(Long id);
    List<Vehicule> findAll();

    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);

    List<Vehicule> findByMarque(String marque);
    List<Vehicule> findByCategorie(CategorieVehicule categorie);
    List<Vehicule> findByStatut(StatutVehicule statut);
}