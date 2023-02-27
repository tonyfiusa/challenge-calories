package com.talf.calories.order.adapters.controllers;

import com.talf.calories.order.business.*;
import com.talf.calories.order.entities.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/order/order", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "order-api")
public class OrderRestController {

  private final GetUserOrdersUseCase getUserOrdersUseCase;
  private final DeleteOrderUserCase deleteOrderUserCase;
  private final UpdateOrderUserCase updateOrderUserCase;
  private final PlaceOrderUseCase placeOrderUseCase;
  private final NotifyOrderCaloriesCalculationUseCase notifyOrderCaloriesCalculationUseCase;

  public OrderRestController(GetUserOrdersUseCase getUserOrdersUseCase, DeleteOrderUserCase deleteOrderUserCase, UpdateOrderUserCase updateOrderUserCase, PlaceOrderUseCase placeOrderUseCase, NotifyOrderCaloriesCalculationUseCase notifyOrderCaloriesCalculationUseCase) {
    this.getUserOrdersUseCase = getUserOrdersUseCase;
    this.deleteOrderUserCase = deleteOrderUserCase;
    this.updateOrderUserCase = updateOrderUserCase;
    this.placeOrderUseCase = placeOrderUseCase;
    this.notifyOrderCaloriesCalculationUseCase = notifyOrderCaloriesCalculationUseCase;
  }

  @GetMapping("/all")
  @Operation(
    summary = "Returns all available order for the user",
    operationId = "getAll")
  public List<Order> getAll() {
    return this.getUserOrdersUseCase.get();
  }

  @PostMapping("/")
  @Operation(
    summary = "Places a new order",
    operationId = "placeOrder")
  public Long placeOrder(@RequestParam(name = "employeeName") String employeeName,
                         @RequestParam(name = "entryId", required = false) Long entryId,
                         @RequestParam(name = "mainCourseId", required = false) Long mainCourseId,
                         @RequestParam(name = "beverageId", required = false) Long beverageId) {
    Long orderId = this.placeOrderUseCase.placeOrder(employeeName, entryId, mainCourseId, beverageId);
    this.notifyOrderCaloriesCalculationUseCase.notify(orderId);
    return orderId;
  }

  @DeleteMapping("/{id}")
  @Operation(
    summary = "Deletes an order",
    operationId = "delete")
  public void delete(@PathVariable(name = "id") long id) {
    this.deleteOrderUserCase.delete(id);
  }

  @PutMapping("/{id}")
  @Operation(
    summary = "Updates an order",
    operationId = "update")
  public Order update(@PathVariable(name = "id") long id,
                      @RequestParam(name = "employeeName") String employeeName,
                      @RequestParam(name = "entryId", required = false) Long entryId,
                      @RequestParam(name = "mainCourseId", required = false) Long mainCourseId,
                      @RequestParam(name = "beverageId", required = false) Long beverageId) {
    Order order = this.updateOrderUserCase.update(id, employeeName, entryId, mainCourseId, beverageId);
    this.notifyOrderCaloriesCalculationUseCase.notify(order.id());
    return order;
  }
}
