package com.myapp.dao

import com.myapp.model.EntityImpl
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository("genericDao")
@Transactional
class GenericDao {

    final Logger log = Logger.getLogger(this.class)

    @PersistenceContext
    EntityManager em


    void persist(Closure c) {

    }

    EntityImpl find(Class clazz, Long id) {
        em.find(clazz,id)
    }

    EntityImpl save(EntityImpl entity) {

        log.debug("save: ${entity.class}")

        em.merge(entity)

    }



}
