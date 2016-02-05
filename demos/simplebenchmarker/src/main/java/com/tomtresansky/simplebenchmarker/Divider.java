package com.tomtresansky.simplebenchmarker;

/**
 * The calculations performed by these methods should take longer for
 * {@link #divide3()}, as this is a much longer division. But constant folding
 * effects negate this.
 * 
 * @author ttresans
 */
public final class Divider {
  public static long divide1() {
    final long val1 = 1, val2 = 1, val3 = 1;
    return val1 / val2 / val3;
  }

  public static long divide2() {
    final long val1 = 64, val2 = 8, val3 = 2;
    return val1 / val2 / val3;
  }

  public static long divide3() {
    final long val1 = 999999999, val2 = 356723, val3 = 4;
    return val1 / val2 / val3;
  }
}
