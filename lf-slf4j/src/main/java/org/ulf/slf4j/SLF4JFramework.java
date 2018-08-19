/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulf.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.EventConstants;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;
import org.ulf.api.ILoggingFramework;
import org.ulf.api.IMarker;
import org.ulf.api.IMessage;

/**
 *
 * @author jbc
 */
public class SLF4JFramework implements ILoggingFramework {

  @Override
  public IMarker createMarker(Object[] data) {
    throw new UnsupportedOperationException("The markers are not supported");
  }

  @Override
  public IMessage createMessage(Object[] data) {
    return new SimpleMessage();
  }

  @Override
  public void deliver(IMessage message) {
    Logger logger =  LoggerFactory.getLogger(message.getSourceClass());
    if( message.getFacadeName() == null ) {
      message.facade(SLF4JFramework.class.getName());
    }
    if( logger instanceof  LocationAwareLogger ) {
        int inLevel = 0;
        if( message.getLevel() <= 100 ) {
          inLevel = EventConstants.ERROR_INT;
        } else if( message.getLevel() <= 200 ) {
          inLevel = EventConstants.WARN_INT;
        } else if( message.getLevel() <= 300 ) {
          inLevel = EventConstants.INFO_INT;
        } else if( message.getLevel() <= 400 ) {
          inLevel = EventConstants.DEBUG_INT;
        } else if( message.getLevel() <= 500 ) {
          inLevel = EventConstants.TRACE_INT;
        }
        ((LocationAwareLogger) logger)
                .log(null, 
                        message.getFacadeName(),
                        inLevel, 
                        MessageFormatter.arrayFormat(
                                message.getFormat(),
                                message.getFormatArguments()
                        ).getMessage(),
                        message.getFormatArguments(),
                        message.getException());
        return;
    }
    if( message.getLevel() < 100 ) {
      if( message.getException() != null ) {
        logger.error(message.getFormat(), message.getException());
      } else {
        logger.error(message.getFormat(),message.getFormatArguments());
      } 
    } else if ( message.getLevel() < 200 ) {
      if( message.getException() != null ) {
        logger.warn(message.getFormat(), message.getException());
      } else {
        logger.warn(message.getFormat(),message.getFormatArguments());
      } 
    }
    else if ( message.getLevel() < 300 ) {
      if( message.getException() != null ) {
        logger.info(message.getFormat(), message.getException());
      } else {
        logger.info(message.getFormat(),message.getFormatArguments());
      } 
    }
    else if ( message.getLevel() < 400 ) {
      if( message.getException() != null ) {
        logger.debug(message.getFormat(), message.getException());
      } else {
        logger.debug(message.getFormat(),message.getFormatArguments());
      } 
    }
    else if ( message.getLevel() < 500 ) {
      if( message.getException() != null ) {
        logger.trace(message.getFormat(), message.getException());
      } else {
        logger.trace(message.getFormat(),message.getFormatArguments());
      } 
    }
  }
    
}
