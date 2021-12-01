package com.axis.parkingappbooking.dao

import com.axis.parkingappbooking.model.Parking
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

interface IParkingDAO :MongoRepository<Parking,String> {
    override fun existsById(_id: String): Boolean
}