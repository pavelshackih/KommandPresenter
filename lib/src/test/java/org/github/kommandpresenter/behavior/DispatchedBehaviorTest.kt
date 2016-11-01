package org.github.kommandpresenter.behavior

import org.github.kommandpresenter.TestViewDelegate
import org.github.kommandpresenter.commands.DispatchedViewCommand
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DispatchedBehaviorTest : AbstractBehaviorTest() {

    @Test
    fun dispatchedCommandShouldHaveFlagTest() {
        val command = TestDispatchedCommand(false)
        presenter.applyCommand(command)
        assertFalse(command.isDispatched)
        val viewDelegate = TestViewDelegate()
        presenter.bind(viewDelegate)
        presenter.onRestoreView()
        assertTrue(command.isDispatched)
    }

    class TestDispatchedCommand(override var isDispatched: Boolean) : DispatchedViewCommand
}