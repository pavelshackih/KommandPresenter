package org.github.kommandpresenter.behavior

import org.github.kommandpresenter.TestPresenter
import org.junit.Before

abstract class AbstractBehaviorTest {

    lateinit var presenter: TestPresenter

    @Before
    fun setUp() {
        presenter = TestPresenter()
    }
}