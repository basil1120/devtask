package kcb.mavuno.payments.engine.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Header {
	private String messageID;
    private String featureCode;
    private String featureName;
    private String serviceCode;
    private String serviceName;
    private String serviceSubCategory;
    private String minorServiceVersion;
    private String channelCode;
    private String channelName;
    private String routeCode;
    private String timeStamp;
    private String serviceMode;
    private String subscribeEvents;
    private String callBackURL;

    @JsonProperty("messageID")
    public String getMessageID() { return messageID; }
    @JsonProperty("messageID")
    public void setMessageID(String value) { this.messageID = value; }

    @JsonProperty("featureCode")
    public String getFeatureCode() { return featureCode; }
    @JsonProperty("featureCode")
    public void setFeatureCode(String value) { this.featureCode = value; }

    @JsonProperty("featureName")
    public String getFeatureName() { return featureName; }
    @JsonProperty("featureName")
    public void setFeatureName(String value) { this.featureName = value; }

    @JsonProperty("serviceCode")
    public String getServiceCode() { return serviceCode; }
    @JsonProperty("serviceCode")
    public void setServiceCode(String value) { this.serviceCode = value; }

    @JsonProperty("serviceName")
    public String getServiceName() { return serviceName; }
    @JsonProperty("serviceName")
    public void setServiceName(String value) { this.serviceName = value; }

    @JsonProperty("serviceSubCategory")
    public String getServiceSubCategory() { return serviceSubCategory; }
    @JsonProperty("serviceSubCategory")
    public void setServiceSubCategory(String value) { this.serviceSubCategory = value; }

    @JsonProperty("minorServiceVersion")
    public String getMinorServiceVersion() { return minorServiceVersion; }
    @JsonProperty("minorServiceVersion")
    public void setMinorServiceVersion(String value) { this.minorServiceVersion = value; }

    @JsonProperty("channelCode")
    public String getChannelCode() { return channelCode; }
    @JsonProperty("channelCode")
    public void setChannelCode(String value) { this.channelCode = value; }

    @JsonProperty("channelName")
    public String getChannelName() { return channelName; }
    @JsonProperty("channelName")
    public void setChannelName(String value) { this.channelName = value; }

    @JsonProperty("routeCode")
    public String getRouteCode() { return routeCode; }
    @JsonProperty("routeCode")
    public void setRouteCode(String value) { this.routeCode = value; }

    @JsonProperty("timeStamp")
    public String getTimeStamp() { return timeStamp; }
    @JsonProperty("timeStamp")
    public void setTimeStamp(String value) { this.timeStamp = value; }

    @JsonProperty("serviceMode")
    public String getServiceMode() { return serviceMode; }
    @JsonProperty("serviceMode")
    public void setServiceMode(String value) { this.serviceMode = value; }

    @JsonProperty("subscribeEvents")
    public String getSubscribeEvents() { return subscribeEvents; }
    @JsonProperty("subscribeEvents")
    public void setSubscribeEvents(String value) { this.subscribeEvents = value; }

    @JsonProperty("callBackURL")
    public String getCallBackURL() { return callBackURL; }
    @JsonProperty("callBackURL")
    public void setCallBackURL(String value) { this.callBackURL = value; }
}
