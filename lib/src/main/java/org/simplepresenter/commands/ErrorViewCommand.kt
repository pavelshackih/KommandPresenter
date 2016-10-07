package org.simplepresenter.commands

data class ErrorViewCommand(val throwable: Throwable) : SingleTopViewCommand
