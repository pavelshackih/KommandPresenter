package org.github.kommandpresenter.commands

data class ErrorViewCommand(val throwable: Throwable) : SingleTopViewCommand
