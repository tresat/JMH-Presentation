package com.tomtresansky.simplebenchmarker;

public final class Divider {
  public static long divide1() {
    final long val1 = 1, val2 = 1, val3 = 1;
    return val1 / val2 / val3;
  }

  public static long divide2() {
    final long val1 = 100, val2 = 10, val3 = 5;
    return val1 / val2 / val3;
  }

  public static long divide3() {
    final long val1 = 999999999, val2 = 356723, val3 = 4;
    return val1 / val2 / val3;
  }
}
