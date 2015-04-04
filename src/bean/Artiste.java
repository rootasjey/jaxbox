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
