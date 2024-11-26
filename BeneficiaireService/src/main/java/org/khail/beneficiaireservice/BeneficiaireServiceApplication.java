package org.khail.beneficiaireservice;


import org.khail.beneficiaireservice.Entities.Beneficiary;
import org.khail.beneficiaireservice.Entities.Type;
import org.khail.beneficiaireservice.Repository.RepositoryBeneficiary;
import org.khail.beneficiaireservice.Service.ServiceBeneficiaryImpl;
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
    CommandLineRunner initDatabase(ServiceBeneficiaryImpl serviceBeneficiary,
                                   RepositoryBeneficiary repositoryBeneficiary) {
        return args -> {

            Beneficiary beneficiary1 = Beneficiary.builder()
                    .nom("Doe")
                    .prenom("John")
                    .rib("RIB123456789")
                    .type(Type.MORALE)
                    .build();

            Beneficiary beneficiary2 = Beneficiary.builder()
                    .nom("Smith")
                    .prenom("Anna")
                    .rib("RIB987654321")
                    .type(Type.MORALE)
                    .build();

            // Sauvegarde via le service

            repositoryBeneficiary.save(beneficiary1);
            repositoryBeneficiary.save(beneficiary2);
            System.out.println("Bénéficiaires initialisés !");
        };
    }

}
