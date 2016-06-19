package com.example.calculatorusingwebservices;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.StrictMode;

public class WebData {
String url="http://192.168.1.100:7777/Calculator/services/Hello?wsdl";
public static final String NAMESPACE = "http://calc.ducat.deep";
String SOAP_ACTION;
SoapObject request = null;
HttpTransportSE andt;
SoapSerializationEnvelope envelope;
public void setEnvelope(){
	 try {
                
       envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
       envelope.setOutputSoapObject(request);
   andt=new HttpTransportSE(url);
        
   } catch (Exception e) {
       System.out.println("Soap Exception---->>>" + e.toString());    
   }
}

public String getAdd(String methodName,int i,int j){
	try{
	SOAP_ACTION = NAMESPACE + methodName;
	 request = new SoapObject(NAMESPACE, methodName);
     request.addProperty("i", i);
     request.addProperty("j",j);
     StrictMode.ThreadPolicy p=new StrictMode.ThreadPolicy.Builder().build();
     StrictMode.setThreadPolicy(p);
     setEnvelope();
     try { 
         andt.call(SOAP_ACTION, envelope);
         String result = envelope.getResponse().toString();
         return result;
     } catch (Exception e) {
         return e.toString();
     }
	}
	catch (Exception e) {
		return e.toString();
	}
	}

public String getReg(String methodName,String name ,String pass){
	try{
	SOAP_ACTION = NAMESPACE + methodName;
	 request = new SoapObject(NAMESPACE, methodName);
     request.addProperty("name", name);
     request.addProperty("pass",pass);
     StrictMode.ThreadPolicy p=new StrictMode.ThreadPolicy.Builder().build();
     StrictMode.setThreadPolicy(p);
     setEnvelope();
     try { 
         andt.call(SOAP_ACTION, envelope);
         String result = envelope.getResponse().toString();
         return result;
     } catch (Exception e) {
         return e.toString();
     }
	}
	catch (Exception e) {
		return e.toString();
	}
	}
}
