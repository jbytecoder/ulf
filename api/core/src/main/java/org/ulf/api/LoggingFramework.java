package org.ulf.api;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

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
   private static final ILoggingFramework framework;
   
   static {
     Optional<ILoggingFramework> candidate = 
             StreamSupport.stream(
                     ServiceLoader.load(ILoggingFramework.class)
                                  .spliterator(),
                     false).findFirst();
     if( candidate.isPresent() ) {
        framework = candidate.get();
     } else {
       // todo: provide a default
       framework = null;
     }
   }
  
   /**
    * Create a new marker;
    * 
    * This function delegates to {@link ILoggingFramework#createMarker(java.lang.Object[]) }
    * 
    * @param data
    * @return 
    */
   public static IMarker createMarker(Object[] data) {
     return framework.createMarker(data);
   }
   /**
    * Create a new message;
    * 
    * This function delegates to {@link ILoggingFramework#createMessage(java.lang.Object[]) }
    * 
    * @param data
    * @return 
    */
   public static IMessage createMessage(Object[] data) {
     return framework.createMessage(data);
   }
   /**
    * Sends the message into the logging framework.
    * 
    * This function delegates to {@link ILoggingFramework#deliver(org.ulf.api.IMessage)}
    * 
    * @param message 
    */
   public static void deliver( IMessage message ) {
     framework.deliver(message);
   } 
}
