package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.ServiceCandidate;
import service.ServiceCandidateImp;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


@Configuration
public class AppConfiguration {

    @Bean
    public ServiceCandidate getServiceCandidate(){
        return new ServiceCandidateImp();
    }

    public EntityManager getEEntityManager(){
        return Persistence.createEntityManagerFactory("hibernate-unit").createEntityManager();
    }
}
