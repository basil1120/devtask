package kcb.mavuno.payments.engine.entities;

import com.fasterxml.jackson.annotation.*;
public class TransactionInfo {
	private String companyCode;
    private String transactionType;
    private String creditAccountNumber;
    private String credintMobileNumber;
    private String transactionAmount;
    private String transactionReference;
    private String currencyCode;
    private String amountCurrency;
    private String dateTime;
    private String dateString;

    @JsonProperty("companyCode")
    public String getCompanyCode() { return companyCode; }
    @JsonProperty("companyCode")
    public void setCompanyCode(String value) { this.companyCode = value; }

    @JsonProperty("transactionType")
    public String getTransactionType() { return transactionType; }
    @JsonProperty("transactionType")
    public void setTransactionType(String value) { this.transactionType = value; }

    @JsonProperty("creditAccountNumber")
    public String getCreditAccountNumber() { return creditAccountNumber; }
    @JsonProperty("creditAccountNumber")
    public void setCreditAccountNumber(String value) { this.creditAccountNumber = value; }

    @JsonProperty("credintMobileNumber")
    public String getCredintMobileNumber() { return credintMobileNumber; }
    @JsonProperty("credintMobileNumber")
    public void setCredintMobileNumber(String value) { this.credintMobileNumber = value; }

    @JsonProperty("transactionAmount")
    public String getTransactionAmount() { return transactionAmount; }
    @JsonProperty("transactionAmount")
    public void setTransactionAmount(String value) { this.transactionAmount = value; }

    @JsonProperty("transactionReference")
    public String getTransactionReference() { return transactionReference; }
    @JsonProperty("transactionReference")
    public void setTransactionReference(String value) { this.transactionReference = value; }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() { return currencyCode; }
    @JsonProperty("currencyCode")
    public void setCurrencyCode(String value) { this.currencyCode = value; }

    @JsonProperty("amountCurrency")
    public String getAmountCurrency() { return amountCurrency; }
    @JsonProperty("amountCurrency")
    public void setAmountCurrency(String value) { this.amountCurrency = value; }

    @JsonProperty("dateTime")
    public String getDateTime() { return dateTime; }
    @JsonProperty("dateTime")
    public void setDateTime(String value) { this.dateTime = value; }

    @JsonProperty("dateString")
    public String getDateString() { return dateString; }
    @JsonProperty("dateString")
    public void setDateString(String value) { this.dateString = value; }
}
