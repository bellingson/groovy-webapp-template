package com.myapp.model

import com.fasterxml.jackson.annotation.JsonBackReference

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull


@Entity
class Role extends EntityImpl {

    final static String ROLE_ADMIN = 'ROLE_ADMIN'
    final static String ROLE_USER = 'ROLE_USER'

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="userId", nullable=false, updatable=false)
    User user

    @NotNull(message = "Role name is required")
    String name

    String toString() {
        name.substring(5).toLowerCase()
    }

}
