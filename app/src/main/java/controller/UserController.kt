package controller

import com.example.mvc_pattern.model.User

class UserController(private val user: User) {

    fun getUserId(): String = user.userId

    fun setUserId(userId: String) {
        user.userId = userId
    }

    // Additional methods related to user management
}
