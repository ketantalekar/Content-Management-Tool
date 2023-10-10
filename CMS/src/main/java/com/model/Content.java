package com.model;

import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.*;


@Entity
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
	@Lob
	@Column(name="image", columnDefinition = "longblob")
	private Blob image;
	private String ctitle;
	private String cdescription;
	
	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Content(int cid, Blob image, String ctitle, String cdescription) {
		super();
		this.cid = cid;
		this.image = image;
		this.ctitle = ctitle;
		this.cdescription = cdescription;
	}

	public int getcId() {
		return cid;
	}

	public void setcId(int cid) {
		this.cid = cid;
	}
	
	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCdescription() {
		return cdescription;
	}

	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}

	@Override
	public String toString() {
		return "Content [id=" + cid + ", ctitle=" + ctitle + ", cdescription="
				+ cdescription + "]";
	}
	
	
}
