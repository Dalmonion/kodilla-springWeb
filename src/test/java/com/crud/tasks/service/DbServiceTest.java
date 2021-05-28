package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository repository;

    @Test
    void shouldGetAllTasks() {
        // Given
        List<Task> tasks = List.of(new Task(1L,"test1","test content1"),
                new Task(2L,"test2","test content2"));
        when(repository.findAll()).thenReturn(tasks);
        // When
        List<Task> allTasks = dbService.getAllTasks();

        // Then
        assertEquals(tasks.size(), allTasks.size());

    }

    @Test
    void shouldGetSpecificTask() {
        // Given
        List<Task> tasks = List.of(new Task(1L,"test1","test content1"),
                new Task(2L,"test2","test content2"));
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(tasks.get(1)));
        // When
        Optional<Task> allTasks = dbService.getTask(1L);

        // Then
        assertTrue(allTasks.isPresent());
        assertEquals("test content2", allTasks.get().getContent());
        assertEquals("test2", allTasks.get().getTitle());
        assertEquals(2, allTasks.get().getId());
    }

    @Test
    void shouldSaveTask() {
        // Given
        Task task = new Task(1L,"test1","test content1");
        when(repository.save(any(Task.class))).thenReturn(task);
        // When
        Task savedTask = dbService.saveTask(task);

        // Then
        assertEquals(1, savedTask.getId());
        assertEquals("test1", savedTask.getTitle());
        assertEquals("test content1", savedTask.getContent());
    }

    @Test
    void shouldDeleteTask() {
        // Given
        Task task = new Task(1L,"test1","test content1");

        // When
        dbService.deleteTask(1);

        // Then
        verify(repository, times(1)).deleteById(1L);
    }
}