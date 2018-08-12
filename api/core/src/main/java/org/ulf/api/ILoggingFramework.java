/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulf.api;

/**
 * Represents the desiered logging framework.
 * 
 * <p>
 * This inerface abstracts away the underlying loggin framework that might
 * be used in project. The idea is to provide as simple and rather static
 * interface as possible to allow easy implemetations for popular 
 * logging frameworkss
 * <p>
 * 
 * 
 * 
 * @author jbytecoder
 */
public interface ILoggingFramework {
    IMarker createMarker( Object[] data );
    IMessage createMessage( Object[] data );
    /**
     * Thorws the message into the loggin framework.
     * 
     * This causes the message to appear in apropirate log as configured in 
     * uderlying framework
     * 
     * @param message 
     */
    void deliver( IMessage message );
}
