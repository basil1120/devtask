package kcb.mavuno.payments.engine.entities;

import com.fasterxml.jackson.annotation.*;
public class ResponseHeader {
	 private String messageID;
	    private String conversationID;
	    private String targetSystemID;
	    private String routeCode;
	    private String statusCode;
	    private String statusDescription;
	    private String statusMessage;

	    @JsonProperty("messageID")
	    public String getMessageID() { return messageID; }
	    @JsonProperty("messageID")
	    public void setMessageID(String value) { this.messageID = value; }

	    @JsonProperty("conversationID")
	    public String getConversationID() { return conversationID; }
	    @JsonProperty("conversationID")
	    public void setConversationID(String value) { this.conversationID = value; }

	    @JsonProperty("targetSystemID")
	    public String getTargetSystemID() { return targetSystemID; }
	    @JsonProperty("targetSystemID")
	    public void setTargetSystemID(String value) { this.targetSystemID = value; }

	    @JsonProperty("routeCode")
	    public String getRouteCode() { return routeCode; }
	    @JsonProperty("routeCode")
	    public void setRouteCode(String value) { this.routeCode = value; }

	    @JsonProperty("statusCode")
	    public String getStatusCode() { return statusCode; }
	    @JsonProperty("statusCode")
	    public void setStatusCode(String value) { this.statusCode = value; }

	    @JsonProperty("statusDescription")
	    public String getStatusDescription() { return statusDescription; }
	    @JsonProperty("statusDescription")
	    public void setStatusDescription(String value) { this.statusDescription = value; }

	    @JsonProperty("statusMessage")
	    public String getStatusMessage() { return statusMessage; }
	    @JsonProperty("statusMessage")
	    public void setStatusMessage(String value) { this.statusMessage = value; }
}
