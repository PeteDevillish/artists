package pl.artists;

import javax.persistence.*;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    private Artist artist;

    public Album(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    public Album() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }
}
