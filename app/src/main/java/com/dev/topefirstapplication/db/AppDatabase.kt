package com.dev.topefirstapplication.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dev.topefirstapplication.db.converter.Converter
import com.dev.topefirstapplication.ui.dashboard.ProductModel

@Database(entities = [ProductModel::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    private val mIsDatabaseCreated = MutableLiveData<Boolean>()
    private fun updateDatabaseCreated(context: Context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated()
        }
    }

    private val databaseCreated: LiveData<Boolean>
        private get() = mIsDatabaseCreated

    private fun setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true)
    }

    companion object {
        private val LOG_TAG = AppDatabase::class.java.simpleName
        private val LOCK = Any()
        private const val DATABASE_NAME = "inventory_management"
        private var mInstance: AppDatabase? = null


        fun getInstance(context: Context): AppDatabase? {
            if (mInstance == null) {
                synchronized(LOCK) {
                    mInstance = buildDatabase(context.applicationContext)
                    mInstance!!.updateDatabaseCreated(context)
                }
            }
            return mInstance
        }

        private fun buildDatabase(appContext: Context): AppDatabase {
            return Room.databaseBuilder(appContext, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}