package org.khail.virementservice.Service;

import org.khail.virementservice.Entitie.Virement;
import org.khail.virementservice.Exception.ViremenNotFoundException;

import java.util.List;

public interface VirementService {
     List<Virement> getAllVirement();
     Virement getVirenmtById(Long id) throws ViremenNotFoundException;
     Virement addVirement(Virement virement);
     void delateVirement(Long id);
     Virement updateVirement(Virement virement);

}
