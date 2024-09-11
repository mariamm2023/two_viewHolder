package com.example.twoviewholder

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.twoviewholder.databinding.ItemLayoutOneBinding
import com.example.twoviewholder.databinding.ItemLayoutTwoBinding

class UserAdapter( val onItemDeleted:(Pair<UseData,Int>)->Unit):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var userlist:MutableList<UseData> = mutableListOf()
    fun setuserdata(list:List<UseData>){
        userlist.clear()
        userlist.addAll(list)

    }
    companion object{
        private const val typeone=1
        private const val typetwo=2

    }
    inner class viewHolderone(val binding: ItemLayoutOneBinding):RecyclerView.ViewHolder(binding.root){
        fun binddata(useData: UseData){
            binding.user=useData
            binding.delete.setOnClickListener {
                onItemDeleted(Pair(useData,adapterPosition))

            }
        }

    }
    inner class viewHoldertwo(val binding: ItemLayoutTwoBinding):RecyclerView.ViewHolder(binding.root){
        fun binddata(useData: UseData){
            binding.user=useData
            binding.delete.setOnClickListener {
                onItemDeleted(Pair(useData,adapterPosition))

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            typeone->{
                val binding=ItemLayoutOneBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return viewHolderone(binding)
            }
            typetwo->{
                val binding=ItemLayoutTwoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return viewHoldertwo(binding)
            }
            else->{
                throw IllegalAccessError("invalidtype")
            }
        }



    }

    override fun getItemCount()=userlist.size



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
          typeone->(holder as viewHolderone).binddata(userlist[position])
            typetwo->(holder as viewHoldertwo).binddata(userlist[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(userlist[position].type){
            1-> typeone
            2-> typetwo
            else-> typeone
        }

    }
}