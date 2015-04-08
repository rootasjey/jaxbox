package bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artistes")
public class Artiste implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="identifiantArt")
	private int identifiantArt;
	
	@Column(name="idArtiste")
	private String idArtiste;
	
	@Column(name="nomArtiste", nullable=true, length=30)
	private String nomArtiste;
	
	@Column(name="prenomArtiste", nullable=true, length=30)
	private String prenomArtiste;
	
	@Column(name="paysArtiste", nullable=true, length=30)
	private String paysArtiste;
	
	@Column(name="url", nullable=true, length=200)
	private String url;
	
	@Column(name="image", nullable=true, length=200)
	private String image;
	
	@Column(name="score", nullable=true, length=50)
	private String score;
	
	@Column(name="description", nullable=true, length=200)
	private String description;
	
	@Column(name="listeners", nullable=true, length=30)
	private String listeners;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getListeners() {
		return listeners;
	}
	public void setListeners(String listeners) {
		this.listeners = listeners;
	}

	public String getIdArtiste() {
		return idArtiste;
	}
	public void setIdArtiste(String idArtiste) {
		this.idArtiste = idArtiste;
	}
	public String getNomArtiste() {
		return nomArtiste;
	}
	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}
	public String getPrenomArtiste() {
		return prenomArtiste;
	}
	public void setPrenomArtiste(String prenomArtiste) {
		this.prenomArtiste = prenomArtiste;
	}
	public String getPaysArtiste() {
		return paysArtiste;
	}
	public void setPaysArtiste(String paysArtiste) {
		this.paysArtiste = paysArtiste;
	}
	public Artiste() {
		super();
	}
	public int getIdentifiantArt() {
		return identifiantArt;
	}
	public void setIdentifiantArt(int identifiantArt) {
		this.identifiantArt = identifiantArt;
	}
	@Override
	public String toString() {
		return "Artiste [identifiantArt=" + identifiantArt + ", idArtiste="
				+ idArtiste + ", nomArtiste=" + nomArtiste + ", prenomArtiste="
				+ prenomArtiste + ", paysArtiste=" + paysArtiste + "]";
	}
	
	
}
