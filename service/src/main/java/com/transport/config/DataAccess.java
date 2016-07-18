package com.transport.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Created by 1 on 6/6/2016.
 */
@Configuration
@EnableJpaRepositories("com.transport.repository")
@ComponentScan("com.transport")
public class DataAccess {

    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Bean
    DriverManagerDataSource dataSource() {
        final DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName(driver);
        dm.setUrl(url);
        dm.setUsername(user);
        dm.setPassword(password);
        return dm;
    }

    @Bean
    EntityManagerFactory entityManagerFactory(){

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setPackagesToScan("com.transport.model");
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

    @Bean
    public JavaMailSenderImpl javaMailSenderImpl(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        //Set gmail email id
        mailSender.setUsername("textmesweet@gmail.com");
        //Set gmail email password
        mailSender.setPassword("Rr123456");
        Properties prop = mailSender.getJavaMailProperties();
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.debug", "true");
        return mailSender;
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
}
