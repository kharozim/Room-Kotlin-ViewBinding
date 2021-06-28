package id.sekdes.room_kotlin_example

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import id.sekdes.room_kotlin_example.model.UserModel

@Dao
interface UserDao {

    @Query("SELECT*FROM users")
    fun getAllUser(): List<UserModel>

    @Insert
    fun insert(user: UserModel): UserModel

    fun update(id: Int): UserModel
}