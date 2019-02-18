package com.comncon.downtime.ticketing.accept.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@ComponentScan(basePackages = {"com.comncon.downtime.ticketing.accept"})
@Configuration
@EnableKafka
@EnableFeignClients(basePackages = {"com.comncon.downtime.ticketing.accept.client"})
public class AppConfig {

//    @Bean
//    public NewTopic topic() {
//        return new NewTopic("tickets", 1, (short) 1);
//    }

//    @Bean
//    public static ConsumerFactory<String, Object> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
//                new JsonDeserializer<>());
//    }
//
//    @Bean
//    @Autowired
//    public ConsumerFactory<String, Object> consumerFactory(KafkaProperties consumerConfigs) {
//        return new DefaultKafkaConsumerFactory<>(consumerConfigs.buildConsumerProperties());
//    }
//
//
//    @Bean
//    @Primary
//    public KafkaProperties consumerConfigs() {
//        return new KafkaProperties();
//    }


//    @Bean
//    public KafkaTemplate<String, Object> kafkaTemplate() {
//        return new KafkaTemplate<String, Object>(kafkaJsonListenerContainerFactory());
//    }
    /*@Bean
    @Primary
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }*/

//    @Bean
//    public DataSource dataSource() {
//        DataSourceProperties properties = dataSourceProperties();
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(properties.getDriverClassName());
//        dataSource.setUrl(properties.getUrl());
//        dataSource.setUsername(properties.getUsername());
//        dataSource.setPassword(properties.getPassword());
//        return dataSource;
//    }
//
//    @Bean
//    @Autowired
//    @Qualifier("hibernateProperties")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(Properties hibernateProperties) {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan("com.comncon.downtime.scheduler.model");
//        em.setJpaProperties(hibernateProperties);
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        return em;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setRollbackOnCommitFailure(true);
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }
//
//    @Bean(name = "hibernateProperties")
//    public Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
//        hibernateProperties.setProperty("showSql", "true");
//        hibernateProperties.setProperty("hibernate.showsql", "true");
//        return hibernateProperties;
//    }
}
