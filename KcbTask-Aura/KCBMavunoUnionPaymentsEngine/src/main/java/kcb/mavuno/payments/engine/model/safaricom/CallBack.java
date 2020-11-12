package kcb.mavuno.payments.engine.model.safaricom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CallBack {

	public String merchantRequestID;
	public String checkoutRequestID;
	public long resultCode;
	public String resultDesc;
	public CallbackMetadata callbackMetadata;

    @JsonProperty("MerchantRequestID")
    public String getMerchantRequestID() { return merchantRequestID; }
    @JsonProperty("MerchantRequestID")
    public void setMerchantRequestID(String value) { this.merchantRequestID = value; }

    @JsonProperty("CheckoutRequestID")
    public String getCheckoutRequestID() { return checkoutRequestID; }
    @JsonProperty("CheckoutRequestID")
    public void setCheckoutRequestID(String value) { this.checkoutRequestID = value; }

    @JsonProperty("ResultCode")
    public long getResultCode() { return resultCode; }
    @JsonProperty("ResultCode")
    public void setResultCode(long value) { this.resultCode = value; }

    @JsonProperty("ResultDesc")
    public String getResultDesc() { return resultDesc; }
    @JsonProperty("ResultDesc")
    public void setResultDesc(String value) { this.resultDesc = value; }

    @JsonProperty("CallbackMetadata")
    public CallbackMetadata getCallbackMetadata() { return callbackMetadata; }
    @JsonProperty("CallbackMetadata")
    public void setCallbackMetadata(CallbackMetadata value) { this.callbackMetadata = value; }
	
}
