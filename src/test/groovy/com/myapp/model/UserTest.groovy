package com.myapp.model

import com.myapp.test.BaseTestCase
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import javax.sql.DataSource

class UserTest extends BaseTestCase {

    User user

    def setup() {
        log.debug("user spock setup")
        user = new User(firstName: 'bob',lastName: 'jones', name: 'Bob Jones', email: 'bob@jones.com', roles: [])
    }

    def "creates a user"() {

        when:
            user.email = 'demo'

        then:
            user.email == 'demo'


    }

    def "adds a role to user"() {

        log.debug("adds a role to user")

        when:
            user.addRole(Role.ROLE_ADMIN)

        then:
            user.hasRole(Role.ROLE_ADMIN)


    }

    def "it hashes a password"() {

        when:
            user.password = User.hash('password')

        then:
            user.password != 'password'

    }


}
