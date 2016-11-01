package org.github.kommandpresenter

import org.junit.Test
import org.github.kommandpresenter.ReflectionViewDispatcher
import org.github.kommandpresenter.commands.ProgressViewCommand
import org.mockito.Mockito.*

class ReflectionViewDispatcherTest {

    @Test
    fun dispatchCommand() {
        val view = mock(SampleView::class.java)
        ReflectionViewDispatcher.dispatchCommand(view, ProgressViewCommand)
        verify(view, times(1)).dispatch(ProgressViewCommand)
    }

    open class SampleView {

        open fun dispatch(command: ProgressViewCommand) {
            println(command)
        }
    }
}