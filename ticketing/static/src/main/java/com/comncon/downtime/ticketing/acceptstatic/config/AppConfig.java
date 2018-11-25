package com.comncon.downtime.ticketing.acceptstatic.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Configuration
public class AppConfig {
    @Bean
    @Primary
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSource() {
        DataSourceProperties properties = dataSourceProperties();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }

    @Bean
    @Autowired
    @Qualifier("hibernateProperties")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(Properties hibernateProperties) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.comncon.downtime.scheduler.model");
        em.setJpaProperties(hibernateProperties);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setRollbackOnCommitFailure(true);
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean(name = "hibernateProperties")
    public Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        hibernateProperties.setProperty("showSql", "true");
        hibernateProperties.setProperty("hibernate.showsql", "true");
        return hibernateProperties;
    }
}
