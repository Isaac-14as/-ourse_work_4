package com.example.springshop.service;

import com.example.springshop.domain.Bucket;
import com.example.springshop.domain.User;
import com.example.springshop.dto.BucketDTO;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);

    void deleteProducts(Bucket bucket, List<Long> productIds);

    BucketDTO getBucketByUser(String name);

    void commitBucketToOrder(String username);
}
