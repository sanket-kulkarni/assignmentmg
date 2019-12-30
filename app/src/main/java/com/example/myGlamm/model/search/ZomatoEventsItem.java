package com.example.myGlamm.model.search;


import com.google.gson.annotations.SerializedName;


public class ZomatoEventsItem{

	@SerializedName("event")
	private Event event;

	public void setEvent(Event event){
		this.event = event;
	}

	public Event getEvent(){
		return event;
	}

	@Override
 	public String toString(){
		return 
			"ZomatoEventsItem{" + 
			"event = '" + event + '\'' + 
			"}";
		}
}