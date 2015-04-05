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
	
	@Column(name="tracks", nullable=true, length=5)
	private int tracks;
	
	@Column(name="url", nullable=true, length=200)
	private String url;
	
	@Column(name="image", nullable=true, length=200)
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getTracks() {
		return tracks;
	}
	public void setTracks(int tracks) {
		this.tracks = tracks;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	@Column(name="score", nullable=true, length=50)
	private String score;
	
	
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
	@Override
	public String toString() {
		return "Album [identifiantAlb=" + identifiantAlb + ", idAlbum="
				+ idAlbum + ", titreAlbum=" + titreAlbum + ", artisteAlbum="
				+ artisteAlbum + ", idArtisteAlbum=" + idArtisteAlbum
				+ ", codebareAlbum=" + codebareAlbum + ", commentAlbum="
				+ commentAlbum + ", tracks=" + tracks + ", url=" + url
				+ ", image=" + image + ", score=" + score + "]";
	}
	
}
