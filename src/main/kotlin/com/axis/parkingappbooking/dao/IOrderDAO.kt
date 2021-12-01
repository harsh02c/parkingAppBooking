package com.axis.parkingappbooking.dao

import com.axis.parkingappbooking.model.Order
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

interface IOrderDAO :MongoRepository<Order,String>{
}
