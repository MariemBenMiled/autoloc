package org.example.autoloc.Controllers;

import org.example.autoloc.entities.Agence;
import org.example.autoloc.service.IAgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {

    @Autowired
    private IAgenceService agenceService;

    // 1. CREATE
    @PostMapping
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    // 2. UPDATE
    @PutMapping
    public Agence updateAgence(@RequestBody Agence agence) {
        return agenceService.updateAgence(agence);
    }

    // 3. DELETE
    @DeleteMapping("/{id}")
    public void deleteAgence(@PathVariable Long id) {
        agenceService.deleteAgence(id);
    }

    // 4. READ (One)
    @GetMapping("/{id}")
    public Agence getAgenceById(@PathVariable Long id) {
        return agenceService.getAgenceById(id);
    }

    // 5. READ (All)
    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.getAllAgences();
    }
}