package com.example.myGlamm.model;

public class ResultarrayItem{
	private String date;
	private String summary;
	private String image;
	private int likestatus;
	private String description;
	private int total_views;
	private String id;
	private String title;
	private String pagelink;
	private int total_likes;
	private int status;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setLikestatus(int likestatus){
		this.likestatus = likestatus;
	}

	public int getLikestatus(){
		return likestatus;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTotalViews(int totalViews){
		this.total_likes = totalViews;
	}

	public int getTotalViews(){
		return total_likes;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setPagelink(String pagelink){
		this.pagelink = pagelink;
	}

	public String getPagelink(){
		return pagelink;
	}

	public void setTotalLikes(int totalLikes){
		this.total_views = totalLikes;
	}

	public int getTotalLikes(){
		return total_views;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResultarrayItem{" + 
			"date = '" + date + '\'' + 
			",summary = '" + summary + '\'' + 
			",image = '" + image + '\'' + 
			",likestatus = '" + likestatus + '\'' + 
			",description = '" + description + '\'' + 
			",total_views = '" + total_views + '\'' +
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",pagelink = '" + pagelink + '\'' + 
			",total_likes = '" + total_likes + '\'' +
			",status = '" + status + '\'' + 
			"}";
		}
}
