package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class AdminLogin {
@Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  private String email;
  @Column(updatable = false)
  private String password;
  private String status;

public AdminLogin()
{
}

public AdminLogin(Long id, String email, String password, String status) {
this.id = id;
this.email = email;
this.password = password;
this.status = status;

}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}



}
