package com.myapp.controllers

import com.myapp.model.User
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

import javax.validation.Valid

@Controller
@RequestMapping("/user")
class UserController extends BaseController {


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody User register(@RequestBody @Valid User user, BindingResult result) {

        log.debug("CREATE USER: ${user}")

        //dao.save(user)

        return user

    }



}
