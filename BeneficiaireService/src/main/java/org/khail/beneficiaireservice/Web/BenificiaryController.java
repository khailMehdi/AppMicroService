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
public class BenificiaryController {
    @Autowired
    private ServiceBeneficiaryImpl serviceBeneficiary;

    @GetMapping("/Beneficiarys")
    public List<Beneficiary> getAlBenificary() {
        return serviceBeneficiary.getAllBeneficiary();
    }

    @GetMapping("/Beneficiarys/{id}")
    public Beneficiary getBeneficiaryById(@PathVariable Long id) {
        try {
            return serviceBeneficiary.getBeneficiaryById(id);
        } catch (BeneficiaryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/Beneficiarys")
    public Beneficiary saveBenificairy(@RequestBody Beneficiary beneficiary) {
        return serviceBeneficiary.addBeneficiary(beneficiary);
    }

    @DeleteMapping("/Beneficiarys/{id}")
    public void delateBenificiary(@PathVariable long id) {
        serviceBeneficiary.deleteBeneficiary(id);
    }

    @PutMapping("/Beneficiarys/{id}")
    public Beneficiary updateBeneficiarys(@PathVariable Long id, @RequestBody Beneficiary beneficiary){
        return serviceBeneficiary.updateBeneficiary(beneficiary) ;
    }


}
