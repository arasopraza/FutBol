package com.smk.futbol

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_match.*

class MatchFragment : Fragment() {
//    private var items: MutableList<League> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        match_list?.setHasFixedSize(true)
//        initData()
//        showRecyclerView()
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(index: Int): MatchFragment {
            val fragment = MatchFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_SECTION_NUMBER, index)
            fragment.arguments = bundle
            return fragment
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var index = 1
        if (getArguments() != null) {
            index = arguments?.getInt(ARG_SECTION_NUMBER, 0) as Int
        }
        match.text = "${getString(R.string.hello_blank_fragment)} $index"
    }
//
//    private fun initData() {
//        val name = resources.getStringArray(R.array.match_name)
//        val image = resources.obtainTypedArray(R.array.match_image)
//        items.clear()
//        for (i in name.indices) {
//            items.add(
//                League(
//                    name[i],
//                    image.getResourceId(i, 0)
//                )
//            )
//        }
//        // Recycle the typed array
//        image.recycle()
//    }

//    private fun showRecyclerView() {
//        match_list?.layoutManager = LinearLayoutManager(context)
//        match_list?.adapter = MatchAdapter(items)
//    }
}

