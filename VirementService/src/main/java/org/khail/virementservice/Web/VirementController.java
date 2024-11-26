package org.khail.virementservice.Web;

import org.khail.virementservice.Entitie.Virement;
import org.khail.virementservice.Service.VirementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("viremnets")
public class VirementController {
    private VirementService virementService;
    public VirementController(VirementService virementService) {
        this.virementService = virementService;
    }

    @GetMapping()
    public List<Virement> getAllVirements() {
        return virementService.getAllVirements();
    }

    @GetMapping("/id")
    public Virement getVirementById(@PathVariable int id) {
        return virementService.getVirementById(id);
    }

    @PostMapping()
    public Virement addVirement(@RequestBody Virement virement) {
        return virementService.addVirement(virement);
    }

    @PutMapping("/{id}")
    public Virement updateVirement(@PathVariable Long id,@RequestBody Virement virement) {
        return virementService.updateVirement(virement);
    }
}
