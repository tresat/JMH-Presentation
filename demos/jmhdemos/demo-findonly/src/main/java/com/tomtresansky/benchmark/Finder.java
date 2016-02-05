package com.tomtresansky.benchmark;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Finder {
  public static <T> BinaryOperator<T> toOnlyElement() {
    return toOnlyElementThrowing(IllegalArgumentException::new);
  }

  public static <T, E extends RuntimeException> BinaryOperator<T> toOnlyElementThrowing(Supplier<E> exception) {
    return (element, otherElement) -> {
      throw exception.get();
    };
  }
}
