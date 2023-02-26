package com.talf.calories.order.adapters.controllers;

import com.talf.calories.order.business.DeleteOrderUserCase;
import com.talf.calories.order.business.GetUserOrdersUseCase;
import com.talf.calories.order.business.PlaceOrderUseCase;
import com.talf.calories.order.business.UpdateOrderUserCase;
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

  public OrderRestController(GetUserOrdersUseCase getUserOrdersUseCase, DeleteOrderUserCase deleteOrderUserCase, UpdateOrderUserCase updateOrderUserCase, PlaceOrderUseCase placeOrderUseCase) {
    this.getUserOrdersUseCase = getUserOrdersUseCase;
    this.deleteOrderUserCase = deleteOrderUserCase;
    this.updateOrderUserCase = updateOrderUserCase;
    this.placeOrderUseCase = placeOrderUseCase;
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
    return this.placeOrderUseCase.placeOrder(employeeName, entryId, mainCourseId, beverageId);
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
    return this.updateOrderUserCase.update(id, employeeName, entryId, mainCourseId, beverageId);
  }
}
