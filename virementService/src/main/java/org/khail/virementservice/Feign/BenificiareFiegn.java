package org.khail.virementservice.Feign;

import org.khail.virementservice.Model.Benificiary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BENEFICIAIRESERVICE" )
public interface BenificiareFiegn {
    @GetMapping("/Beneficiarys")
    PagedModel<Benificiary> getAllBenificiar();

    @GetMapping("/Beneficiarys/{id}")
    Benificiary getBenificiarById(@PathVariable("id") Long id);
}
