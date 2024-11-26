package org.khail.beneficiaireservice.Web;

import org.khail.beneficiaireservice.Entities.Beneficiary;
import org.khail.beneficiaireservice.Exception.BeneficiaryNotFoundException;
import org.khail.beneficiaireservice.Service.ServiceBeneficiaryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/beneficiaries")
public class BeneficiaryController {

    @Autowired
    private ServiceBeneficiaryImpl serviceBeneficiary;

    @GetMapping
    public List<Beneficiary> getAllBeneficiaries() {
        return serviceBeneficiary.getAllBeneficiary();
    }

    @GetMapping("/{id}")
    public Beneficiary getBeneficiaryById(@PathVariable Long id) {
        try {
            return serviceBeneficiary.getBeneficiaryById(id);
        } catch (BeneficiaryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public Beneficiary saveBeneficiary(@RequestBody Beneficiary beneficiary) {
        return serviceBeneficiary.addBeneficiary(beneficiary);
    }

    @DeleteMapping("/{id}")
    public void deleteBeneficiary(@PathVariable Long id) {
        serviceBeneficiary.deleteBeneficiary(id);
    }

    @PutMapping("/{id}")
    public Beneficiary updateBeneficiary(@PathVariable Long id, @RequestBody Beneficiary beneficiary) {
        return serviceBeneficiary.updateBeneficiary(beneficiary);
    }
}
