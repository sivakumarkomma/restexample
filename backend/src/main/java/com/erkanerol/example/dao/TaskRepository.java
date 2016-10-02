package com.erkanerol.example.dao;

import com.erkanerol.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by erkan on 29.05.2016.
 */
public interface TaskRepository extends JpaRepository<Task,Long> {

}
