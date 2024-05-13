package com.imeghebe.jwt.backend.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "admin")
@PrimaryKeyJoinColumn(name = "admin_id")
public class Admin extends Account{

}