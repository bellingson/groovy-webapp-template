package com.myapp.controller.user

import com.myapp.dao.InputException
import com.myapp.model.User
import com.myapp.test.BaseTestCase
import org.springframework.beans.factory.annotation.Autowired

import javax.servlet.http.HttpServletRequest
import java.security.Principal

import static org.junit.Assert.*
import org.junit.Test

import static com.myapp.test.TestData.*

import static org.mockito.Mockito.*


class UserControllerTest extends BaseTestCase {

    @Autowired
    UserController controller


    @Test void test_register() {

        String email = 'foo@bar.com'

        User user = new User(firstName: 'Bob', lastName: 'Smith', email: email, roles: [])

        controller.register(user,passBindingResult())

        User user2 = appData.findUserbyEmail(email)

        assertTrue user2 != null
        assertTrue user2 == user

    }

    @Test(expected = org.springframework.validation.BindException) void test_register_BindException() {

        User user = new User()

        controller.register(user,failBindingResult())

    }

    @Test(expected = InputException.class) void test_register_UserExistsException() {

        User user = testData.makeUser(testEmail)

        User user2 = new User(firstName: 'Bob', lastName: 'Smith', email: testEmail, roles: [])

        controller.register(user2,passBindingResult())

    }

    @Test void test_current() {

        User user = testData.makeUser(testEmail)

        Principal principal = new Principal() {

            String getName() {
                testEmail
            }
        }

        HttpServletRequest req = mock(HttpServletRequest.class)
        when(req.getUserPrincipal()).thenReturn(principal)

        User user2 = controller.current(req)

        assertTrue user2 != null
        assertTrue user2 == user

    }

    @Test void test_login_redirect() {

        User user = testData.makeUser(testEmail)

        Principal principal = new Principal() {

            String getName() {
                testEmail
            }
        }

        HttpServletRequest req = mock(HttpServletRequest.class)
        when(req.getUserPrincipal()).thenReturn(principal)

        String r = controller.login_redirect(req)

        assertTrue r == "redirect:/"


    }


}
