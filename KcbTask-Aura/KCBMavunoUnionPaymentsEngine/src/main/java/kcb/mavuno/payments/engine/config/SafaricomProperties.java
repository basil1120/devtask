package kcb.mavuno.payments.engine.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "safaricom")
public class SafaricomProperties {

    public String base_url;

    public String call_url;
    
    public String passkey;
    
    public String business_short_code;
    
    public String app_key;
    
    public String app_secret;
    
    public String subscription_daily;
    
    public String subscription_weekly;
    
    public String subscription_monthly;
    
    public String subscription_annually;

	public String getBase_url() {
		return base_url;
	}

	public void setBase_url(String base_url) {
		this.base_url = base_url;
	}

	public String getCall_url() {
		return call_url;
	}

	public void setCall_url(String call_url) {
		this.call_url = call_url;
	}

	public String getPasskey() {
		return passkey;
	}

	public void setPasskey(String passkey) {
		this.passkey = passkey;
	}

	public String getBusiness_short_code() {
		return business_short_code;
	}

	public void setBusiness_short_code(String business_short_code) {
		this.business_short_code = business_short_code;
	}

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	public String getApp_secret() {
		return app_secret;
	}

	public void setApp_secret(String app_secret) {
		this.app_secret = app_secret;
	}
   
	public String getSubscription_daily() {
		return subscription_daily;
	}

	public void setSubscription_daily(String subscription_daily) {
		this.subscription_daily = subscription_daily;
	}

	public String getSubscription_weekly() {
		return subscription_weekly;
	}

	public void setSubscription_weekly(String subscription_weekly) {
		this.subscription_weekly = subscription_weekly;
	}

	public String getSubscription_monthly() {
		return subscription_monthly;
	}

	public void setSubscription_monthly(String subscription_monthly) {
		this.subscription_monthly = subscription_monthly;
	}

	public String getSubscription_annually() {
		return subscription_annually;
	}

	public void setSubscription_annually(String subscription_annually) {
		this.subscription_annually = subscription_annually;
	}

}
