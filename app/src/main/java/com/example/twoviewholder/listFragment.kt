package com.example.twoviewholder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.twoviewholder.databinding.FragmentListBinding

class listFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    val userdata:MutableList<UseData> = mutableListOf()
    lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        additems()
        binding=FragmentListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myList.layoutManager=LinearLayoutManager(requireContext())
        userAdapter= UserAdapter(){
            userdata.remove(it.first)
            userAdapter.setuserdata(userdata)
            userAdapter.notifyDataSetChanged()
        }
        userAdapter.setuserdata(userdata)
        binding.myList.adapter=userAdapter
        userAdapter.notifyDataSetChanged()

    }
    fun additems(){
        userdata.add(UseData(1,1,"omar","omar5252","5555"))
        userdata.add(UseData(2,2,"yassin","yassin5252","5555"))
        userdata.add(UseData(3,1,"mariam","mohamed5252","5555"))
        userdata.add(UseData(4,2,"mohamed","mohamed5252","5555"))
        userdata.add(UseData(5,1,"omar","omar5252","5555"))
        userdata.add(UseData(6,2,"yassin","yassin5252","5555"))
        userdata.add(UseData(7,1,"mariam","mariam5252","5555"))
        userdata.add(UseData(8,2,"mohamed","mohamed5252","5555"))
    }
}