package org.simplepresenter

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.simplepresenter.commands.OneTimeViewCommand
import org.simplepresenter.commands.ProgressViewCommand
import org.simplepresenter.commands.StringDataViewCommand
import java.util.*

class PresenterTest {

    private lateinit var presenter: TargetPresenter

    @Before
    fun setUp() {
        presenter = TargetPresenter()
    }

    @Test
    fun testProgressCommand1() {
        val expected = listOf(
                StringDataViewCommand("test1"),
                StringDataViewCommand("test2"),
                ProgressViewCommand)

        presenter.applyCommand(StringDataViewCommand("test1"))
        presenter.applyCommand(ProgressViewCommand)
        presenter.applyCommand(StringDataViewCommand("test2"))
        presenter.applyCommand(ProgressViewCommand)

        assertEquals(expected, presenter.commands)
    }

    @Test
    fun testProgressCommand2() {
        val expected = LinkedList<ViewCommand>()
        expected.add(StringDataViewCommand("test1"))
        expected.add(StringDataViewCommand("test2"))
        expected.add(StringDataViewCommand("test3"))

        presenter.applyCommand(StringDataViewCommand("test1"))
        presenter.applyCommand(ProgressViewCommand)
        presenter.applyCommand(StringDataViewCommand("test2"))
        presenter.applyCommand(ProgressViewCommand)
        presenter.applyCommand(StringDataViewCommand("test3"))

        assertEquals(expected, presenter.commands)
    }

    @Test
    fun testOneTimeCommand() {
        val expected = LinkedList<ViewCommand>()
        expected.add(StringDataViewCommand("test1"))
        expected.add(OneTimeCommand)

        val view = TargetView()
        view.setResumed(false)
        view.presenter.applyCommand(StringDataViewCommand("test1"))
        view.presenter.applyCommand(OneTimeCommand)
        assertEquals(expected, view.presenter.commands)
        view.setResumed(true)
        view.presenter.onRestoreView()
        expected.removeAt(1)
        assertEquals(expected, view.presenter.commands)
    }

    private object OneTimeCommand : OneTimeViewCommand
}
