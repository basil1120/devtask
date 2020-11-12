package kcb.mavuno.payments.engine.model.safaricom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Body {
	private CallBack stkCallback;

    @JsonProperty("stkCallback")
    public CallBack getStkCallback() { return stkCallback; }
    @JsonProperty("stkCallback")
    public void setStkCallback(CallBack value) { this.stkCallback = value; }
}
