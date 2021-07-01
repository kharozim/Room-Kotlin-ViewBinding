package id.sekdes.room_kotlin_example

import androidx.room.*
import id.sekdes.room_kotlin_example.model.UserModel

@Dao
interface UserDao {
    @Query("SELECT*FROM users")
    fun getAllUser(): List<UserModel>
    @Insert
    fun insert(user: UserModel): UserModel
    @Update
    fun update(id: Int): UserModel
    @Delete
    fun delete(id: Int) : UserModel
}