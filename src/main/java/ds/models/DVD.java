package ds.models;

public class DVD {
    String name;
    int releaseYear;
    String director;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public DVD(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "movie name '" + name + '\'' +
                ", released in Year " + releaseYear +
                ", directed by director '" + director + '\'' +
                '}';
    }
}
