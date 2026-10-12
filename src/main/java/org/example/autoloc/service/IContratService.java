package org.example.autoloc.service;

import org.example.autoloc.entities.Contrat;
import java.util.List;

public interface IContratService {
    Contrat addContrat(Contrat contrat);
    Contrat updateContrat(Contrat contrat);
    void deleteContrat(Long id);
    Contrat getContratById(Long id);
    List<Contrat> getAllContrats();
}