package bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="albums")
public class Album implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="identifiantAlb")
	private int identifiantAlb;
	
	@Column(name="idAlbum", nullable=true, length=50)
	private String idAlbum;
	
	@Column(name="titreAlbum", nullable=true, length=50)
	private String titreAlbum;
	
	@Column(name="artisteAlbum", nullable=true, length=50)
	private String artisteAlbum;
	
	@Column(name="idArtisteAlbum", nullable=true, length=50)
	private String idArtisteAlbum;
	
	@Column(name="codebareAlbum", nullable=true, length=50)
	private String codebareAlbum;
	
	@Column(name="commentAlbum", nullable=true, length=50)
	private String commentAlbum;
	
	public String getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(String idAlbum) {
		this.idAlbum = idAlbum;
	}
	public String getTitreAlbum() {
		return titreAlbum;
	}
	public void setTitreAlbum(String titreAlbum) {
		this.titreAlbum = titreAlbum;
	}
	public String getArtisteAlbum() {
		return artisteAlbum;
	}
	public void setArtisteAlbum(String artisteAlbum) {
		this.artisteAlbum = artisteAlbum;
	}
	public Album() {
		super();
	}
	
	public String getIdArtisteAlbum() {
		return idArtisteAlbum;
	}
	public void setIdArtisteAlbum(String idArtisteAlbum) {
		this.idArtisteAlbum = idArtisteAlbum;
	}
	public String getCodebareAlbum() {
		return codebareAlbum;
	}
	public void setCodebareAlbum(String codebareAlbum) {
		this.codebareAlbum = codebareAlbum;
	}
	public String getCommentAlbum() {
		return commentAlbum;
	}
	public void setCommentAlbum(String commentAlbum) {
		this.commentAlbum = commentAlbum;
	}
	
}
