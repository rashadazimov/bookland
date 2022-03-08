package com.bookland.repository;

import com.bookland.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order,Integer> {



}
