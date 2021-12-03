package com.axis.parkingappbooking.service

import com.axis.parkingappbooking.model.Booking
import com.axis.parkingappbooking.model.Order
import java.util.*

interface IBookingService {
    fun addBooking(booking: Booking): Any?
    fun getAllBooking(): MutableList<Booking?>
    fun addOrder(order: Order): Any?
    fun getBookingById(Id: String): Optional<Booking?>

}