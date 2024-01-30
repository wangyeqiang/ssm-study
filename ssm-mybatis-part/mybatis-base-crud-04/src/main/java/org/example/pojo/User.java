package org.example.pojo;

import lombok.Data;

@Data //lombok  get  set tostring 方法
public class User {
  private Integer id;
  private String username;
  private String password;
}