package com.myapp.test

import com.myapp.dao.GenericDao
import com.myapp.dao.MyAppDao
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.Logger
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.validation.BindingResult
import spock.lang.Specification

import javax.sql.DataSource

import static org.junit.Assert.*
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=[ "file:src/main/resources/applicationContext.xml",
                                   "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml",
                                    "file:src/test/resources/applicationContext-junit.xml"])
abstract class BaseTestCase {

    static {
       BasicConfigurator.configure()
    }

    protected final Logger log = Logger.getLogger(this.class)

    @Autowired
    GenericDao dao

    @Autowired
    MyAppDao appData

    @Autowired
    TestData testData


    BindingResult passBindingResult() {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);
        return result
    }

    BindingResult failBindingResult() {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);
        return result
    }


}
