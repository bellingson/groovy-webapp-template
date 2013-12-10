package com.myapp.controller.admin

import com.myapp.model.User
import com.myapp.test.BaseTestCase
import org.springframework.beans.factory.annotation.Autowired

import static com.myapp.test.TestData.*
import static org.junit.Assert.*
import org.junit.Test


class UserAdminControllerTest extends BaseTestCase {

    @Autowired
    UserAdminController controller


    @Test void test_list() {

        User user = testData.makeUser(testEmail)

        List users = controller.list()

        assertTrue users.contains(user)
    }

    @Test void test_get() {

        User user = testData.makeUser(testEmail)

        User user2 = controller.get(user.id)

        assertTrue user2 != null
        assertTrue user2 == user
    }

    @Test void test_update() {

        User user = testData.makeUser(testEmail)

        user.firstName = 'James'

        controller.update(user.id,user,passBindingResult())

        dao.flush()

        User user2 = dao.find(User.class,user.id)

        assertTrue user2 != null

        assertTrue user2.firstName == 'James'

    }

    @Test(expected = org.springframework.validation.BindException) void test_update_BindException() {

        User user = testData.makeUser(testEmail)

        user.firstName = 'James'

        controller.update(user.id,user,failBindingResult())

    }

    @Test void test_delete() {

        User user = testData.makeUser(testEmail)

        controller.delete(user.id)

        dao.flush()

        user = dao.find(User.class,user.id)

        assertTrue user == null
    }

    @Test void test_index() {


        String r = controller.index()

        assertTrue r == 'admin/user/index'

    }


}
