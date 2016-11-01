package org.github.kommandpresenter

import java.lang.reflect.Method
import java.util.*

object ReflectionViewDispatcher : ViewDispatcher {

    private val map = HashMap<MapKey, List<Method>>()

    override fun dispatchCommand(view: Any, command: ViewCommand) {
        val methods = map.getOrPut(MapKey(view.javaClass, command.javaClass), {
            findMethods(view.javaClass, command.javaClass)
        })
        if (methods.isEmpty()) {
            throw IllegalArgumentException()
        }
        methods.forEach { it.invoke(view, command) }
    }

    private data class MapKey(val view: Class<*>, val command: Class<*>)

    private fun findMethods(view: Class<*>, command: Class<*>): List<Method> {
        return view.methods.filter { it.parameterTypes.size == 1 && it.parameterTypes[0] == command }
    }
}