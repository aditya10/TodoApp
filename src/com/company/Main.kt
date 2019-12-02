package com.company

import org.json.simple.JSONArray
import org.json.simple.parser.JSONParser
import org.json.simple.parser.ParseException

import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val masterManager = parseTasks()
        try {
            masterManager!!.printTasks()
        } catch (e: Exception) {
            print(e.stackTrace)
        }

    }

    @JvmStatic
    fun parseTasks(): TodoListManager? {

        //JSON parser object to parse read file
        val jsonParser = JSONParser()

        // use FileReader("./tasks_with_null.json") to see how NullPointer is not thrown in Kotlin
        try {
            FileReader("./tasks.json").use { reader ->
                //Read JSON file
                val obj = jsonParser.parse(reader)
                val jsonTodoLists = obj as JSONArray

                return TodoListManager(jsonTodoLists)

            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return null
    }

    fun printTodoLocation(obj: Any) {
        if (obj is Todo) {
            println(obj.location)
        }
    }
}
