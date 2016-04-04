package org.simplepresenter

import org.junit.Assert.assertEquals
import org.junit.Test
import org.simplepresenter.commands.OneTimeViewCommand
import org.simplepresenter.commands.ProgressViewCommand
import org.simplepresenter.commands.SimpleDataViewCommand
import java.util.*

class PresenterTest {

    var presenter: TargetPresenter? = null

    @Test
    fun testOnCommandAdd() {
        presenter = TargetPresenter()
        val input = LinkedList<ViewCommand>()
        val expected = LinkedList<ViewCommand>()
        input.add(SimpleDataViewCommand("test1"))
        expected.add(SimpleDataViewCommand("test1"))
        input.add(ProgressViewCommand)
        input.add(SimpleDataViewCommand("test2"))
        expected.add(SimpleDataViewCommand("test2"))
        input.add(ProgressViewCommand)
        input.add(SimpleDataViewCommand("test3"))
        expected.add(SimpleDataViewCommand("test3"))
        expected.add(ProgressViewCommand)
        val actual = presenter?.onNewCommand(ProgressViewCommand, input)
        assertEquals(expected, actual)
    }

    @Test
    fun testOneTimeCommand() {
        val view = TargetView()
        view.presenter.applyViewState(SimpleDataViewCommand("test1"))
        assertEquals(1, view.presenter.commands.size)
        view.presenter.applyViewState(OneTimeCommand())
        assertEquals(1, view.presenter.commands.size)
    }

    class OneTimeCommand : OneTimeViewCommand
}