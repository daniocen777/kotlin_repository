package com.danicode.basic.todo

/**
 * Las clases selladas (sealed) se utilizan para representar una jerarquía de clases
 * que heredan de una clase padre
 * */
sealed class TaskCategory(var isSelected: Boolean = true) {
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other : TaskCategory()
}