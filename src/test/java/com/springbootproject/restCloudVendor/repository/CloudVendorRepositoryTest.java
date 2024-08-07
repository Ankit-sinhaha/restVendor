package com.springbootproject.restCloudVendor.repository;

import com.springbootproject.restCloudVendor.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {

    // given - when - then

    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1","Amazon","usa","9999");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    // Positive test scenario
    @Test
    void testFindByVendorName_Found(){
       List<CloudVendor> cloudVendorList =  cloudVendorRepository.findByVendorName("Amazon");
       assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
       assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }



    // Negative test scenario
    @Test
    void testFindByVendorName_Not_Found(){
        List<CloudVendor> cloudVendorList =  cloudVendorRepository.findByVendorName("Google");
        assertThat(cloudVendorList.isEmpty()).isTrue();
    }


}
