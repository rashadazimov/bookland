package com.bookland.service;

import com.bookland.model.Book;
import com.bookland.model.Order;
import com.bookland.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {


    private final BookService bookService;
    private final OrderRepository repository;

    public OrderService(BookService bookService, OrderRepository repository) {
        this.bookService = bookService;
        this.repository = repository;
    }

    public Order putOrder(List<Integer> bookIdList,String username){

        List<Optional<Book>> bookList=bookIdList.stream()
                .map(bookService::findBookById).collect(Collectors.toList());

         Double totalPrice=bookList.stream()
                 .map(optionalBook->optionalBook.map(Book::getPrice).orElse(0.0))
                 .reduce(0.0,Double::sum );
         Order order=Order.builder()
                 .bookIdList(bookIdList)
                 .totalPrice(totalPrice)
                 .username(username)
                 .build();
         return repository.save(order);
    }


    public List<Order> getAllOrders(){
        return repository.findAll();
    }
}
