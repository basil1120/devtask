package kcb.mavuno.payments.engine.model.safaricom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CallBackRequest {

    private Body body;

    @JsonProperty("Body")
    public Body getBody() { return body; }
    @JsonProperty("Body")
    public void setBody(Body value) { this.body = value; }
	
}
