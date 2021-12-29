package com.axis.parkingappbooking.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

@Document(collection="booking")
data class Booking(
        @Id
//        var _id:Int,
        var _id:ObjectId?=null,
        @DocumentReference
        var user:User,
        @DocumentReference
        var parking:Parking,
        @JsonFormat(pattern="yyyy-MM-dd H:i:s")
        var bookingStartTime:String,
        @JsonFormat(pattern="yyyy-MM-dd H:i:s")
        var bookingEndTime:String
)