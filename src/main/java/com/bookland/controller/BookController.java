package com.bookland.controller;

import com.bookland.dto.RequestBookDto;
import com.bookland.model.Book;
import com.bookland.model.Order;
import com.bookland.service.BookService;
import com.bookland.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    private final OrderService orderService;
    private final BookService bookService;

    public BookController(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> bookList=bookService.getAllBooks();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orderList=orderService.getAllOrders();
        return ResponseEntity.ok(orderList);
    }

    @PostMapping()
    public ResponseEntity<Order> putOrder(@RequestBody RequestBookDto requestBookDto){
        Order order=orderService.putOrder(requestBookDto.getBookIdList(),requestBookDto.getUserName());
        return ResponseEntity.ok(order);
    }
}
