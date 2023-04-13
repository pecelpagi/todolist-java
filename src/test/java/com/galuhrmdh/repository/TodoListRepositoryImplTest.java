package com.galuhrmdh.repository;

import com.galuhrmdh.entity.Todolist;
import com.galuhrmdh.util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoListRepositoryImplTest {

    private HikariDataSource dataSource;

    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        Todolist todolist = new Todolist();
        todolist.setTodo("galuh");

        todoListRepository.add(todolist);
    }

    @Test
    void testRemove() {
        System.out.println(todoListRepository.remove(5));
        System.out.println(todoListRepository.remove(1));
    }

    @Test
    void testGetAll() {
        todoListRepository.add(new Todolist("Galuh"));
        todoListRepository.add(new Todolist("Muhamad"));
        todoListRepository.add(new Todolist("Ramadhan"));

        Todolist[] todolists = todoListRepository.getAll();
        for (var todo : todolists) {
            System.out.println(todo.getId() + " : " + todo.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
