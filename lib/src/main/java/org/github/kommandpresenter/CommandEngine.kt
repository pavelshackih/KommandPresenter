package org.github.kommandpresenter

import org.github.kommandpresenter.behavior.CommandBehaviorFactory

interface CommandEngine {

    val presentersStore: PresentersStore

    val behaviorFactory: CommandBehaviorFactory

    val viewDispatcher: ViewDispatcher

    val isDebug: Boolean

    object Bridge {

        private var engine: CommandEngine? = DefaultCommandEngine()

        @Suppress("unused")
        fun register(engine: CommandEngine) {
            this.engine = engine
        }

        internal val currentEngine: CommandEngine
            get() {
                if (this.engine == null) {
                    throw IllegalStateException("Please register current command engine using org.github.kommandpresenter.CommandEngine.Bridge.register(engine) call.")
                }
                val tmp = engine as CommandEngine
                return tmp
            }
    }
}