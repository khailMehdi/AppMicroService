package org.khail.virementservice.Repository;

import org.khail.virementservice.Entitie.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirementRepository extends JpaRepository<Virement, Integer> {

}
