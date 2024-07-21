package com.springbootproject.restCloudVendor.repository;

import com.springbootproject.restCloudVendor.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
    // String type for my ID field in my controller
}
