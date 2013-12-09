package com.myapp

import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.Database
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

/*
@Configuration
@ComponentScan
@EnableTransactionManagement
*/
class ApplicationConfig {

    final Logger log = Logger.getLogger(this.class)

    @Autowired
    DataSource dataSource


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.HSQL);
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        //factory.setPackagesToScan(getClass().getPackage().getName());
        factory.setPackagesToScan(this.class.package.name + ".model");
        factory.setDataSource(dataSource);
        factory.setPersistenceUnitName("genericDao")

        log.debug("CREATE FACTORY: ${factory}")

        return factory;
    }


    @Bean
    public PlatformTransactionManager transactionManager() {

        LocalContainerEntityManagerFactoryBean emfb = entityManagerFactory()
        EntityManagerFactory emf = emfb.getNativeEntityManagerFactory()

        JpaTransactionManager txManager = new JpaTransactionManager()
        txManager.setEntityManagerFactory(emf)
        return txManager
    }



}
