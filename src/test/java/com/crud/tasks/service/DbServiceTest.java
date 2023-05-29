package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class DbServiceTest {

    @Autowired
    DbService service;

    @Test
    void getAllTasksTest() {
        //Given
        Task task1 = new Task(1L, "A", "aaa");
        Task task2 = new Task(2L, "B", "bbb");
        Task task3 = new Task(3L, "C", "ccc");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        //When
        service.saveTask(task1);
        service.saveTask(task2);
        service.saveTask(task3);
        List<Task> result = service.getAllTasks();
        //Then
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("A", result.get(0).getTitle());
        //ClenUp
        for (Task task:result){
            service.deleteById(task.getId());
        }
    }

    @Test
    void getTaskTest() throws TaskNotFoundException {
        //Given
        Task task1 = new Task(1L, "A", "aaa");
        Task task2 = new Task(2L, "B", "bbb");
        Task task3 = new Task(3L, "C", "ccc");
        //When
        service.saveTask(task1);
        service.saveTask(task2);
        service.saveTask(task3);
        List<Task> results = service.getAllTasks();
        Task result = service.getTask(results.get(1).getId());
        //Then
        Assertions.assertEquals("bbb", result.getContent());
        //ClenUp
        for (Task task:results){
            service.deleteById(task.getId());
        }
    }

    @Test
    void deleteByIdTest() throws TaskNotFoundException {
        //Given
        Task task1 = new Task(1L, "A", "aaa");
        Task task2 = new Task(2L, "B", "bbb");
        Task task3 = new Task(3L, "C", "ccc");
        //When
        service.saveTask(task1);
        service.saveTask(task2);
        service.saveTask(task3);
        List<Task> results = service.getAllTasks();
        service.deleteById(results.get(1).getId());
        //Then
        Assertions.assertEquals(2,service.getAllTasks().size());
        //ClenUp
        List<Task> result = service.getAllTasks();
        for (Task task:result){
            service.deleteById(task.getId());
        }
    }
    @Test
    void TaskNotFoundExceptionTest(){
        Assertions.assertThrows(TaskNotFoundException.class,()->
                service.getTask(1L));
    }

}
