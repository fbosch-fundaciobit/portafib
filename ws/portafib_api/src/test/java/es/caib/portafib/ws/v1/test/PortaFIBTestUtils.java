package es.caib.portafib.ws.v1.test;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import es.caib.portafib.ws.api.v1.PortaFIBHelloWorldWs;
import es.caib.portafib.ws.api.v1.PortaFIBHelloWorldWsService;
import es.caib.portafib.ws.api.v1.PortaFIBPeticioDeFirmaWs;
import es.caib.portafib.ws.api.v1.PortaFIBPeticioDeFirmaWsService;
import es.caib.portafib.ws.api.v1.PortaFIBUsuariAplicacioWs;
import es.caib.portafib.ws.api.v1.PortaFIBUsuariAplicacioWsService;
import es.caib.portafib.ws.api.v1.PortaFIBUsuariEntitatWs;
import es.caib.portafib.ws.api.v1.PortaFIBUsuariEntitatWsService;
import es.caib.portafib.ws.api.v1.utils.I18NUtils;


/**
 * 
 * @author anadal
 * 
 */
public abstract class PortaFIBTestUtils {

  public static final String HELLO_WORLD = "PortaFIBHelloWorld";

  public static final String USUARI_APLICACIO = "PortaFIBUsuariAplicacio";

  public static final String USUARI_ENTITAT = "PortaFIBUsuariEntitat";
  
  public static final String PETICIO_DE_FIRMA = "PortaFIBPeticioDeFirma";
  
  private static Properties testProperties = new Properties();
  
  static {
    // Traduccions
    try {
      Class.forName(I18NUtils.class.getName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    // Propietats del Servidor
    try {
      testProperties.load(new FileInputStream("test.properties"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
 

  public static String getEndPoint(String api) {
    return testProperties.getProperty("test_host") + api;
  }

  public static String getTestAppUserName() {
    
    return testProperties.getProperty("test_usr");
  }

  
  public static boolean isCAIB() {
    return "true".equals(testProperties.getProperty("iscaib"));
  }

  public static String getTestAppPassword() {
    return testProperties.getProperty("test_pwd");
  }

  public static String getTestPersonaNif() {
    return testProperties.getProperty("test_nif");
  }
  
  public static boolean isWaitToSign() {
    return "true".equals(testProperties.getProperty("waittosign"));
  }
  

  public static void configAddressUserPassword(String usr, String pwd,
      String endpoint, Object api) {

    Map<String, Object> reqContext = ((BindingProvider) api).getRequestContext();
    reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
    reqContext.put(BindingProvider.USERNAME_PROPERTY, usr);
    reqContext.put(BindingProvider.PASSWORD_PROPERTY, pwd);
  }

  public static PortaFIBHelloWorldWs getHelloWorldApi() throws Exception {

    final String endpoint = getEndPoint(HELLO_WORLD);
    
    URL wsdlLocation = new URL(endpoint + "?wsdl");

    PortaFIBHelloWorldWsService helloService = new PortaFIBHelloWorldWsService(wsdlLocation);

    PortaFIBHelloWorldWs helloApi = helloService.getPortaFIBHelloWorldWs();

    // Adreça servidor
    Map<String, Object> reqContext = ((BindingProvider) helloApi).getRequestContext();
    reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

    return helloApi;

  }

  public static PortaFIBUsuariAplicacioWs getUsuariAplicacioApi() throws Exception {
    return getUsuariAplicacioApi(getTestAppUserName(), getTestAppPassword());
  }

  public static PortaFIBUsuariAplicacioWs getUsuariAplicacioApi(String usr, String pwd) throws Exception {
    final String endpoint = getEndPoint(USUARI_APLICACIO);
    
    URL wsdl = new URL(endpoint + "?wsdl");

    PortaFIBUsuariAplicacioWsService service = new PortaFIBUsuariAplicacioWsService(wsdl);

    PortaFIBUsuariAplicacioWs api = service.getPortaFIBUsuariAplicacioWs();

    configAddressUserPassword(usr, pwd, endpoint, api);

    return api;
  }
  
  
  public static PortaFIBUsuariEntitatWs getUsuariEntitatApi() throws Exception {
    final String endpoint = getEndPoint(USUARI_ENTITAT);
    URL wsdl = new URL(endpoint + "?wsdl");
    PortaFIBUsuariEntitatWsService service = new PortaFIBUsuariEntitatWsService(wsdl);

    PortaFIBUsuariEntitatWs api = service.getPortaFIBUsuariEntitatWs();

    configAddressUserPassword(getTestAppUserName(), getTestAppPassword(), endpoint, api);

    return api;
  }
  
  
  public static PortaFIBPeticioDeFirmaWs getPeticioDeFirmaApi() throws Exception  {
    final String endpoint = getEndPoint(PETICIO_DE_FIRMA);
    URL wsdl = new URL(endpoint + "?wsdl");
    PortaFIBPeticioDeFirmaWsService service = new PortaFIBPeticioDeFirmaWsService(wsdl);

    PortaFIBPeticioDeFirmaWs api = service.getPortaFIBPeticioDeFirmaWs();

    configAddressUserPassword(getTestAppUserName(), getTestAppPassword(), endpoint, api);

    return api;
  }

}