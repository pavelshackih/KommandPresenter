package org.simplepresenter.behavior

import org.junit.Before
import org.simplepresenter.TestPresenter

abstract class AbstractBehaviorTest {

    lateinit var presenter: TestPresenter

    @Before
    fun setUp() {
        presenter = TestPresenter()
    }
}