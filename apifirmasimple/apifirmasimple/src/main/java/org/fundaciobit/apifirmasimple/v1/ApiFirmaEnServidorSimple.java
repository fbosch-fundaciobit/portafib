package org.fundaciobit.apifirmasimple.v1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.fundaciobit.apifirmasimple.v1.beans.FirmaSimpleFile;
import org.fundaciobit.apifirmasimple.v1.beans.FirmaSimpleSignDocumentsRequest;
import org.fundaciobit.apifirmasimple.v1.beans.FirmaSimpleSignDocumentsResponse;

import com.sun.jersey.api.client.ClientResponse;

/**
 * 
 * @author anadal
 *
 */
public class ApiFirmaEnServidorSimple extends AbstractApiFirmaSimple {

  // Nom de les operacions en constants
  public static final String UPGRADESIGNATURE = "upgradeSignature";

  public static final String SIGNDOCUMENTS = "signDocuments";
  
  public static final String GETMAXNUMBEROFSIGNATURESBYTRANSACTION = "getMaxNumberOfSignaturesByTransaction";

  /**
   * @param endPointBase
   */
  public ApiFirmaEnServidorSimple(String endPointBase) {
    super(endPointBase);
  }

  /**
   * @param endPointBase
   * @param username
   * @param password
   */
  public ApiFirmaEnServidorSimple(String endPointBase, String username, String password) {
    super(endPointBase, username, password);
  }

  /**
   *
   * @param signaturesSet
   * @return
   * @throws Exception
   */
  public FirmaSimpleSignDocumentsResponse signDocuments(
      FirmaSimpleSignDocumentsRequest signaturesSet) throws Exception {

    ClientResponse response = commonCall(signaturesSet, ApiFirmaEnServidorSimple.SIGNDOCUMENTS);

    FirmaSimpleSignDocumentsResponse result = response
        .getEntity(FirmaSimpleSignDocumentsResponse.class);

    return result;
  }
  
  
  public Integer getMaxNumberOfSignaturesByTransaction() throws Exception {
    ClientResponse response = commonCall(null, ApiFirmaEnServidorSimple.GETMAXNUMBEROFSIGNATURESBYTRANSACTION);

    String result = response.getEntity(String.class);

    result = cleanString(result);
    
    if (result == null || result.trim().length() == 0) {
      return null;
    }

    return Integer.parseInt(result);
  }
  
  
  
  public FirmaSimpleFile upgradeSignature(byte[] signature) throws Exception {
    ClientResponse response = commonCall(signature, ApiFirmaEnServidorSimple.UPGRADESIGNATURE);

    FirmaSimpleFile result = response.getEntity(FirmaSimpleFile.class);

    if (result != null && result.getMime() != null) {
      if ("application/xml".equals(result.getMime())) {
        if (!isUTF8(result.getData())) {
          // Algunes firmes XAdes es retornen com a ANSI despres de passar per REST
          // S'han de convertir a UTF-8
          result.setData(transformEncoding(result.getData(), "ISO-8859-1", "UTF-8"));
          result.setMime(null);
        }
      }
    }
    
    return result;
    
    /* XYZ ZZZ
    InputStream is = response.getEntityInputStream();
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    int n;
    byte[] buffer = new byte[1024];
    while ((n = is.read(buffer)) > -1) {
        os.write(buffer, 0, n);   // Don't allow any extra bytes to creep in, final write
    }
    os.close();

    return os.toByteArray();
    */
  }
  
  
  // XYZ Moure a Utils
  private static byte[] transformEncoding(byte[] source, String srcEncoding, String tgtEncoding)
      throws IOException {
    BufferedReader br = null;
    BufferedWriter bw = null;

    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    try {
      br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(source),
          srcEncoding));
      bw = new BufferedWriter(new OutputStreamWriter(baos, tgtEncoding));
      char[] buffer = new char[16384];
      int read;
      while ((read = br.read(buffer)) != -1)
        bw.write(buffer, 0, read);
    } finally {
      try {
        if (br != null)
          br.close();
      } finally {
        if (bw != null)
          bw.close();
      }
    }

    return baos.toByteArray();
  }

  // XYZ ZZZ Moure a Utils
  private static boolean isUTF8(byte[] barr) {

    CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
    ByteBuffer buf = ByteBuffer.wrap(barr);

    try {
      decoder.decode(buf);

    } catch (CharacterCodingException e) {
      return false;
    }

    return true;
  }
  
  

}
