package com.example.myGlamm.model.search;


import com.google.gson.annotations.SerializedName;


public class TypesItem{

	@SerializedName("color")
	private String color;

	@SerializedName("name")
	private String name;

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"TypesItem{" + 
			"color = '" + color + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}