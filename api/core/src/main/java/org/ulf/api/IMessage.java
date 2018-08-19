package org.ulf.api;

/**
 * A message that can be logged by logging framework.
 * <p>
 * This interface abstracts away the type that will be used
 * to store information about log message ,that is abput to be logged.
 * <p>
 * The data contained in this class may be divided into 3 areas:
 * <ol>
 *  <li>Content - data that are actually loged. This includes a string
 *                message, it's format arguments and/or caught exception</li>
 *  <li>Decorators - additional information about message wcich are usefull
 *                   durring message filtration in underlying framework.
 *                   these include: message log level, and marker</li>
 *  <li>Source - this data describe the exact place in code, that produced
 *               this message. They include the class name, method name or
 *               faccade class name if method and class name detection
 *                from stack is desiered</li>
 * </ol>
 * @author jbytecoder
 */
public interface IMessage {
    String getFacadeName();
    String getSourceClass();
    String getSoruceMethod();
    IMarker getMarker();
    int getLevel();
    Throwable getException();
    String getFormat();
    Object[] getFormatArguments();
    
    IMessage facade( String fqcn );
    IMessage from( String c, String method );
    IMessage markAs( IMarker marker );
    IMessage at( int level );
    IMessage saing( String format );
    IMessage using( Object... args );
    IMessage about( Throwable th );
    IMessage say();
}
