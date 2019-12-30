package com.example.myGlamm.model;

import java.util.List;

public class ResponseData {
	private List<Item> resultarray;
	private String date;

	public ResponseData(String date,List<Item> resultarray){
		this.date=date;
		this.resultarray=resultarray;
	}

	public void setResultarray(List<Item> resultarray){
		this.resultarray = resultarray;
	}

	public List<Item> getResultarray(){
		return resultarray;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	@Override
 	public String toString(){
		return 
			"ResponseData{" +
			"resultarray = '" + resultarray + '\'' + 
			",date = '" + date + '\'' +
			"}";
		}
}