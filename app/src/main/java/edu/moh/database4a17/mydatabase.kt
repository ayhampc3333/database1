import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import edu.moh.database4a17.Product

lateinit var product:Product
class mydatabase(context: Context) : SQLiteOpenHelper(context, mydatabase.DATABASE_NAME, null , mydatabase.DATABASE_VERSION) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(DATABASE_CREATE)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $DATEBASE_TABLE_NAME")
        onCreate(p0)
    }

    companion object{
        val KEY_ID = "ID"
        val P_NAME = "NAME"
        val P_QUANTITY = "QUANTITY"
        val DATEBASE_TABLE_NAME = "products"

        private val DATABASE_NAME = "data.db"
        private val DATABASE_VERSION = 2

        private val DATABASE_CREATE = "CREATE TABLE $DATEBASE_TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY ," + "$P_NAME TEXT NOT NULL," + "$P_QUANTITY INTEGER);"
    }

    fun addproduct(product:Product){
        val p0=this.writableDatabase
        val values = ContentValues()
        values.put(P_NAME,product.name)

        values.put(P_QUANTITY,product.q)

        p0.insert(DATEBASE_TABLE_NAME,null, values)
        p0.close()

    }

    fun deletproduct(product: Product)/*:Boolean*/ {
        val p0=writableDatabase
        p0.execSQL("delete from $DATEBASE_TABLE_NAME where $P_NAME=\"${product.name}\";")

    }
   fun sarshe(product: Product):ArrayList<Array<String>>{
       val p0String = ArrayList<Array<String>>()
       val p0=writableDatabase
       var query = "select * from $DATEBASE_TABLE_NAME where $P_NAME=\"${product.name}\";"
       val c=p0.rawQuery(query,null)

       while (c.moveToNext()) {
           val id = c.getString(c.getColumnIndex(KEY_ID))
           val name = c.getString(c.getColumnIndex(P_NAME))
           val quantity = c.getString(c.getColumnIndex(P_QUANTITY))
           val row = arrayOf(id, name, quantity)
           p0String.add(row)
       }
       c.close()
       return p0String
   }

    fun databaseToString(): ArrayList<Array<String>>{
        val p0String = ArrayList<Array<String>>()
        val p0=writableDatabase
        var query = "select * from $DATEBASE_TABLE_NAME where 1"
        val c=p0.rawQuery(query,null)
        while (c.moveToNext()) {
            val id = c.getString(c.getColumnIndex(KEY_ID))
            val name = c.getString(c.getColumnIndex(P_NAME))
            val quantity = c.getString(c.getColumnIndex(P_QUANTITY))
            val row = arrayOf(id, name, quantity)
            p0String.add(row)
        }
        c.close()
        return p0String
    }


}


