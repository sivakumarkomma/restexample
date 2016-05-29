package com.erkanerol.example.dao;

import com.erkanerol.example.model.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by erkan on 29.05.2016.
 */
@Repository
public class TaskDao{

    @PersistenceContext
    private EntityManager em;


    public List<Task> getAll(){
        return em.createQuery("select t from Task t").getResultList();
    }
}
