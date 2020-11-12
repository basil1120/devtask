package kcb.mavuno.payments.engine.entities;

import com.fasterxml.jackson.annotation.*;

public class ResponsePayload {
    private ResponseTransactionInfo transactionInfo;

    @JsonProperty("transactionInfo")
    public ResponseTransactionInfo getTransactionInfo() { return transactionInfo; }
    @JsonProperty("transactionInfo")
    public void setResponseTransactionInfo(ResponseTransactionInfo value) { this.transactionInfo = value; }
}
