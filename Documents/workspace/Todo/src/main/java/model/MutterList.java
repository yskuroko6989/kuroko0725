package model;

public class MutterList {

	private String id;
	private String text;
	private String date;

	public MutterList() {}

	public MutterList(String text, String date) {
		super();
		this.text = text;
		this.date = date;
	}



	public MutterList(String id, String text, String date) {
		super();
		this.id = id;
		this.text = text;
		this.date = date;
	}



	public String getText() {
		return text;
	}

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}



}
