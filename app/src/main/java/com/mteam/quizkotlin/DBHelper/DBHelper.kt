package com.mteam.quizkotlin.DBHelper

import android.content.Context
import com.mteam.quizkotlin.model.Category
import com.mteam.quizkotlin.model.Question
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class DBHelper(context: Context) : SQLiteAssetHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        private var instance: DBHelper? = null
        private val DB_NAME = "";
        private val DB_VERSION = 1
        @Synchronized
        fun getInstance(context: Context): DBHelper {
            if (instance == null) {
                instance = DBHelper(context);
            }
            return instance!!;
        }
    }

    val allCategories: MutableList<Category>
        get() {
            val db = instance!!.writableDatabase
            val categories = ArrayList<Category>()
            val cusor = db.rawQuery("SELECT * FROM Category", null);
            while (cusor.moveToNext()) {

                val category = Category(
                    cusor.getInt(cusor.getColumnIndex("ID")),
                    cusor.getString(cusor.getColumnIndex("Name")),
                    cusor.getString(cusor.getColumnIndex("Image"))
                )
                categories.add(category)
            }
            cusor.close()
            db.close()
            return categories
        }

    val getQuestion: MutableList<Question>
        get() {
            val db = instance!!.writableDatabase
            val categories = ArrayList<Question>()
            val cusor = db.rawQuery("SELECT * FROM Category", null);
            while (cusor.moveToNext()) {

                val category = Category(
                    cusor.getInt(cusor.getColumnIndex("ID")),
                    cusor.getString(cusor.getColumnIndex("Name")),
                    cusor.getString(cusor.getColumnIndex("Image"))
                )
               // categories.add(category)
            }
            cusor.close()
            db.close()
            return categories
        }
}