package org.github.kommandpresenter

import org.github.kommandpresenter.behavior.CommandBehaviorFactory
import org.github.kommandpresenter.behavior.DefaultBehaviorFactory

class DefaultCommandEngine : CommandEngine {

    override val behaviorFactory: CommandBehaviorFactory = DefaultBehaviorFactory()

    override val presentersStore: PresentersStore = DefaultPresentersStore()

    override val viewDispatcher: ViewDispatcher = ReflectionViewDispatcher

    override val isDebug: Boolean = true
}