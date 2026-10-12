package org.example.autoloc.service;

import org.example.autoloc.entities.Agence;
import java.util.List;

public interface IAgenceService {
    Agence addAgence(Agence agence);
    Agence updateAgence(Agence agence);
    void deleteAgence(Long id);
    Agence getAgenceById(Long id);
    List<Agence> getAllAgences();
}