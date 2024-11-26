package org.khail.beneficiaireservice.Service;

import org.khail.beneficiaireservice.Entities.Beneficiary;
import org.khail.beneficiaireservice.Exception.BeneficiaryNotFoundException;

import java.util.List;

public interface ServiceBeneficiary {
    List<Beneficiary> getAllBeneficiary();
    Beneficiary getBeneficiaryById(Long Id)throws BeneficiaryNotFoundException;;
    Beneficiary addBeneficiary(Beneficiary beneficiary);
    void deleteBeneficiary(Long id) ;
    Beneficiary updateBeneficiary(Beneficiary beneficiary);



}
