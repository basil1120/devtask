package kcb.mavuno.payments.engine.model.safaricom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CallbackMetadata {
	
	public Item[] item;

    @JsonProperty("Item")
    public Item[] getItem() { return item; }
    @JsonProperty("Item")
    public void setItem(Item[] value) { this.item = value; }
    
}

