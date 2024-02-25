package com.example.mvc_pattern

import controller.UserController
import com.example.mvc_pattern.model.User
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class UserControllerTest {

    private lateinit var userController: UserController
    private lateinit var user: User

    @Before
    fun setUp() {
        // Initialize a User object and UserController before each test
        user = User(userId = "initial_id")
        userController = UserController(user)
    }

    @Test
    fun getUserId_returnsCorrectId() {
        // Check if getUserId returns the correct userId
        val userId = userController.getUserId()
        assertEquals("initial_id", userId)
    }

    @Test
    fun setUserId_setsCorrectId() {
        // Set a new userId and check if getUserId reflects the change
        val newUserId = "new_id"
        userController.setUserId(newUserId)
        assertEquals(newUserId, userController.getUserId())
    }

    // Add more tests if there are more functionalities to test
}
