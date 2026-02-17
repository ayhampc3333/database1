package edu.moh.database4a17


import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
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
        mydb=mydatabase(context)
        var x:String?
        custom.imageViewtsmem.setOnClickListener {
             x=objects[position][1]
            p=Product(x)
            mydb.deletproduct(p)
            objects.removeAt(position)
            notifyDataSetChanged()
        }
        custom.Detailsimage.setOnClickListener {
            val bulider=AlertDialog.Builder(context)
            bulider.setTitle("تفاصيل عن المنتج")
            bulider.setMessage("ID:${objects[position][0]} \n \n name:${objects[position][1]} \n \n Q:${objects[position][2]}")
            bulider.setPositiveButton("موافق"){_:DialogInterface,_:Int ->

            }
            val dialog=bulider.create()
            dialog.show()
        }
        x=objects[position][1]
        var productsimage= mapOf("اكمول" to R.drawable.acamol ,"بنادول" to R.drawable.panadol )
        var imge=productsimage[x]?: R.drawable.nophoto
            custom.imageView.setImageResource(imge)



        return custom
    }

}