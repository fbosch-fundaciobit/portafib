
package es.caib.portafib.ws.api.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.4
 * 2015-03-20T12:30:07.511+01:00
 * Generated source version: 2.6.4
 */

@WebFault(name = "WsValidationErrors", targetNamespace = "http://impl.v1.ws.portafib.caib.es/")
public class WsValidationException extends Exception {
    
    private es.caib.portafib.ws.api.v1.WsValidationErrors wsValidationErrors;

    public WsValidationException() {
        super();
    }
    
    public WsValidationException(String message) {
        super(message);
    }
    
    public WsValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public WsValidationException(String message, es.caib.portafib.ws.api.v1.WsValidationErrors wsValidationErrors) {
        super(message);
        this.wsValidationErrors = wsValidationErrors;
    }

    public WsValidationException(String message, es.caib.portafib.ws.api.v1.WsValidationErrors wsValidationErrors, Throwable cause) {
        super(message, cause);
        this.wsValidationErrors = wsValidationErrors;
    }

    public es.caib.portafib.ws.api.v1.WsValidationErrors getFaultInfo() {
        return this.wsValidationErrors;
    }
}
