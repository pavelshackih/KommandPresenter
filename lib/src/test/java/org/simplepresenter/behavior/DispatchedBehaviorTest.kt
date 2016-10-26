package org.simplepresenter.behavior

import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test
import org.simplepresenter.TestViewDelegate

import org.simplepresenter.commands.DispatchedViewCommand

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