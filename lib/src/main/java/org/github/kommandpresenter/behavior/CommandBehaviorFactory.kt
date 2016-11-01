package org.github.kommandpresenter.behavior

import org.github.kommandpresenter.behavior.CommandBehavior

interface CommandBehaviorFactory {

    val behaviors: List<CommandBehavior>
}