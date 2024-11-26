package org.khail.virementservice.Service;

import org.khail.virementservice.Entitie.Virement;
import org.khail.virementservice.Repository.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VirementService {
  public List<Virement> getAllVirements();
  public Virement getVirementById(int id);
  public Virement addVirement(Virement virement);
  public Virement updateVirement(Virement virement);
  public void deleteVirement(int id);


}
