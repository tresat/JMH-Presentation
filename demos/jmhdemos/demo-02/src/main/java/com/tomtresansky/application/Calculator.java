package com.tomtresansky.application;

public final class Calculator {
  public static double distance(double x1, double x2, double y1, double y2) {
    double dx = x2 - x1;
    double dy = y2 - y1;
    
    return Math.sqrt((dx * dx) + (dy * dy));
  }

  public static double constant(double x1, double y1, double x2, double y2) {
    return 0.0d;
  }
  
  public static void nothing(double x1, double y1, double x2, double y2) {
    // do nothing
  }
}
