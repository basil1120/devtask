package kcb.mavuno.payments.engine.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestPayload {
    private TransactionInfo transactionInfo;

    @JsonProperty("transactionInfo")
    public TransactionInfo getTransactionInfo() { return transactionInfo; }
    @JsonProperty("transactionInfo")
    public void setTransactionInfo(TransactionInfo value) { this.transactionInfo = value; }
}
