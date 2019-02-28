package DTOs;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * Feb 2019
 *
 * This POJO (Plain Old Java Object) is called the Data Transfer Object (DTO).
 * (or, alternatively, the Model Object or the Value Object). It is used to
 * transfer data between the DAO and the Business Objects. Here, it represents a
 * row of data from the User database table. The DAO fills a User object (DTO)
 * with data retrieved from the resultSet and passes the User object to the
 * Business Layer. Collections of DTOs( e.g. ArrayList<User> ) may also be
 * passed between the Data Access Layer (DAOs) and the Business Layer objects.
 */
public class Movie
{

    private int id;
    private String title;
    private String genre;
    private String director;
    private String runtime;
    private String plot;
    private String rating;
    private String format;
    private int year;
    private String starring;
    private String barcode;
    private String user_rating;

    public Movie()
    {
    }

    public Movie(int id, String title, String genre, String director, String runtime, String plot, String rating, String format, int year, String starring, String barcode, String user_rating)
    {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.runtime = runtime;
        this.plot = plot;
        this.rating = rating;
        this.format = format;
        this.year = year;
        this.starring = starring;
        this.barcode = barcode;
        this.user_rating = user_rating;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Get the value of genre
     *
     * @return the value of genre
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Set the value of genre
     *
     * @param genre new value of genre
     */
    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    /**
     * Get the value of director
     *
     * @return the value of director
     */
    public String getDirector()
    {
        return director;
    }

    /**
     * Set the value of director
     *
     * @param director new value of director
     */
    public void setDirector(String director)
    {
        this.director = director;
    }

    /**
     * Get the value of runtime
     *
     * @return the value of runtime
     */
    public String getRuntime()
    {
        return runtime;
    }

    /**
     * Set the value of runtime
     *
     * @param runtime new value of runtime
     */
    public void setRuntime(String runtime)
    {
        this.runtime = runtime;
    }

    /**
     * Get the value of plot
     *
     * @return the value of plot
     */
    public String getPlot()
    {
        return plot;
    }

    /**
     * Set the value of plot
     *
     * @param plot new value of plot
     */
    public void setPlot(String plot)
    {
        this.plot = plot;
    }

    /**
     * Get the value of user_rating
     *
     * @return the value of user_rating
     */
    public String getUser_rating()
    {
        return user_rating;
    }

    /**
     * Set the value of user_rating
     *
     * @param user_rating new value of user_rating
     */
    public void setUser_rating(String user_rating)
    {
        this.user_rating = user_rating;
    }

    /**
     * Get the value of rating
     *
     * @return the value of rating
     */
    public String getRating()
    {
        return rating;
    }

    /**
     * Set the value of rating
     *
     * @param rating new value of rating
     */
    public void setRating(String rating)
    {
        this.rating = rating;
    }

    /**
     * Get the value of format
     *
     * @return the value of format
     */
    public String getFormat()
    {
        return format;
    }

    /**
     * Set the value of format
     *
     * @param format new value of format
     */
    public void setFormat(String format)
    {
        this.format = format;
    }

    /**
     * Get the value of year
     *
     * @return the value of year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Set the value of year
     *
     * @param year new value of year
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * Get the value of starring
     *
     * @return the value of starring
     */
    public String getStarring()
    {
        return starring;
    }

    /**
     * Set the value of starring
     *
     * @param starring new value of starring
     */
    public void setStarring(String starring)
    {
        this.starring = starring;
    }

    /**
     * Get the value of barcode
     *
     * @return the value of barcode
     */
    public String getBarcode()
    {
        return barcode;
    }

    /**
     * Set the value of barcode
     *
     * @param barcode new value of barcode
     */
    public void setBarcode(String barcode)
    {
        this.barcode = barcode;
    }

//    @Override
//    public String toString()
//    {
//        return "Movie{" + "id=" + id + ", title=" + title + ", genre=" + genre + ", director=" + director + ", runtime=" + runtime + ", plot=" + plot + ", rating=" + rating + ", format=" + format + ", year=" + year + ", starring=" + starring + ", barcode=" + barcode + ", user_rating=" + user_rating + '}';
//    }
//    @Override
//    public String toString()
//    {
//        return "{" + "\"id\":\"" + id + "\",\"title\":\"" + title + "\",\"genre\":\"" + genre + "\",\"director\":\"" + director + "\",\"runtime\":\"" + runtime + "\",\"plot\":\"" + plot + "\",\"rating\":\"" + rating + "\",\"format\":\"" + format + "\",\"year\":\"" + year + "\",\"starring\":\"" + starring + "\",\"barcode\":\"" + barcode + "\",\"user_rating\":\"" + user_rating + "\"}";
//    }
    @Override
    public String toString()
    {
        String genrearray = "[\"" + genre.replace(", ", "\",\"") + "\"]";
        String starringarray = "[\"" + starring.replace(", ", "\",\"") + "\"]";
        String plotModi = plot.replace("\"", "'");
        plotModi = plotModi.replace("\r\n", "");
        String json = "{"
                + "\"id\":" + id
                + ",\"title\":\"" + title
                + "\",\"genre\":" + genrearray
                + ",\"director\":\"" + director
                + "\",\"runtime\":\"" + runtime
                + "\",\"plot\":\"" + plotModi
                + "\",\"rating\":\"" + rating
                + "\",\"format\":\"" + format
                + "\",\"year\":" + year
                + ",\"starring\":" + starringarray
                + ",\"barcode\":\"" + barcode
                + "\",\"user_rating\":\"" + user_rating
                + "\"}";
        return json;
    }

    public JsonObject toJsonObject()
    {
        String json = this.toString();
        StringReader reader = new StringReader(json);
        JsonReader reader2 = Json.createReader(reader);
        JsonObject object = reader2.readObject();
        return object;
    }

}
