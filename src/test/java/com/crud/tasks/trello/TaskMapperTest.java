package com.crud.tasks.trello;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskMapperTest {
    TaskMapper taskMapper = new TaskMapper();
    @Test
    public void mapToTaskTest(){
        //Given
        TaskDto taskDto = new TaskDto(1L,"A","abc");
        //When
        Task result = taskMapper.mapToTask(taskDto);
        //Then
        Assertions.assertEquals("A", result.getTitle());
        Assertions.assertEquals(1L, result.getId());
    }
    @Test
    public void mapToTaskDtoTest(){
        //Given
        Task task = new Task(1L,"A","abc");
        //When
        TaskDto result = taskMapper.mapToTaskDto(task);
        //Then
        Assertions.assertEquals("A", result.getTitle());
        Assertions.assertEquals("abc", result.getContent());
    }
    @Test
    public void mapToTaskDtoListTest(){
        //Given
        List<Task> taskList = new ArrayList<>();
        List<Task> emptyTaskList = new ArrayList<>();
        Task task1 = new Task(1L,"A","abc");
        Task task2 = new Task(2L,"B","def");
        Task task3 = new Task(3L,"C","ghi");
        Task task4 = new Task(4L,"D","jkl");
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        List<TaskDto> emptyTaskDtoList = taskMapper.mapToTaskDtoList(emptyTaskList);
        //Then
        Assertions.assertEquals(4, taskDtoList.size());
        Assertions.assertEquals(2L, taskDtoList.get(1).getId());
        Assertions.assertNotNull(emptyTaskDtoList);
    }
}
