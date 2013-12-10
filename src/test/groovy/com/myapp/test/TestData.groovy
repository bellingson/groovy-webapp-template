package com.myapp.test

import com.myapp.dao.GenericDao
import com.myapp.dao.MyAppDao
import com.myapp.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TestData {

    final static String testEmail = 'foo99@bar.com'

    @Autowired
    GenericDao dao

    @Autowired
    MyAppDao appData

    User makeUser(String email) {

        User user = appData.findUserbyEmail(email)
        if(user)
            return user

        user = new User(firstName: 'Bob', lastName: 'Smith', email: email, roles: [])
        dao.save(user)
        dao.flush()

        return user

    }


}
