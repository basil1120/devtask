package kcb.mavuno.payments.engine.entities;

import com.fasterxml.jackson.annotation.*;

public class Response {
    private ResponseHeader header;
    private ResponsePayload responsePayload;

    @JsonProperty("header")
    public ResponseHeader getHeader() { return header; }
    @JsonProperty("header")
    public void setResponseHeader(ResponseHeader value) { this.header = value; }

    @JsonProperty("responsePayload")
    public ResponsePayload getResponsePayload() { return responsePayload; }
    @JsonProperty("responsePayload")
    public void setResponsePayload(ResponsePayload value) { this.responsePayload = value; }
}
