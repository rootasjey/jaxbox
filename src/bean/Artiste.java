package bean;

import java.io.Serializable;
import java.util.Date;

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
	@Column(name="idArtiste")
	private int idArtiste;
	@Column(name="nomArtiste", nullable=false, length=30)
	private String nomArtiste;
	@Column(name="prenomArtiste", nullable=false, length=30)
	private String prenomArtiste;
	@Column(name="paysArtiste", nullable=false, length=30)
	private String paysArtiste;

	public int getIdArtiste() {
		return idArtiste;
	}
	public void setIdArtiste(int idArtiste) {
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
	
//	@Override
//	public String toString() {
//		return "Artiste [idArtiste=" + idArtiste + ", nomArtiste=" + nomArtiste
//				+ ", prenomArtiste=" + prenomArtiste + ", sexeArtiste="
//				+ sexeArtiste + ", aliasArtiste=" + aliasArtiste
//				+ ", paysArtiste=" + paysArtiste + ", DateNaissArtiste="
//				+ DateNaissArtiste + ", estEnActivite=" + estEnActivite
//				+ ", tagDescription=" + tagDescription + "]";
//	}
	public Artiste() {
		super();
	}
	
	
}
