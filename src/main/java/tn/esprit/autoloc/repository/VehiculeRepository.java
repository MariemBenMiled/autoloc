package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    // Scenario 1 : vehicules d'une marque precise
    List<Vehicule> findByMarque(String marque);

    // Scenario 2 : vehicules d'une categorie donnee
    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    // Scenario 3 : vehicules ayant un statut donne (ex : DISPONIBLE)
    List<Vehicule> findByStatut(StatutVehicule statut);
}