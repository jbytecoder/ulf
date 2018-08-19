/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulf.slf4j;

import org.ulf.api.IMarker;
import org.ulf.api.IMessage;
import org.ulf.api.LoggingFramework;

/**
 *
 * @author jbc
 */
public class SimpleMessage implements IMessage {

  private String facade;
  private String sourceClass;
  private String sourceMethod;
  
  private int level;
  private Throwable exception;
  private String format;
  private Object[] arguments;
  
  @Override
  public String getFacadeName() {
    return facade;
  }
  
  @Override
  public String getSourceClass() {return sourceClass;}

  @Override
  public String getSoruceMethod() {return sourceMethod;}

  @Override
  public IMarker getMarker() {
    return null;
  }

  @Override
  public int getLevel() {return level;}

  @Override
  public Throwable getException() {
    return exception;
  }

  @Override
  public String getFormat() {
    return format;
  }

  @Override
  public Object[] getFormatArguments() {return  arguments;}
  

  @Override
  public IMessage from(String c, String method) {
    sourceClass = c;
    sourceMethod = method;
    return this;
  }

  @Override
  public IMessage markAs(IMarker marker) {
    return this;
  }

  @Override
  public IMessage at(int level) {
    this.level  = level;
    return this;
  }

  @Override
  public IMessage facade(String fqcn) {
    this.facade = fqcn;
    return this;
  }

  @Override
  public IMessage saing(String format) {
    this.format = format;
    return this;
  }

  @Override
  public IMessage using(Object... args) {
    this.arguments = args;
    return this;
  }

  @Override
  public IMessage say() {
    if( facade == null ) {
      facade = SimpleMessage.class.getName();
    }
    LoggingFramework.deliver(this);
    return this;
  }

  

  @Override
  public IMessage about(Throwable th) {
    exception = th;
    return this;
  }
  
}
