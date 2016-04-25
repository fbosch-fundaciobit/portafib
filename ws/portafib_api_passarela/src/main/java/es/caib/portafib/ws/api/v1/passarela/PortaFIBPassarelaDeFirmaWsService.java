package es.caib.portafib.ws.api.v1.passarela;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.4
 * 2016-04-25T11:11:13.859+02:00
 * Generated source version: 2.6.4
 * 
 */
@WebServiceClient(name = "PortaFIBPassarelaDeFirmaWsService", 
                  wsdlLocation = "http://localhost:8080/portafib/ws/v1/PortaFIBPassarelaDeFirma?wsdl",
                  targetNamespace = "http://impl.v1.ws.portafib.caib.es/") 
public class PortaFIBPassarelaDeFirmaWsService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.v1.ws.portafib.caib.es/", "PortaFIBPassarelaDeFirmaWsService");
    public final static QName PortaFIBPassarelaDeFirmaWs = new QName("http://impl.v1.ws.portafib.caib.es/", "PortaFIBPassarelaDeFirmaWs");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/portafib/ws/v1/PortaFIBPassarelaDeFirma?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PortaFIBPassarelaDeFirmaWsService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/portafib/ws/v1/PortaFIBPassarelaDeFirma?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PortaFIBPassarelaDeFirmaWsService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PortaFIBPassarelaDeFirmaWsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PortaFIBPassarelaDeFirmaWsService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns PortaFIBPassarelaDeFirmaWs
     */
    @WebEndpoint(name = "PortaFIBPassarelaDeFirmaWs")
    public PortaFIBPassarelaDeFirmaWs getPortaFIBPassarelaDeFirmaWs() {
        return super.getPort(PortaFIBPassarelaDeFirmaWs, PortaFIBPassarelaDeFirmaWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PortaFIBPassarelaDeFirmaWs
     */
    @WebEndpoint(name = "PortaFIBPassarelaDeFirmaWs")
    public PortaFIBPassarelaDeFirmaWs getPortaFIBPassarelaDeFirmaWs(WebServiceFeature... features) {
        return super.getPort(PortaFIBPassarelaDeFirmaWs, PortaFIBPassarelaDeFirmaWs.class, features);
    }

}
