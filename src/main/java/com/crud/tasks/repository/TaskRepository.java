package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task,Long> {

    List<Task> findAll();

    Task save(Task task);

    Optional<Task> findById(Long id);

    void deleteById(Long id);
}
