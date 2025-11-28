package com.translateall.language.free.translator.dictionary.speechtext.learnenglish

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
//dao
import androidx.room.Query
//viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData

//db
import androidx.room.Database
import androidx.room.Insert
import androidx.room.RoomDatabase

@Entity(tableName = "arstbl")
data class DataArslan (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name : String
)

@Dao
interface DaoArs {
    @Query("SELECT * FROM arstbl")
    fun getData(): List<DataArslan>

    @Insert
    fun insert(data: DataArslan)
}

class ArslanViewModel(private val repository: Repository) : ViewModel() {
    val allData = liveData {
        val data = repository.getData()
        emit(data)
    }
}

// Repository.kt
class Repository(private val dao: DaoArs) {
    fun getData() = dao.getData()
}

@Database(entities = [DataArslan::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daoArs(): DaoArs
}