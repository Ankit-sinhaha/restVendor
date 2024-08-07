package com.springbootproject.restCloudVendor.service;

import com.springbootproject.restCloudVendor.model.CloudVendor;
import com.springbootproject.restCloudVendor.repository.CloudVendorRepository;
import com.springbootproject.restCloudVendor.service.impl.CloudVendorServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;

    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1","Amazon","USA","99999");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor(){
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("success");
    }

    @Test
    void testUpdateCloudVendor(){
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("success");
    }

    @Test
    void testGetCloudVendor(){
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("1").getVendorName()).isEqualTo(cloudVendor.getVendorName());
    }

    @Test
    void testGetAllCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll( )).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
    }

    @Test
    void testGetByVendorname(){
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findByVendorName("Amazon")).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));

        // assertThat(cloudVendorService.getBy)
    }

    @Test
    void testDeleteCloudVendor(){
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

    }


}
