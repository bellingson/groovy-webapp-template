package com.myapp.model

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Entity
import javax.persistence.Transient

@Entity
class User extends EntityImpl {

    String firstName
    String lastName
    String email

    @JsonIgnore
    String password


    @JsonIgnore
    @Transient
    String confPassword




}
