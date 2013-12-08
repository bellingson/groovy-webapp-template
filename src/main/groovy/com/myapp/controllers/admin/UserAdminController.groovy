package com.myapp.controllers.admin

import com.myapp.controllers.BaseController
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
@RequestMapping(value="/admin/user")
class UserAdminController extends BaseController {


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody User create(@RequestBody @Valid User user, BindingResult result) {

        log.debug("CREATE USER: ${user}")

        return null

    }



}
