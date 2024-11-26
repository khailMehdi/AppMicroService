package org.khail.beneficiaireservice;


import org.khail.beneficiaireservice.Entities.Beneficiary;
import org.khail.beneficiaireservice.Entities.Type;
import org.khail.beneficiaireservice.Repository.RepositoryBeneficiary;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeneficiaireServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeneficiaireServiceApplication.class, args);
    }

@Bean
    CommandLineRunner commandLineRunner (RepositoryBeneficiary repositoryBeneficiary){
        return args -> {
            Beneficiary beneficiary = Beneficiary.builder()
                    .rib("55544445")
                    .type(Type.PHYSIQUE)
                    .nom("Mehdi")
                    .prenom("Khail")
                    .build() ;
            repositoryBeneficiary.save(beneficiary);
        };
}

}
