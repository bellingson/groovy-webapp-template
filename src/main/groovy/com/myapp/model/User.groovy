package com.myapp.model


import com.fasterxml.jackson.annotation.JsonIgnore
import com.myapp.util.StringUtil
import org.hibernate.annotations.Formula
import org.springframework.security.authentication.encoding.ShaPasswordEncoder

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Transient
import javax.validation.constraints.NotNull

@Entity
class User extends EntityImpl {

    @NotNull(message = "First name is required")
    String firstName

    @NotNull(message = "Last name is required")
    String lastName

    @Formula("concat(concat(firstName,' '),lastName)")
    String name

    @NotNull(message = "Email is required")
    @Column(unique=true)
    String email

    String password

    @JsonIgnore
    @Transient
    String confPassword

    @OneToMany(mappedBy = 'user', cascade = [CascadeType.ALL])
    Set<Role> roles


    @Transient
    String getRoleNames() {
        StringUtil.delimit(this?.roles*.toString())
    }

    Role addRole(String name) {

        Role role = roles.find { r -> r.name == name }

        role = role ? role : new Role(user: this, name: name )

        roles << role

        return role
    }

    static String hash(String string) {
        return new ShaPasswordEncoder().encodePassword(string,null)
    }

}
