package com.axis.parkingappbooking.model

import org.bson.types.ObjectId
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference

@Document(collection = "parking")
data class Parking(
        @Id
        var _id:ObjectId?=null,
        var name:String,
        var address:String,
        var country:String,
        var state:String,
        var city:String,
        var price:Float,
        var totalslots:Int,
        var availableslots:Int,
        @DocumentReference
        var user: User?
)