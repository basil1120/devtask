package kcb.mavuno.payments.engine.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kcb.mavuno.payments.engine.model.safaricom.*;



@RestController
@RequestMapping("/api/v1")
public class CallBackController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(CallBackController.class);

	
	 @PostMapping("/mpesa/callback")
	 public Status mpesaCallBack(@RequestBody CallBackRequest callBack) {
		  LOGGER.info("================================= Entered StkCallBack Controller ==========================");
		  Status status = new Status();
		  if(callBack.getBody() != null) {
			  
			  Body body = new Body();
			  CallBack stkCallBack = new CallBack();
			  CallbackMetadata callBackMetaData = new CallbackMetadata();
			  Item  item  [] = null;
			  
			  String MerchantRequestID;
			  String CheckoutRequestID;
			  Long   ResultCode;
			  String ResultDesc;
			  String MpesaReceiptNumber=null;
			  String Amount      = null;
			  String PhoneNumber = null;
			  String FullName    = null;
			  String Balance     = null;
			  String TransactionDate = null;
			  String TransactionStatus = "0";
			  
			  body              = callBack.getBody();
			  stkCallBack       = body.getStkCallback();
			  callBackMetaData   = stkCallBack.getCallbackMetadata();
			  MerchantRequestID  = stkCallBack.getMerchantRequestID();
			  CheckoutRequestID  = stkCallBack.getCheckoutRequestID();
			  ResultCode         = stkCallBack.getResultCode();
			  ResultDesc         = stkCallBack.getResultDesc();

			  if(ResultCode == 0 ) {

				  item = callBackMetaData.getItem();
				  HashMap<String, String> map = new HashMap<String, String>();
				  for(int i=0; i < item.length; i++) {
					  
					  map.put(item[i].getName(), item[i].getValue());
				  }		  
				  MpesaReceiptNumber = map.get("MpesaReceiptNumber");
				  Amount             = map.get("Amount");
				  PhoneNumber        = map.get("PhoneNumber");
				  Balance            = map.get("Balance");
				  TransactionDate    = map.get("TransactionDate");
			  }

			  /*
			  MpesaStkCallBack mpesa = new MpesaStkCallBack();
			  
			  mpesa.setAmount(Amount);
			  mpesa.setBalance(Balance);
			  mpesa.setCheckoutRequestID(CheckoutRequestID);
			  mpesa.setFullName(FullName);
			  mpesa.setMerchantRequestID(MerchantRequestID);
			  mpesa.setMpesaReceiptNumber(MpesaReceiptNumber);
			  mpesa.setPayLoad(stk.getBody().toString());
			  mpesa.setPhoneNumber(PhoneNumber);
			  mpesa.setResultCode(ResultCode.toString());
			  mpesa.setResultDesc(ResultDesc);
			  mpesa.setTransactionDate(TransactionDate);
			  mpesaStkCallBackRepository.save(mpesa);
			  
              List<MpesaTransactions> trans = mpesaTransactionsRepository.findBycheckoutrequestid(mpesa.getCheckoutRequestID());
	
			  if( trans != null && !trans.isEmpty() && trans.size() > 0 ) {
				  
				  MpesaTransactions transactions = new MpesaTransactions();
				  transactions = trans.get(0);
				  if(ResultCode == 0) { TransactionStatus ="1"; }
				  
				  transactions.setAmount(Amount);
				  transactions.setPhonenumber(PhoneNumber);
				  transactions.setMpesareceiptnumber(MpesaReceiptNumber);
				  transactions.setTransactionstatus(TransactionStatus);
				  
				  mpesaTransactionsRepository.save(transactions);
				  
			  }
			  */

			  status.setSuccess("true");
			  status.setMessage("CallBack Received successful");
			  
		  }else {
			  status.setSuccess("false");
			  status.setMessage("CallBack Err");
		  }
		  return status;
	 }

}
