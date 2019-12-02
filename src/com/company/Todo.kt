package com.company

import java.util.ArrayList

class Todo(internal var taskId: Int, internal var taskName: String, var steps: ArrayList<Step>, var location: String) : Task {

    val isComplete: Boolean
        get() {
            for (i in steps.indices) {
                if (!steps[i].isStepComplete) {
                    return false
                }
            }
            return true
        }

    fun swapSteps(id1: Int, id2: Int) = steps.swap(id1, id2)


    override fun getTaskId(): Int {
        return taskId
    }

    override fun getTaskName(): String {
        return taskName
    }

    override fun setTaskId(taskId: Int) {
        this.taskId = taskId
    }

    override fun setTaskName(taskName: String) {
        this.taskName = taskName
    }

    fun <T> ArrayList<T>.swap(i: Int, j: Int) {
        // “this” is the list of steps
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }


}
