package com.example.hrybkov_l9

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class TaskFragment : Fragment(R.layout.fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.operationResult)
        textView?.text = arguments?.getInt(someKey).toString()
    }

    companion object {
        val someKey = "12231"

        fun fragmentInstance(valueIntent: Int): TaskFragment {
            val fragment = TaskFragment()
            val bundle = Bundle()

            bundle.putInt(someKey, valueIntent)
            fragment.arguments = bundle

            return fragment
        }
    }
}