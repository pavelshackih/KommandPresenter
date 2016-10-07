package org.simplepresenter

import org.simplepresenter.behavior.CommandBehaviorFactory

interface CommandEngine {

    val presentersStore: PresentersStore

    val behaviorFactory: CommandBehaviorFactory

    object Bridge {

        private var engine: CommandEngine? = DefaultCommandEngine()

        @Suppress("unused")
        fun register(engine: CommandEngine) {
            this.engine = engine
        }

        internal fun getCurrentEngine(): CommandEngine {
            if (this.engine == null) {
                throw IllegalStateException("Please register current command engine using org.simplepresenter.CommandEngine.Bridge.register(engine) call.")
            }
            val tmp = engine as CommandEngine
            return tmp
        }
    }
}