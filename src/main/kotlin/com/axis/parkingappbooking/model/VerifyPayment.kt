package com.axis.parkingappbooking.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "verify_payment")
data class VerifyPayment (
        @Id
        var _id: ObjectId?=null,
        var razorpay_order_id:String,
        var razorpay_payment_id:String,
        var razorpay_signature:String,

)