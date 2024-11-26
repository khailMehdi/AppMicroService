package org.khail.virementservice.Service;

import jakarta.persistence.EntityNotFoundException;
import org.khail.virementservice.Entitie.Virement;
import org.khail.virementservice.Exception.ViremenNotFoundException;
import org.khail.virementservice.Repository.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VirementServiceImpl implements VirementService {
@Autowired private VirementRepository virementRepository;
    @Override
    public List<Virement> getAllVirement() {
        return virementRepository.findAll();
    }

    @Override
    public Virement getVirenmtById(Long id) throws ViremenNotFoundException {
        return virementRepository.findById(id)
                .orElseThrow(() -> new ViremenNotFoundException("Virement not found id " + id));
    }

    @Override
    public Virement addVirement(Virement virement) {
        System.out.println(virement);
        return virementRepository.save(virement);
    }

    @Override
    public void delateVirement(Long id) {
      virementRepository.deleteById(id);
    }

    @Override
    public Virement updateVirement(Virement virement) {
        return virementRepository.save(virement);
    }
}



