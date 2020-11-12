package kcb.mavuno.payments.engine.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import kcb.mavuno.payments.engine.config.SafaricomProperties;
//import kcb.mavuno.payments.engine.model.RequestPayloadMain;
//import kcb.mavuno.payments.engine.model.ResponsePayloadMain;
import kcb.mavuno.payments.engine.model.safaricom.*;
import kcb.mavuno.payments.engine.config.Utils;
import kcb.mavuno.payments.engine.entities.Request;
import kcb.mavuno.payments.engine.entities.Response;
import kcb.mavuno.payments.engine.entities.ResponseHeader;
import kcb.mavuno.payments.engine.entities.ResponsePayload;
import kcb.mavuno.payments.engine.entities.ResponseTransactionInfo;


@RestController
@RequestMapping("/api/v1")
public class FundsTransferController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FundsTransferController.class);
	
    @Autowired
    private SafaricomProperties safaricomProperties;
	
	@PostMapping("/fundstransfer")
	  public Response postFundsTransfer(@RequestBody Request request) {
		  LOGGER.info("================================= Entered postFundsTransfer");
		  Response response = new Response();
		  //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		  Date now = new Date();
		  
			 Status status = new Status();
			 AccessToken at = new AccessToken();
			 
			 at = getAuthToken();
			 
			 if(at.getAccessToken().length() > 2) { 
				 //AFTER GETTING ACCESS TOKEN NOW CALL C2B METHOD
				 String amount  = request.getRequestPayload().getTransactionInfo().getTransactionAmount();
				 String phoneNo =request.getRequestPayload().getTransactionInfo().getCredintMobileNumber();
				 String commandID =request.getHeader().getFeatureName();
				 String description =request.getHeader().getFeatureName();
				 
				 
				 status = InitiateMpesaC2B(at, amount, phoneNo, commandID, description);
				 
				 if(status.getSuccess() == "true" || status.getSuccess().toString().equalsIgnoreCase("true")) {
					 //SUCCESS
				 }else {
					 //FAILED
					 ResponseHeader          res  = new ResponseHeader();
					 ResponseTransactionInfo info = new ResponseTransactionInfo();
					 ResponsePayload         payload = new ResponsePayload();
					 
					 res.setConversationID(request.getHeader().getMessageID());
					 res.setMessageID(request.getHeader().getMessageID());
					 res.setRouteCode("01");
					 res.setStatusCode("0");
					 res.setStatusDescription("Success");
					 res.setTargetSystemID("1");
					 
					 info.setFalconBalance(request.getRequestPayload().getTransactionInfo().getTransactionAmount());
					 info.setTransactionID(request.getHeader().getMessageID());
					 
					 payload.setResponseTransactionInfo(info);
					 
					 response.setResponseHeader(res);
					 response.setResponsePayload(payload);
					 
				 }
			 }else {
				 status.setSuccess("false");
				 status.setMessage("MPESA B2C AccessToken Failed");
			 }
		  
		  return response;
	  }
	
	
	 public AccessToken getAuthToken() {
		 AccessToken  accessToken  = new AccessToken();
		 RestTemplate restTemplate = new RestTemplate();
		 HttpHeaders headers = new HttpHeaders();
		 try {
			 		
			 String appKeySecret   = safaricomProperties.getApp_key() + ":" + safaricomProperties.getApp_secret();
			 byte[] bytes          = appKeySecret.getBytes("ISO-8859-1");
			 String auth           = Base64.getEncoder().encodeToString(bytes);
			
			 headers.setContentType(MediaType.APPLICATION_JSON);
			 headers.set("Authorization", "Basic "+auth);

			 @SuppressWarnings({ "rawtypes", "unchecked" })
			 HttpEntity request = new HttpEntity(headers);
			 
			 ResponseEntity<String> response = restTemplate.exchange(
					    safaricomProperties.getBase_url()+"/oauth/v1/generate?grant_type=client_credentials",
				        HttpMethod.GET,
				        request,
				        String.class
				);
			 
			  if (response.getStatusCode() == HttpStatus.OK) {
				    LOGGER.info("========================== Get Token Response === "+response.getBody());				    
				    @SuppressWarnings("unchecked")
					Map<String, Object> resp = new ObjectMapper().readValue(response.getBody(), HashMap.class);	
				    
				    accessToken.setAccessToken(resp.get("access_token").toString());
				    accessToken.setExpiresIn(resp.get("expires_in").toString());
				    
				} else {
					LOGGER.info("========================== Safaricom Basic Auth Failed ===== "+accessToken.toString());
				}
			 
		 }catch(Exception e) {
			 LOGGER.error(e.getMessage());
		 }
        return accessToken;
	 }

	 public Status InitiateMpesaC2B(AccessToken accessToken, String amount, String phoneNo, String commandID, String remarks) {
    	 Status          status       = new Status();
    	 MpesaC2BRequest c2bRquest    = new MpesaC2BRequest();
    	 RestTemplate    restTemplate = new RestTemplate();
         HttpHeaders headers = new HttpHeaders();
    	 try {
    		 
             headers.setContentType(MediaType.APPLICATION_JSON);
			 headers.set("Authorization", "Bearer "+accessToken.getAccessToken());
			 
		     Utils  utils = new Utils();
		     String phone = utils.sanitizePhoneNumber(phoneNo);
		     String timestamp = utils.getTimestamp();
		     String password = utils.getPassword(safaricomProperties.getBusiness_short_code(), safaricomProperties.getPasskey(), timestamp);

		     c2bRquest.setInitiatorName(safaricomProperties.getApp_key());
		     c2bRquest.setSecurityCredential(password);
		     c2bRquest.setCommandID("FinancialTransactions");
		     c2bRquest.setAmount(amount);
		     c2bRquest.setPartyA(safaricomProperties.getBusiness_short_code());
		     c2bRquest.setPartyB(phone);
		     c2bRquest.setRemarks("FinancialTransactions");
		     c2bRquest.setQueueTimeOutURL(safaricomProperties.getCall_url());
		     c2bRquest.setResultURL(safaricomProperties.getCall_url());
		     c2bRquest.setOccasion("");
			 
			 HttpEntity<MpesaC2BRequest> entity = new HttpEntity<MpesaC2BRequest>(c2bRquest, headers);
			 ResponseEntity<String> responseEntity = restTemplate.exchange
					                  (
					                   safaricomProperties.getBase_url()+"/mpesa/b2c/v1/paymentrequest", 
		                    		   HttpMethod.POST, 
		                               entity,
		                               String.class
			                          );
			 
			 if (responseEntity.getStatusCode() == HttpStatus.OK) {
				 
				@SuppressWarnings("unchecked")
				Map<String, Object> resp = new ObjectMapper().readValue(responseEntity.getBody(), HashMap.class);
				/*				
                   We can save this to database
				*/
				LOGGER.info("============================"+responseEntity.getBody());
				status.setSuccess("true");
				status.setMessage("MPESA B2C SUCCESSFUL");
				
			 }else {
				LOGGER.info("============================"+responseEntity.getBody());
				status.setSuccess("false");
				status.setMessage("MPESA B2C FAILED");
			 }
    		 
    	 }catch(Exception e) {
    		 LOGGER.error("============================"+e.getMessage());
    		 LOGGER.info("============================"+c2bRquest.toString());
				status.setSuccess("false");
				status.setMessage(e.getMessage());
    	 }
    	 return status;
     }
	 
}
