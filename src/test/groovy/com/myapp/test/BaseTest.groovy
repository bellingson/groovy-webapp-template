package com.myapp.test

import com.myapp.dao.GenericDao
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.Logger
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import spock.lang.Specification

import javax.sql.DataSource

import static org.junit.Assert.*


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=[ "classpath:applicationContext.xml","classpath:dispatcher-servlet.xml"])
class BaseTestCase {

    static {
        BasicConfigurator.configure()
    }

    protected final Logger log = Logger.getLogger(this.class)

    @Autowired
    GenericDao dao


}
