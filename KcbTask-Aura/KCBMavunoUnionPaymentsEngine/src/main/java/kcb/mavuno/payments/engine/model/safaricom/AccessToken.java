package kcb.mavuno.payments.engine.model.safaricom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessToken {

	private String access_token;
    private String expires_in;

    @JsonProperty("access_token")
    public String getAccessToken() { return access_token; }
    @JsonProperty("access_token")
    public void setAccessToken(String access_token) { this.access_token = access_token; }

    @JsonProperty("expires_in")
    public String getExpiresIn() { return expires_in; }
    @JsonProperty("expires_in")
    public void setExpiresIn(String expires_in) { this.expires_in = expires_in; }
	
}
