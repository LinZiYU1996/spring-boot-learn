package com.example.elasticsearch.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/6
 * \* Time: 11:13
 * \* Description:
 * \
 */

@Document(indexName = "es-customer", type = "customer", shards = 2, replicas = 1, refreshInterval = "-1")
@Getter
@Setter
public class Customer {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s']", this.id,
                this.firstName, this.lastName);
    }


}
