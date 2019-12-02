package com.company;

import org.junit.Before;
import org.junit.Test;

import static com.company.Main.parseTasks;
import static org.junit.Assert.*;

public class TodoListManagerTest {

    TodoListManager localManager;

    @Before
    public void setUp() throws Exception {
        localManager = parseTasks();
    }

    @Test
    public void getTodoList() {
        assertEquals(2,localManager.getTodoList(2).getId());
    }
}