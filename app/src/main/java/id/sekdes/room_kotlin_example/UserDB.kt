package id.sekdes.room_kotlin_example

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.sekdes.room_kotlin_example.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: UserDB? = null
        fun getInstance(context: Context): UserDB? {
            if (INSTANCE == null) {
                synchronized(UserDB::class) {
                    INSTANCE = Room
                        .databaseBuilder(context.applicationContext, UserDB::class.java, "user.db")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}