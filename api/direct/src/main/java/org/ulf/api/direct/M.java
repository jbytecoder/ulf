/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulf.api.direct;

import org.ulf.api.IMessage;

/**
 *
 * @author jbytecoder
 */
public class M {
    public static IMessage me( Class c, String method ) {
      return L.m().at(L.LEVEL_ERROR).from(c.getName(), method);
    }
    public static IMessage me( Throwable th ) {
      return L.m().at(L.LEVEL_ERROR).about(th);
    }
    
    public static IMessage mw( Class c, String method ) {
      return L.m().at(L.LEVEL_WARNING).from(c.getName(), method);
    }
    public static IMessage mw( Throwable th ) {
      return L.m().at(L.LEVEL_WARNING).about(th);
    }
    
    public static IMessage mi( Class c, String method ) {
      return L.m().at(L.LEVEL_INFO).from(c.getName(), method);
    }
    public static IMessage mi( Throwable th ) {
      return L.m().at(L.LEVEL_INFO).about(th);
    }
    
    public static IMessage md( Class c, String method ) {
      return L.m().at(L.LEVEL_DEBUG).from(c.getName(), method);
    }
    public static IMessage md( Throwable th ) {
      return L.m().at(L.LEVEL_DEBUG).about(th);
    }
    
    public static IMessage mv( Class c, String method ) {
      return L.m().at(L.LEVEL_VERBOSE).from(c.getName(), method);
    }
    public static IMessage mv( Throwable th ) {
      return L.m().at(L.LEVEL_VERBOSE).about(th);
    }
}
