package org.simplepresenter

import org.junit.Test
import org.mockito.Mockito.*
import org.simplepresenter.commands.ProgressViewCommand

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