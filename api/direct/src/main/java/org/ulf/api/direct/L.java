/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulf.api.direct;

import org.ulf.api.IMessage;
import org.ulf.api.LoggingFramework;

/**
 *  Utility class shortenning access to {@link LoggingFramework}.
 * 
 * @author jbc
 */
public class L {
  public static void l( IMessage message ) {
    LoggingFramework.deliver(message);
  }
}
