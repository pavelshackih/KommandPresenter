package org.simplepresenter.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import org.simplepresenter.PresenterFragment
import org.simplepresenter.R
import org.simplepresenter.ViewCommand
import org.simplepresenter.commands.ProgressViewCommand
import org.simplepresenter.commands.SimpleDataViewCommand

class SampleFragment : PresenterFragment<SamplePresenter>() {

    override fun createPresenter(): SamplePresenter = SamplePresenter()

    override fun dispatchCommand(command: ViewCommand) {
        when (command) {
            is ProgressViewCommand -> textView?.text = "Loading..."
            is SimpleDataViewCommand -> textView?.text = command.data
        }
    }

    var textView: TextView? = null
    var button: Button? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.sample_fragment, container, false)
        textView = view?.findViewById(R.id.text) as TextView
        button = view?.findViewById(R.id.button) as Button
        button?.setOnClickListener({ presenter.onItemClick() })
        return view
    }
}