package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule update(Long id, Vehicule vehicule) {
        Vehicule existing = findById(id);
        existing.setImmatriculation(vehicule.getImmatriculation());
        existing.setMarque(vehicule.getMarque());
        existing.setModele(vehicule.getModele());
        existing.setCategorie(vehicule.getCategorie());
        existing.setTarifJournalier(vehicule.getTarifJournalier());
        existing.setStatut(vehicule.getStatut());
        existing.setAgence(vehicule.getAgence());
        return vehiculeRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vehicule introuvable avec id: " + id));
    }

    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = findById(idVehicule);
        Equipement equipement = findEquipement(idEquipement);
        vehicule.getEquipements().add(equipement);   // Vehicule owns the @ManyToMany
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = findById(idVehicule);
        Equipement equipement = findEquipement(idEquipement);
        vehicule.getEquipements().remove(equipement);
        return vehiculeRepository.save(vehicule);
    }

    private Equipement findEquipement(Long idEquipement) {
        return equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new NoSuchElementException("Equipement introuvable avec id: " + idEquipement));
    }

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Question 1 : demarre 5 s apres le lancement, puis toutes les 60 s
    @Scheduled(initialDelay = 5000, fixedRate = 60000)
    public void actualiserEtatVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        System.out.println("===== Actualisation des vehicules =====");
        System.out.println("Nombre total de vehicules : " + vehicules.size());
        System.out.println("Date et heure d'actualisation : " + LocalDateTime.now().format(FMT));
    }

    // Question 3 : tous les lundis a 09h00
    @Scheduled(cron = "0 0 9 * * MON")
    public void genererRapportVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        int total = vehicules.size();
        System.out.println("========== RAPPORT HEBDOMADAIRE DES VEHICULES ==========");
        System.out.println("Nombre total de vehicules : " + total);
        System.out.println("Date et heure de generation : " + LocalDateTime.now().format(FMT));
        System.out.println("========================================================");
    }

    @Override
    public List<Vehicule> findByMarque(String marque) {
        return vehiculeRepository.findByMarque(marque);
    }

    @Override
    public List<Vehicule> findByCategorie(CategorieVehicule categorie) {
        return vehiculeRepository.findByCategorie(categorie);
    }

    @Override
    public List<Vehicule> findByStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }
}