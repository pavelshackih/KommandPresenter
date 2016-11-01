package org.github.kommandpresenter

import org.github.kommandpresenter.commands.ProgressViewCommand
import org.junit.Test
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