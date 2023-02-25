package com.talf.calories.product.adapters.controllers;

import com.talf.calories.product.business.GetAvailableEntriesUseCase;
import com.talf.calories.product.entities.Entry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product/entry", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "entry-api")
public class EntryRestController {

  private final GetAvailableEntriesUseCase getAvailableEntriesUseCase;

  public EntryRestController(GetAvailableEntriesUseCase getAvailableEntriesUseCase) {
    this.getAvailableEntriesUseCase = getAvailableEntriesUseCase;
  }

  @GetMapping("/")
  @Operation(
    summary = "Returns all available Entries",
    operationId = "getAll")
  public List<Entry> getAll() {
    return this.getAvailableEntriesUseCase.get();
  }
}
