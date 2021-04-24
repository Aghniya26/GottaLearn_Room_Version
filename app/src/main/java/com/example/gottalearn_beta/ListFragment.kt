package com.example.gottalearn_beta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.activityViewModels
import java.util.Observer

class ListFragment : Fragment() {





    private val assignmentViewModel: AssignmentViewModel by activityViewModels() {
        AssignmentViewModelFactory((activity?.application as AssignmentsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.fragment_list, container, false)



        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView : RecyclerView =view.findViewById(R.id.recycle_view)
        val adapter=ExampleAdapter()
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(activity)

        assignmentViewModel.allAssignment.observe(viewLifecycleOwner){ assignments->
            assignments.let { adapter.submitList(it) }
        }
    }



}
