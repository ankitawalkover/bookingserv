package com.paypal.bfs.test.bookingserv.manager;

import com.paypal.bfs.test.bookingser.jpa.entity.AddressEntity;
import com.paypal.bfs.test.bookingser.jpa.entity.BookingEntity;
import com.paypal.bfs.test.bookingser.jpa.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.mapper.BookingMapper;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingManager {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    BookingMapper bookingMapper;

    public void createBooking(Booking booking) {
        BookingEntity bookingEntity = new BookingEntity();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(booking.getAdditionalProperties().get("city").toString());
        addressEntity.setLine1(booking.getAdditionalProperties().get("line1").toString());
        if(booking.getAdditionalProperties().get("line2") != null){
            addressEntity.setLine2(booking.getAdditionalProperties().get("line2").toString());
        }
        addressEntity.setState(booking.getAdditionalProperties().get("state").toString());
        addressEntity.setZipCode((Integer)booking.getAdditionalProperties().get("zipCode"));

        bookingEntity.setAddress(addressEntity);
        bookingEntity.setCheckinDatetime((Date)booking.getAdditionalProperties().get(
                "checkinDateTime"));
        bookingEntity.setCheckoutDatetime((Date)booking.getAdditionalProperties().get(
                "checkoutDateTime"));
        bookingEntity.setDeposit((float)booking.getAdditionalProperties().get(
                "deposit"));
        bookingEntity.setDob((Date)booking.getAdditionalProperties().get(
                "dob"));
        bookingEntity.setFirstName(booking.getFirstName());
        bookingEntity.setLastName(booking.getLastName());
        bookingEntity.setId(booking.getId());

        bookingRepository.save(bookingEntity);

    }

    public List<Booking> getBookingList() {
        return bookingRepository.findAll().stream().map(val -> bookingMapper.toDto(val)).collect(
                Collectors.toList());
    }
}
