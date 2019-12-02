package com.company;

import org.junit.Before;
import org.junit.Test;

import static com.company.Main.parseTasks;
import static org.junit.Assert.*;

public class TodoTest {

    TodoListManager localManager;

    @Before
    public void setUp() throws Exception {
        localManager = parseTasks();
    }

    @Test
    public void isComplete() {
        assertTrue(localManager.getTodoList(2).manager.todos.get(0).isComplete());
    }
}