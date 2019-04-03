package com.molveno.molveno.chillflix.category;

import com.molveno.molveno.chillflix.movie.Movie;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(name = "categorymovies",
            joinColumns = {@JoinColumn(name = "categoryid")},
            inverseJoinColumns = {@JoinColumn(name = "movieid")})
    private List<Movie> movies;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
