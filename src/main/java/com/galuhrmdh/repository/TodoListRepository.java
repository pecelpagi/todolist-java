package com.galuhrmdh.repository;

import com.galuhrmdh.entity.Todolist;

public interface TodoListRepository {

    Todolist[] getAll();

    void add(Todolist todolist);

    boolean remove(Integer number);

}
