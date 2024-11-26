package org.khail.virementservice;

import org.khail.virementservice.Entitie.TypeVirement;
import org.khail.virementservice.Entitie.Virement;
import org.khail.virementservice.Feign.BenificiareFiegn;
import org.khail.virementservice.Model.Benificiary;
import org.khail.virementservice.Repository.VirementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class VirementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirementServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner initData(VirementRepository virementRepository,
                               BenificiareFiegn benificiareFiegn) {
        return args -> {


            // Création de quelques virements
            Virement virement1 = new Virement();
            virement1.setMontant(500.0);
            virement1.setDescription("Paiement facture électricité");
            virement1.setDate("2024-11-27");
            virement1.setType(TypeVirement.NORMAL);
         try {
             virement1.setBeneficiaireId(benificiareFiegn.getBenificiarById(1L).getId());
         }catch (Exception e){
             String message = e.getMessage();
             System.out.println(message);
         }
            virement1.setRibSource("FR7612548029981234567890143");

            Virement virement2 = new Virement();
            virement2.setMontant(1000.0);
            virement2.setDescription("Achat matériel informatique");
            virement2.setDate("2024-11-25");
            virement2.setType(TypeVirement.INSTANTANE);
            virement2.setBeneficiaireId(2L);
            virement2.setRibSource("FR7612548029989876543210987");

            // Sauvegarde dans la base de données
            virementRepository.save(virement1);
            virementRepository.save(virement2);

            // Affichage des virements sauvegardés
            virementRepository.findAll().forEach(System.out::println);
        };
    }
}
