package com.example.hellomusic;

import java.io.Serializable;

import android.os.Parcelable;

public class Song implements Serializable{
	 private long id;
	    private String title;
	    private String artist;
		public Song(long thisId, String thisTitle, String thisArtist) {
			id=thisId;
			title=thisTitle;
			artist=thisArtist;
			
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getArtist() {
			return artist;
		}
		public void setArtist(String artist) {
			this.artist = artist;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return title;
		}
}
