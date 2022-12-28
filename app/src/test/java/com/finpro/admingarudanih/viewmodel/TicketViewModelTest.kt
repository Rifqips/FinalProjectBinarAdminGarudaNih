package com.finpro.admingarudanih.viewmodel

import com.finpro.admingarudanih.model.tickets.ResponseLocalTicket
import com.finpro.admingarudanih.network.ApiInterface
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import retrofit2.Call

class TicketViewModelTest {
    lateinit var test : ApiInterface
    @Before
    fun setUp(){
        test = mockk()
    }

    @Test
    fun callTicketIntr() {
        val getlisttiketinter = mockk<Call<ResponseLocalTicket>>()

        every {
            runBlocking {
                test.getIntrTicket()
            }
        } returns getlisttiketinter

        val result =test.getIntrTicket()

        verify {
            runBlocking { test.getIntrTicket() }
        }
        assertEquals(result, getlisttiketinter)
    }

    @Test
    fun callTicketLocal() {
        val getlisttiketlocal = mockk<Call<ResponseLocalTicket>>()

        every {
            runBlocking {
                test.getLocalTicket()
            }
        } returns getlisttiketlocal

        val result =test.getLocalTicket()

        verify {
            runBlocking { test.getLocalTicket() }
        }
        assertEquals(result, getlisttiketlocal)
    }
}