package org.khail.virementservice.Web;

import org.khail.virementservice.Entitie.Virement;
import org.khail.virementservice.Exception.ViremenNotFoundException;
import org.khail.virementservice.Service.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class VirementController {
    @Autowired
    private VirementService virementService;

    @GetMapping("/Virments")
    public List<Virement> gatAllVirement() {
        return virementService.getAllVirement();
    }

    @GetMapping("/Virments/{id}")
    public Virement getVirementById(@PathVariable Long id) {
        try {
            return virementService.getVirenmtById(id);
        } catch (ViremenNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/Virments")
    public Virement addVirement(@RequestBody Virement virement) {
        return virementService.addVirement(virement);
    }

    @PutMapping ("/Virments/{id}")
    public Virement updateVirement(@PathVariable Long id ,@RequestBody Virement virement){
        return virementService.updateVirement(virement);
    }

}
