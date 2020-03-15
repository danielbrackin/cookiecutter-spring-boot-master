package org.brackinapps.testapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

  @Id
  @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
  private long role_id;
  private String role;
  
  public Role() {}
  
  public Role(Long role_id, String role) {
    this.role_id = role_id.longValue();
    this.role = role;
  }
  
  public long getRole_id() {
    return role_id;
  }
  
  public void setId(long role_id) {
    this.role_id = role_id;
  }
  
  public String getRole() {
    return role;
  }
  
  public void setRole(String role) {
    this.role = role;
  }
  
  public String toString() {
    return "Role{id=" + role_id + ", role='" + role + '\'' + '}';
  }
}
