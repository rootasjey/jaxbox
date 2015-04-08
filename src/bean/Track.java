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
@Table(name="tracks")
public class Track implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTrack")
	private int idTrack;

	@Column(name="idRecording")
	private String idRecording;
	
	@Column(name="title")
	private String title;
	
	@Column(name="artist_name")
	private String artist_name;
	
	@Column(name="artistId", nullable=true, length=50)
	private String artistId;

	@Column(name="length")
	private String length;
	
	@Column(name="release_title")
	private String release_title;
	
	@Column(name="release_status")
	private String release_status;
	
	@Column(name="release_date")
	private String release_date;
	
	@Column(name="release_contry")
	private String release_contry;
	
	@Column(name="image", nullable=true, length=200)
	private String image;
	
	@Column(name="url", nullable=true, length=200)
	private String url;
	
	@Column(name="listeners", nullable=true, length=30)
	private String listeners;
	
	@Column(name="score", nullable=true, length=30)
	private String score;
	
	
	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

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

	public String getListeners() {
		return listeners;
	}

	public void setListeners(String listeners) {
		this.listeners = listeners;
	}

	public int getIdTrack() {
		return idTrack;
	}

	public void setIdTrack(int idTrack) {
		this.idTrack = idTrack;
	}

	public String getIdRecording() {
		return idRecording;
	}

	public void setIdRecording(String idRecording) {
		this.idRecording = idRecording;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getRelease_title() {
		return release_title;
	}

	public void setRelease_title(String release_title) {
		this.release_title = release_title;
	}

	public String getRelease_status() {
		return release_status;
	}

	public void setRelease_status(String release_status) {
		this.release_status = release_status;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getRelease_contry() {
		return release_contry;
	}

	public void setRelease_contry(String release_contry) {
		this.release_contry = release_contry;
	}
	
	public String getArtist_name() {
		return artist_name;
	}

	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	public Track() {
		super();
	}

	@Override
	public String toString() {
		return "Track [idTrack=" + idTrack + ", idRecording=" + idRecording
				+ ", title=" + title + ", artist_name=" + artist_name
				+ ", artistId=" + artistId + ", length=" + length
				+ ", release_title=" + release_title + ", release_status="
				+ release_status + ", release_date=" + release_date
				+ ", release_contry=" + release_contry + ", image=" + image
				+ ", url=" + url + ", listeners=" + listeners + ", score="
				+ score + "]";
	}
	
}
