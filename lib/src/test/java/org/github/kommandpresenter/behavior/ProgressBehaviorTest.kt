package org.github.kommandpresenter.behavior

import org.github.kommandpresenter.applyCommands
import org.junit.Assert.assertEquals
import org.junit.Test
import org.github.kommandpresenter.behavior.AbstractBehaviorTest
import org.github.kommandpresenter.commands.ProgressViewCommand
import org.github.kommandpresenter.commands.StringDataViewCommand

class ProgressBehaviorTest : AbstractBehaviorTest() {

    @Test
    fun stackShouldBeWithProgressCommandOnTopTest() {
        val expected = listOf(
                StringDataViewCommand("test1"),
                StringDataViewCommand("test2"),
                ProgressViewCommand)

        presenter.applyCommands(
                StringDataViewCommand("test1"),
                ProgressViewCommand,
                StringDataViewCommand("test2"),
                ProgressViewCommand)

        val actual = presenter.commands

        assertEquals(expected, actual)
    }

    @Test
    fun stackShouldBeWithoutProgressCommandTest() {
        val expected = listOf(
                StringDataViewCommand("test1"),
                StringDataViewCommand("test2"),
                StringDataViewCommand("test3"))

        presenter.applyCommands(
                StringDataViewCommand("test1"),
                ProgressViewCommand,
                StringDataViewCommand("test2"),
                ProgressViewCommand,
                StringDataViewCommand("test3"))

        val actual = presenter.commands

        assertEquals(expected, actual)
    }
}