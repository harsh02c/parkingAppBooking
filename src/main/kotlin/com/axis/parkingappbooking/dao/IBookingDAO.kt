package com.axis.parkingappbooking.dao

import com.axis.parkingappbooking.model.Booking
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface IBookingDAO : MongoRepository<Booking, String> {
}