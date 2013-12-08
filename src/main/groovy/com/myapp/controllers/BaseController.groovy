package com.myapp.controllers

import com.myapp.dao.GenericDao
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired

class BaseController {

    final Logger log = Logger.getLogger(this.class)

    @Autowired
    GenericDao dao



}
