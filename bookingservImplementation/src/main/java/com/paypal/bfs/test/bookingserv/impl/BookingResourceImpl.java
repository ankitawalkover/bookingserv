package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingser.jpa.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.manager.BookingManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    BookingManager bookingManager;

    @Override
    public ResponseEntity<Booking> create(Booking booking){
        try {
            bookingManager.createBooking(booking);
            final HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<>(booking, headers, HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Get {@link Booking} resource
     *
     * @return list of booking resource
     */
    @Override
    public ResponseEntity<List<Booking>> get() {
        List<Booking> bookings = bookingManager.getBookingList();
        final HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(bookings, headers, HttpStatus.OK);
    }
}
