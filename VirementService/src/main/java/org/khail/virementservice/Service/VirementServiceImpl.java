package org.khail.virementservice.Service;

import org.khail.virementservice.Entitie.Virement;
import org.khail.virementservice.Repository.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VirementServiceImpl implements VirementService {

    @Autowired private VirementRepository virementRepository;

    @Override
    public List<Virement> getAllVirements() {
        return virementRepository.findAll();
    }

    @Override
    public Virement getVirementById(int id) {
        return virementRepository.getReferenceById(id);
    }

    @Override
    public Virement addVirement(Virement virement) {
        return virementRepository.save(virement);
    }

    @Override
    public Virement updateVirement(Virement virement) {
        return virementRepository.save(virement);
    }

    @Override
    public void deleteVirement(int id) {
    virementRepository.deleteById(id);
    }
}
