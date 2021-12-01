package com.axis.parkingappbooking.dao

import com.axis.parkingappbooking.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

interface IUserDAO :MongoRepository<User,String>{
}
