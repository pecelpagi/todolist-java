package com.galuhrmdh;

import com.galuhrmdh.repository.TodoListRepository;
import com.galuhrmdh.repository.TodoListRepositoryImpl;
import com.galuhrmdh.service.TodoListService;
import com.galuhrmdh.service.TodoListServiceImpl;
import com.galuhrmdh.util.DatabaseUtil;
import com.galuhrmdh.view.TodoListView;

import javax.sql.DataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
