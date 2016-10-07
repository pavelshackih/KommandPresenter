package org.simplepresenter

import org.simplepresenter.behavior.CommandBehaviorFactory
import org.simplepresenter.behavior.DefaultBehaviorFactory

class DefaultCommandEngine : CommandEngine {

    override val behaviorFactory: CommandBehaviorFactory
        get() = DefaultBehaviorFactory()

    override val presentersStore: PresentersStore
        get() = DefaultPresentersStore()
}