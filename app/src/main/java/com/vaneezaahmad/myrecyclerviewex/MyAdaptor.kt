package com.vaneezaahmad.myrecyclerviewex

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView

//context means call from where, the reference of the activity
class MyAdaptor(list: ArrayList<Model>, c: Context) : RecyclerView.Adapter<MyAdaptor.MyViewHolder>() {
    var list : ArrayList<Model> = list;
    var context: Context = c;
    class MyViewHolder: RecyclerView.ViewHolder {
        constructor(itemView: View) : super(itemView)
        var name: TextView = itemView.findViewById<TextView>(R.id.name)
        var phone: TextView = itemView.findViewById<TextView>(R.id.phone)
        var email: TextView = itemView.findViewById<TextView>(R.id.email)
        var row = itemView.findViewById<LinearLayout>(R.id.row);


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.row, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = list .get(position).name
        holder.phone.text= list.get(position).phone
        holder.email.text= list.get(position).email
        holder.row.setOnClickListener {
            var Intent = Intent(context, ViewContact::class.java)
            Intent.putExtra("name", list.get(position).name)
            Intent.putExtra("number", list.get(position).phone)
            Intent.putExtra("email", list.get(position).email)
            //list.add(Model(name!!, number!!, email!!))
            context.startActivity(Intent);
        }
        holder.row.setOnLongClickListener{
            val removedItem = list.removeAt(position)

            // Notify the adapter that an item has been removed
            notifyItemRemoved(position)

            // Show a toast message
            Toast.makeText(context, "${removedItem.name} deleted", Toast.LENGTH_SHORT).show()

            true // Return true to
        }

    }

    fun updateList(arrayList: ArrayList<Model>) {
        list.clear()
        list.addAll(arrayList)
        notifyDataSetChanged()

    }


}
