package org.github.kommandpresenter.commands

import org.github.kommandpresenter.commands.SingleTopViewCommand

data class ErrorViewCommand(val throwable: Throwable) : SingleTopViewCommand
