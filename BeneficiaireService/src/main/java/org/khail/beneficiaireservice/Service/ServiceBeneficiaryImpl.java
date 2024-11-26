package org.khail.beneficiaireservice.Service;

import org.khail.beneficiaireservice.Entities.Beneficiary;
import org.khail.beneficiaireservice.Exception.BeneficiaryNotFoundException;
import org.khail.beneficiaireservice.Repository.RepositoryBeneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceBeneficiaryImpl implements ServiceBeneficiary{
    @Autowired private RepositoryBeneficiary repositoryBeneficiary;
    @Override
    public List<Beneficiary> getAllBeneficiary() {
        return repositoryBeneficiary.findAll();
    }

    @Override
    public Beneficiary getBeneficiaryById(Long id) throws BeneficiaryNotFoundException {
     Beneficiary beneficiary=repositoryBeneficiary.findById(id)
                .orElseThrow(() -> new BeneficiaryNotFoundException("Bénéficiaire avec l'ID " + id + " introuvable."));
        return beneficiary ;
    }

    @Override
    public Beneficiary addBeneficiary(Beneficiary beneficiary) {
        return repositoryBeneficiary.save(beneficiary);
    }

    @Override
    public void deleteBeneficiary(Long id)  {
      repositoryBeneficiary.deleteById(id);
    }

    @Override
    public Beneficiary updateBeneficiary(Beneficiary beneficiary) {
        return repositoryBeneficiary.save(beneficiary);

    }
}
