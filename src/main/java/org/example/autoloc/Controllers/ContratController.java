package org.example.autoloc.Controllers;

import org.example.autoloc.entities.Contrat;
import org.example.autoloc.service.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    @Autowired
    private IContratService contratService;

    // 1. CREATE
    @PostMapping
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    // 2. UPDATE
    @PutMapping
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return contratService.updateContrat(contrat);
    }

    // 3. DELETE
    @DeleteMapping("/{id}")
    public void deleteContrat(@PathVariable Long id) {
        contratService.deleteContrat(id);
    }

    // 4. READ (One)
    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.getContratById(id);
    }

    // 5. READ (All)
    @GetMapping
    public List<Contrat> getAllContrats() {
        return contratService.getAllContrats();
    }
}