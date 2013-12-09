package com.myapp.controllers.admin

import com.myapp.controllers.BaseController
import com.myapp.dao.InputException
import com.myapp.model.Role
import com.myapp.model.User
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

import javax.annotation.PostConstruct
import javax.validation.Valid

@Controller
@RequestMapping(value="/admin/user")
class UserAdminController extends BaseController {


    @RequestMapping(method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody List list() {

        List users = dao.query("from User u")

        return users
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET,headers =["Accept=application/json"])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody User get(@PathVariable("id") Long id) {

        return dao.find(User.class,id)

    }

    @RequestMapping(value="/{id}",method = RequestMethod.POST,headers =["Accept=application/json"])
    @ResponseBody User update(@PathVariable("id") Long id, @RequestBody @Valid User user, BindingResult result) {

        updateOrReusePassword(user)

        if(result.hasErrors())
            throw new BindException(result)

        dao.merge(user)

        return user

    }

    void updateOrReusePassword(User user) {

        if(user.password)
            return

        User savedUser = dao.find(User.class,user.id)
        user.password = savedUser.password

        log.debug("SAVED PWD: ${user.password}")

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") Long id) {

        User user = dao.find(User.class,id)
        if(user == null)
            throw new InputException("User [${id}] does not exist")

        dao.remove(user)

    }


    @RequestMapping(value="/",method = RequestMethod.GET)
    String index() {
        log.debug("admin list view")
        'admin/user/index'
    }

    @PostConstruct
    void initializeDemoUsers() {

        dao.doWithTryCatch {

            log.debug("create test users")

            User admin = initializeDemoUser('admin','admin','')

            admin.addRole(Role.ROLE_ADMIN)
            dao.save(admin)

            User demo = initializeDemoUser('demo','demo','')

        }

    }

    User initializeDemoUser(String email, String firstName, String lastName) {

        User user = dao.find("from User u where u.email = :email",[email: email])
        if(user)
            return user

        user = new User(firstName: firstName, name: firstName, lastName: lastName, email: email, roles:[])
        user.password = User.hash(email)

        user.addRole(Role.ROLE_USER)

        dao.save(user)

        log.debug("CREATED ADMIN: ${user.id}")

        return user
    }



}
