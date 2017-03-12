package dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;


@Configuration

@PropertySource("spring.xml")
public class AppConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManager(){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(getDataSource());
        localContainerEntityManagerFactoryBean.setPersistenceUnitName("hibernate-unit");
        LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
        localContainerEntityManagerFactoryBean.setLoadTimeWeaver(loadTimeWeaver);
        return localContainerEntityManagerFactoryBean;
    }


    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/HibernateElection");
        dataSource.setUsername("root");
        dataSource.setPassword("maslik106");
        return dataSource;
    }
}
