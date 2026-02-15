package edu.moh.database4a17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main2.*
import mydatabase

class MainActivity2 : AppCompatActivity() {
    lateinit var mydatabase: mydatabase
    lateinit var p:Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mydatabase=mydatabase(this)
        printData()
    }

   fun sarshe(view: View){
        val name= sarsheeee.text.toString()
        p=Product(name)
        if (sarsheeee.text.isEmpty() ){
            Toast.makeText(this,"يرجى ادخال اسم منتج بطريقة صحيحة",Toast.LENGTH_SHORT).show()
        }else{
            var p0String=mydatabase.sarshe(p)
                val adapter = cuostom(this,p0String)
                listview.adapter=adapter
        }
            }
    fun printData(){
        val p0String=mydatabase.databaseToString()
        val adapter = cuostom(this,p0String)
        listview.adapter=adapter
    }

}