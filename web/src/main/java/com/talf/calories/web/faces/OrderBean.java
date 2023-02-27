package com.talf.calories.web.faces;

import com.talf.calories.order.api.OrderApiApi;
import com.talf.calories.order.model.Order;
import com.talf.calories.product.api.BeverageApiApi;
import com.talf.calories.product.api.EntryApiApi;
import com.talf.calories.product.api.MainCourseApiApi;
import com.talf.calories.product.model.Beverage;
import com.talf.calories.product.model.Entry;
import com.talf.calories.product.model.MainCourse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


@Scope(value = "session")
@Component(value = "orderController")
public class OrderBean {

  private String employeeName;
  private Long selectedEntryId;
  private Long selectedMainCourseId;
  private Long selectedBeverageId;
  private Order selectedOrder;

  private final OrderApiApi orderApiApi;
  private final List<MainCourse> mainCourses;
  private final List<Beverage> beverages;
  private final List<Entry> entries;

  public OrderBean(MainCourseApiApi mainCourseApiApi, EntryApiApi entryApiApi, BeverageApiApi beverageApiApi, OrderApiApi orderApiApi) {
    this.mainCourses = mainCourseApiApi.getAll();
    this.beverages = beverageApiApi.getAll2();
    this.entries = entryApiApi.getAll1();

    this.orderApiApi = orderApiApi;
  }

  public String placeOrder() {
    this.orderApiApi.placeOrder(this.employeeName, this.selectedEntryId, this.selectedMainCourseId, this.selectedBeverageId);
    return "/check-orders.xhtml?faces-redirect=true";
  }

  public List<Order> getOrders() {
    return this.orderApiApi.getAll();
  }

  public String getEntry(Long entryId) {
    return this.entries.stream()
      .filter(entry -> Objects.equals(entry.getId(), entryId))
      .findFirst()
      .map(Entry::getName)
      .orElse(null);
  }

  public String getMainCourse(Long mainCourseId) {
    return this.mainCourses.stream()
      .filter(mainCourse -> Objects.equals(mainCourse.getId(), mainCourseId))
      .findFirst()
      .map(MainCourse::getName)
      .orElse(null);
  }

  public String getBeverage(Long beverageId) {
    return this.beverages.stream()
      .filter(beverage -> Objects.equals(beverage.getId(), beverageId))
      .findFirst()
      .map(Beverage::getName)
      .orElse(null);
  }

  public String redirectToUpdate(long orderId) {
    selectedOrder = this.getOrders().stream()
      .filter(order -> Objects.equals(order.getId(), orderId))
      .findFirst()
      .orElse(null);

    return "/order-update-form.xhtml?faces-redirect=true";
  }

  public String delete(long orderId) {
    this.orderApiApi.delete(orderId);
    return "/check-orders.xhtml?faces-redirect=true";
  }

  public String update() {
    this.orderApiApi.update(
      this.selectedOrder.getId(),
      this.selectedOrder.getEmployeeName(),
      this.selectedOrder.getEntryId(),
      this.selectedOrder.getMainCourseId(),
      this.selectedOrder.getBeverageId()
    );
    return "/check-orders.xhtml?faces-redirect=true";

  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public List<MainCourse> getMainCourses() {
    return mainCourses;
  }

  public List<Beverage> getBeverages() {
    return beverages;
  }

  public List<Entry> getEntries() {
    return entries;
  }

  public Long getSelectedEntryId() {
    return selectedEntryId;
  }

  public void setSelectedEntryId(Long selectedEntryId) {
    this.selectedEntryId = selectedEntryId;
  }

  public Long getSelectedMainCourseId() {
    return selectedMainCourseId;
  }

  public void setSelectedMainCourseId(Long selectedMainCourseId) {
    this.selectedMainCourseId = selectedMainCourseId;
  }

  public Long getSelectedBeverageId() {
    return selectedBeverageId;
  }

  public void setSelectedBeverageId(Long selectedBeverageId) {
    this.selectedBeverageId = selectedBeverageId;
  }

  public Order getSelectedOrder() {
    return selectedOrder;
  }

  public void setSelectedOrder(Order selectedOrder) {
    this.selectedOrder = selectedOrder;
  }
}
