package kcb.mavuno.payments.engine.model.safaricom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

	private String name;
    private String value;

    @JsonProperty("Name")
    public String getName() { return name; }
    @JsonProperty("Name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("Value")
    public String getValue() { return value; }
    @JsonProperty("Value")
    public void setValue(String value) { this.value = value; }
	
}
