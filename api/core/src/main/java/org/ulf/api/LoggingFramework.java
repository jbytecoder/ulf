package org.ulf.api;

/**
 * 
 * Facade over logging framework interface.
 * <p>
 * This class servers purpouse of common main entry point of library
 * . Here the implementation of loggin framework is looked up. 
 * <p>
 * Any custom api implementation needs to be hooked into this class
 * 
 * @author jbytecoder
 */
public class LoggingFramework {
   public static IMarker createMarker() {
     return null;
   }
   public static IMessage createMessage() {
     return null;
   }
   public static void deliver( IMessage message ) {
     
   } 
}
