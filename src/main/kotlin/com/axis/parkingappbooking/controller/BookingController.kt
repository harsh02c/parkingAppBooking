package com.axis.parkingappbooking.controller

//import com.razorpay.Order
import com.axis.parkingappbooking.model.Booking
import com.axis.parkingappbooking.model.Order
import com.axis.parkingappbooking.model.VerifyPayment
import com.axis.parkingappbooking.service.IBookingService
import com.razorpay.RazorpayClient
import com.razorpay.RazorpayException
import com.razorpay.Utils
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.HashMap

@CrossOrigin
@RestController
@RequestMapping("booking")
class BookingController {
    @Autowired
    private lateinit var iBookingService: IBookingService
    @PostMapping("/addBooking")
    fun addBooking(@RequestBody booking: Booking ): ResponseEntity<Any?> {
        var addBooking = iBookingService.addBooking(booking)
        return ResponseEntity(addBooking, HttpStatus.OK)
    }

    @GetMapping("/getAllBooking")
    fun getAllBooking():ResponseEntity<MutableList<Booking?>>
    {
        var bookinglist = iBookingService.getAllBooking()
        return ResponseEntity(bookinglist,HttpStatus.OK)
    }

    @GetMapping("/getBookingById/{id}")
    fun getBookingById(@PathVariable id:String):ResponseEntity<Optional<Booking?>>{
        var parkingDetails = iBookingService.getBookingById(id)
        return ResponseEntity(parkingDetails,HttpStatus.OK)
    }

    @PostMapping("/payBooking")
    fun payBooking(@RequestBody body: Order): ResponseEntity<Any?> {
        try {
            //Initialize
            val razorpayClient = RazorpayClient("rzp_test_nLdcIfHZDg9AST", "5RGZrBjIHW2TaYoWEtd86eRV")
            //Add headers
            val headers: Map<String, String> = HashMap()
            razorpayClient.addHeaders(headers)
            //Create order
            val orderRequest = JSONObject()
            orderRequest.put("amount", body.amount) // amount in the smallest currency unit
            orderRequest.put("currency", body.currency)
            orderRequest.put("receipt", body.receipt)
            val order = razorpayClient.Orders.create(orderRequest)

            return ResponseEntity(order.toString(), HttpStatus.OK)

        } catch (e: RazorpayException) {

            // Handle Exception
            println(e.message)
            return ResponseEntity(e.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
//        var addBooking = iBookingService.addBooking(booking)
//        return ResponseEntity(addBooking, HttpStatus.OK)
    }

    @PostMapping("/verifySignature")
    fun verifySignature(@RequestBody body: VerifyPayment): ResponseEntity<Any?> {
        try {

            //Verify order
            val options = JSONObject()
            options.put("razorpay_order_id", body.razorpay_order_id)
            options.put("razorpay_payment_id", body.razorpay_payment_id)
            options.put("razorpay_signature", body.razorpay_signature)

            val isEqual: Boolean = Utils.verifyPaymentSignature(options, "5RGZrBjIHW2TaYoWEtd86eRV")

            if(isEqual) {
                return ResponseEntity("Payment Success", HttpStatus.OK)
            }else{
                return ResponseEntity("Payment Failure", HttpStatus.OK)
            }

        } catch (e: RazorpayException) {

            // Handle Exception
            println(e.message)
            return ResponseEntity(e.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}