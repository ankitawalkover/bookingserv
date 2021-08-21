package com.paypal.bfs.test.bookingser.jpa.repository;

import com.paypal.bfs.test.bookingser.jpa.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
}
