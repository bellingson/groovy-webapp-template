package com.myapp.dao

import com.myapp.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MyAppDao {

    @Autowired
    GenericDao dao

    User findUserbyEmail(String email) {
        dao.find("from User u where u.email = :email",[email: email])
    }


}
