/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulf.api.direct;

import org.ulf.api.IMarker;
import org.ulf.api.IMessage;
import org.ulf.api.LoggingFramework;

/**
 *  Utility class shortening access to {@link LoggingFramework}.
 *  
 * This class provides shortrands for creating message and loggin
 * 
 * @author jbc
 */
public class L {
  public static final int LEVEL_ERROR = 100;
  public static final int LEVEL_WARNING = 200;
  public static final int LEVEL_INFO = 300;
  public static final int LEVEL_DEBUG = 400;
  public static final int LEVEL_VERBOSE = 500;
  
  public static void l( IMessage message ) {
    LoggingFramework.deliver(message);
  }
  public static IMessage m() {
    return LoggingFramework.createMessage(null);
  }
  public static IMarker marker( String name ) {
    return LoggingFramework.createMarker(new Object[]{name});
  }
  
  public static void e( Throwable th ) {
    l(m().facade(L.class.getName()).at(LEVEL_ERROR).about(th));
  }
  public static void e( Throwable th, String message, Object... args ) {
    l(m().facade(L.class.getName()).at(LEVEL_ERROR).about(th).saing(message).using(args));
  }
  public static void e( Class c, String method, String message, Object... args ) {
    l(m().facade(L.class.getName()).at(LEVEL_ERROR).from(c.getName(),method).saing(message).using(args));
  }
  
  
  public static void w( Throwable th ) {
    l(m().facade(L.class.getName()).at(LEVEL_WARNING).about(th));
  }
  public static void w( Throwable th, String message, Object... args ) {
    l(m().facade(L.class.getName()).at(LEVEL_WARNING).about(th).saing(message).using(args));
  }
  public static void w( Class c, String method, String message, Object... args ) {
    l(m().facade(L.class.getName()).at(LEVEL_WARNING).from(c.getName(),method).saing(message).using(args));
  }
  
  public static void i( Throwable th ) {
    l(m().facade(L.class.getName()).at(LEVEL_INFO).about(th));
  }
  public static void i( Throwable th, String message, Object... args ) {
    l(m().facade(L.class.getName()).at(LEVEL_INFO).about(th).saing(message).using(args));
  }
  public static void i( Class c, String method, String message, Object... args ) {
    l(m().facade(L.class.getName()).at(LEVEL_INFO).from(c.getName(),method).saing(message).using(args));
  }
  
  public static void d( Throwable th ) {
    l(m().facade(L.class.getName()).at(LEVEL_DEBUG).about(th));
  }
  public static void d( Throwable th, String message, Object... args ) {
    l(m().facade(L.class.getName()).at(LEVEL_DEBUG).about(th).saing(message).using(args));
  }
  public static void d( Class c, String method, String message, Object... args ) {
    l(m().facade(L.class.getName()).at(LEVEL_DEBUG).from(c.getName(),method).saing(message).using(args));
  }
  
  public static void v( Throwable th ) {
    l(m().facade(L.class.getName()).at(LEVEL_VERBOSE).about(th));
  }
  public static void v( Throwable th, String message, Object... args ) {
    l(m().facade(L.class.getName()).at(LEVEL_VERBOSE).about(th).saing(message).using(args));
  }
  public static void v( Class c, String method, String message, Object... args ) {
    l(m().facade(L.class.getName()).at(LEVEL_VERBOSE).from(c.getName(),method).saing(message).using(args));
  }
}
