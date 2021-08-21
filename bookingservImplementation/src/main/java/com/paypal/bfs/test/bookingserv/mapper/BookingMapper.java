package com.paypal.bfs.test.bookingserv.mapper;

import com.paypal.bfs.test.bookingser.jpa.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking toDto(BookingEntity bookingEntity);
}
