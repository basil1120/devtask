package kcb.mavuno.payments.engine.model.safaricom;

public class MpesaC2BRequest {
	
	
	public String InitiatorName;
	public String SecurityCredential;
	public String CommandID;
	public String Amount;
	public String PartyA;
	public String PartyB;
	public String Remarks;
	public String QueueTimeOutURL;
	public String ResultURL;
	public String Occasion;
	
	public String getInitiatorName() {
		return InitiatorName;
	}
	public void setInitiatorName(String initiatorName) {
		InitiatorName = initiatorName;
	}
	public String getSecurityCredential() {
		return SecurityCredential;
	}
	public void setSecurityCredential(String securityCredential) {
		SecurityCredential = securityCredential;
	}
	public String getCommandID() {
		return CommandID;
	}
	public void setCommandID(String commandID) {
		CommandID = commandID;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getPartyA() {
		return PartyA;
	}
	public void setPartyA(String partyA) {
		PartyA = partyA;
	}
	public String getPartyB() {
		return PartyB;
	}
	public void setPartyB(String partyB) {
		PartyB = partyB;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public String getQueueTimeOutURL() {
		return QueueTimeOutURL;
	}
	public void setQueueTimeOutURL(String queueTimeOutURL) {
		QueueTimeOutURL = queueTimeOutURL;
	}
	public String getResultURL() {
		return ResultURL;
	}
	public void setResultURL(String resultURL) {
		ResultURL = resultURL;
	}
	public String getOccasion() {
		return Occasion;
	}
	public void setOccasion(String occasion) {
		Occasion = occasion;
	}
	
	
}
