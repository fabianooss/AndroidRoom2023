package com.example.aularoomdatabase2023.repository

import androidx.lifecycle.MutableLiveData
import com.example.aularoomdatabase2023.dao.UserDao
import com.example.aularoomdatabase2023.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val userDao: UserDao) {


    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun addUser(user: User) {
        coroutine.launch(Dispatchers.IO) {
            userDao.insert(user)
        }
    }

    fun delete(user: User) {
        coroutine.launch(Dispatchers.IO) {
            userDao.delete(user)
        }
    }

    suspend fun loadAllUsers(): List<User> {
        return userDao.getAll()
    }
}