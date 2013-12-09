package com.myapp.service

import com.myapp.dao.GenericDao
import com.myapp.dao.GenericDaoImpl
import com.myapp.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class DataService {

    @Autowired
    GenericDao genericDao

    List<User> getUsers() {
       genericDao.query("select u from User u")
    }

    void saveUser(User user) {
        genericDao.save(user)
    }




}
