package edu.moh.database4a17


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.tsmem.view.*
import mydatabase

class cuostom(context: Context, private var objects: ArrayList<Array<String>>) : ArrayAdapter<Array<String>>(context, R.layout.tsmem, objects) {
    lateinit var mydb: mydatabase
    lateinit var p:Product

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var l:LayoutInflater=LayoutInflater.from(context)
        var custom:View=l.inflate(R.layout.tsmem,parent,false)
        custom.textViewtsmem3.text= "ID:${objects[position][0]}"
        custom.textViewtsmem2.text="name:${objects[position][1]}"
        custom.textViewtsmem.text="Q:${objects[position][2]}"

        custom.imageViewtsmem.setOnClickListener {
            mydb=mydatabase(context)
            var x=objects[position][1]
            p=Product(x)
            mydb.deletproduct(p)
            objects.removeAt(position)
            notifyDataSetChanged()
            //if (context is MainActivity2) {
              //  (context as MainActivity2).printData()
           // }
        }

        return custom
    }

}