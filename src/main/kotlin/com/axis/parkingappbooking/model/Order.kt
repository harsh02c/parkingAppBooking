package com.axis.parkingappbooking.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference

@Document(collection="order")
data class Order (
        @Id
        var _id: ObjectId?=null,
        var amount:String,
        var currency:String,
        var receipt:String,
//        @DocumentReference
//        var parking:Parking,
//        @DocumentReference
//        var user:User,

//        var notes:String,
//        var created_at:String,
//        var amount_due:String,
//        var currency:String,
//        var receipt:String,
//        var id:String,
//        var entity:String,
//        var offer_id:String,
//        var status:String,
//        var attempts:String


)