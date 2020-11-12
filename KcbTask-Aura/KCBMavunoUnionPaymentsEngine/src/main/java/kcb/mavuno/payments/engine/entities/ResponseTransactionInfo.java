package kcb.mavuno.payments.engine.entities;

import com.fasterxml.jackson.annotation.*;

public class ResponseTransactionInfo {
    private String transactionID;
    private String falconBalance;

    @JsonProperty("transactionId")
    public String getTransactionID() { return transactionID; }
    @JsonProperty("transactionId")
    public void setTransactionID(String value) { this.transactionID = value; }

    @JsonProperty("falconBalance")
    public String getFalconBalance() { return falconBalance; }
    @JsonProperty("falconBalance")
    public void setFalconBalance(String value) { this.falconBalance = value; }
}
