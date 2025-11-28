// MainActivity.kt
package com.translateall.language.free.translator.dictionary.speechtext.learnenglish

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class MainActivity22 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "ars-db2"
        ).allowMainThreadQueries().build()

        // Insert static data
        val dao = db.daoArs()
//        dao.insert(DataArslan(id = 0))
//        dao.insert(DataArslan(id = 0))
        dao.insert(DataArslan(name = "Arslan"))
        dao.insert(DataArslan(name = "Ali"))

        val repository = Repository(dao)
        val viewModel = ViewModelProvider(this, ArslanViewModelFactory(repository))
            .get(ArslanViewModel::class.java)

        viewModel.allData.observe(this) { list ->
            list.forEach {
                Log.d("MainActivity", "ID: ${it.id}")
            }
        }
    }
}
