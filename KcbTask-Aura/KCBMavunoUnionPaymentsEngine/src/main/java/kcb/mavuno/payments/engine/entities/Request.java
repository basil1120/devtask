package kcb.mavuno.payments.engine.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Request {

	private Header header;
    private RequestPayload requestPayload;

    @JsonProperty("header")
    public Header getHeader() { return header; }
    @JsonProperty("header")
    public void setHeader(Header value) { this.header = value; }

    @JsonProperty("requestPayload")
    public RequestPayload getRequestPayload() { return requestPayload; }
    @JsonProperty("requestPayload")
    public void setRequestPayload(RequestPayload value) { this.requestPayload = value; }
	
}
