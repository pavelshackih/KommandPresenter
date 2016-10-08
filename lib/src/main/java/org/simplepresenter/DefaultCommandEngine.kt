package org.simplepresenter

import org.simplepresenter.behavior.CommandBehaviorFactory
import org.simplepresenter.behavior.DefaultBehaviorFactory

class DefaultCommandEngine : CommandEngine {

    override val behaviorFactory: CommandBehaviorFactory = DefaultBehaviorFactory()

    override val presentersStore: PresentersStore = DefaultPresentersStore()

    override val viewDispatcher: ViewDispatcher = ReflectionViewDispatcher
}