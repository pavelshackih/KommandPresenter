package org.simplepresenter.sample

import android.os.SystemClock
import org.simplepresenter.Presenter
import org.simplepresenter.commands.ProgressViewCommand
import org.simplepresenter.commands.SimpleDataViewCommand

class SamplePresenter : Presenter() {

    fun onItemClick() {
        applyViewState(ProgressViewCommand)
        Thread({
            SystemClock.sleep(5000)
            applyViewState(SimpleDataViewCommand("done from presenter!"))
        }).start()
    }
}