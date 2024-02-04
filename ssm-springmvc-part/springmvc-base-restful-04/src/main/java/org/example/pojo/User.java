package org.example.pojo;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;


@Data
public class User {


    private Integer id;
    private String name;
    private Integer age;
}
