package com.example.login

import com.example.login.screens.login.TestLoginScreenViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class TestLoginScreenViewModelTest {

    @RelaxedMockK
    private lateinit var testSample: TestLoginScreenViewModel

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
    }

    @Test
    fun validateLogin_faildEmail_ReturnsFalse(){
        assertEquals(false, testSample.validateLogin("test_totext"))
    }
}