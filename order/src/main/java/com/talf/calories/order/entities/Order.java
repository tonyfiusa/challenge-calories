package com.talf.calories.order.entities;

public record Order(long id, long createAt, String employeeName, Long entryId, Long mainCourseId, Long beverageId, Long totalCalories) {
}
