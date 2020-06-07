package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
}
