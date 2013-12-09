package com.myapp.controllers

import com.myapp.dao.GenericDao
import com.myapp.dao.InputException
import org.apache.log4j.Logger
import org.hibernate.exception.ConstraintViolationException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


import javax.servlet.http.HttpServletRequest

@Controller
class BaseController {

    final Logger log = Logger.getLogger(this.class)

    @Autowired
    GenericDao dao

    @RequestMapping("/")
    String index(HttpServletRequest request) {

        //log.debug("root request: ${request.requestURI}")

        "index"
    }




    @ExceptionHandler(org.springframework.validation.BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody Map handleBindException(org.springframework.validation.BindException ex) {

        if(ex.fieldError )
            return [ message: ex.fieldError.defaultMessage ]

        log.debug("BIND EXCEPTION: ${ex.message}")
        [ message: ex.message ]
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody Map handleError(HttpServletRequest req, Exception exception) {

        exception = exception.cause ? exception.cause : exception

        if(exception instanceof InputException) {
            return [ message: exception.message ]
        }

        if(exception instanceof ConstraintViolationException) {
            ConstraintViolationException cve = exception
            return [ message: "Error: database constraint violation"]
        }

        log.error("Request: " + req.getRequestURL() + " raised " + exception);

        [message:  "Sever Error: " + exception.message ]

    }

}
