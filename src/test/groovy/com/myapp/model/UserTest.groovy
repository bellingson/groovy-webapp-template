package com.myapp.model

import com.myapp.test.BaseTestCase
import org.junit.Test

import javax.validation.ConstraintViolationException

import static org.junit.Assert.assertTrue

class UserTest extends BaseTestCase {

    String testEmail = 'test@test.com'

    @Test void test_save_user() {

        User user = findUserByEmail(testEmail)

        assertTrue user == null

        user = new User(firstName: 'Bob', lastName: 'Smith', email: testEmail, roles: [])

        dao.save(user)

        dao.flush()

        User user2 = findUserByEmail(testEmail)

        assertTrue user2 != null

        assertTrue user2 == user

    }

    // TODO - fix
    @Test(expected = ConstraintViolationException.class) void test_save_user_invalid() {

        List<User> users = dao.query('from User u')
        dao.remove(users)

        dao.save(new User())

        users = dao.query('from User u')

        log.debug(users)

    }

    User findUserByEmail(String email)  {
        dao.find("from User u where u.email = :email",[email: email])
    }



}
