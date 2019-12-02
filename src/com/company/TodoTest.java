package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        assertTrue(localManager.getTodoList(2).getManager().getTodos().get(0).isComplete());
    }

    @Test
    public void swap() {
        Todo t = localManager.getTodoList(2).getManager().getTodos().get(0);
        assertEquals(211, t.getSteps().get(0).getStepId());
        assertEquals(212, t.getSteps().get(1).getStepId());
        ArrayList<Step> steplist = t.getSteps();
        t.swap(steplist,0, 1);
        assertEquals(212, t.getSteps().get(0).getStepId());
        assertEquals(211, t.getSteps().get(1).getStepId());
    }
}