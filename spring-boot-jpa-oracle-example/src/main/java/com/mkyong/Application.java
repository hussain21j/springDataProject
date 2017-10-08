package com.mkyong;

import com.mkyong.dao.CountryRepository;
import com.mkyong.dao.CustomerRepository;
import com.mkyong.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import java.text.SimpleDateFormat;

import static java.lang.System.exit;

//for jsr310 java 8 java.time.*
//@EntityScan(
//        basePackageClasses = { SpringBootConsoleApplication.class, Jsr310JpaConverters.class }
//)
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    DataSource dataSource;

    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    CountryRepository countryRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        System.out.println("DATASOURCE = " + dataSource);

       /* System.out.println("\n1.findAll()...");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }

        System.out.println("\n2.findByEmail(String email)...");
        for (Customer customer : customerRepository.findByEmail("222@yahoo.com")) {
            System.out.println(customer);
        }

        System.out.println("\n3.findByDate(Date date)...");
        for (Customer customer : customerRepository.findByDate(sdf.parse("2017-02-12"))) {
            System.out.println(customer);
        }

        // For Stream, need @Transactional
        System.out.println("\n4.findByEmailReturnStream(@Param(\"email\") String email)...");
        try (Stream<Customer> stream = customerRepository.findByEmailReturnStream("333@yahoo.com")) {
            stream.forEach(x -> System.out.println(x));
        }*/

        //System.out.println("....................");
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //Date from = sdf.parse("2017-02-15");
        //Date to = sdf.parse("2017-02-17");

        //for (Customer customer : customerRepository.findByDateBetween(from, to)) {
        //    System.out.println(customer);
        //}
        
        
        System.out.println("********Starting the Customer repository db oerations*********");
        System.out.println("**************************************************************\n\n\n");
        System.out.println("*************************Saving a new country*************************************");
        Country country = new Country();
        country.setCountryCode("IND");
        country.setCountryName("India");
        countryRepository.save(country);
        
        Country country1 = new Country();
        country1.setCountryCode("BLG");
        country1.setCountryName("Belgium");
        countryRepository.save(country1);
        
        
        Country country2 = new Country();
        country2.setCountryCode("NLD");
        country2.setCountryName("Netherlands");
        countryRepository.save(country2);
        
        System.out.println("********************Display the countries from the database***********************");
        for(Country countryLocal : countryRepository.findAll()){
        	System.out.println(countryLocal);
        }
        
        System.out.println("********************find by country name = India***********************");
        
        for(Country countryLocal : countryRepository.findByCountryName("India")){
        	System.out.println(countryLocal);
        }
        
        System.out.println("********************find by country code = NLD***********************");
        
        for(Country countryLocal : countryRepository.findByCountryCode("NLD")){
        	System.out.println(countryLocal);
        }
        

        System.out.println("Done!");

        exit(0);
    }

}