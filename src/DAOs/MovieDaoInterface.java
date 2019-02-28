/**
 * Feb 2019
 * UserDaoInterface
 *
 * Declares the methods that all UserDAO types must implement,
 * be they MySql User DAOs or Oracle User DAOs etc...
 *
 * Classes from the Business Layer (users of this DAO interface)
 * should use reference variables of this interface type to avoid
 * dependencies on the underlying concrete classes (e.g. MySqlUserDao).
 *
 * More sophistocated implementations will use a factory
 * method to instantiate the appropriate DAO concrete classes
 * by reading database configuration information from a
 * configuration file (that can be changed without altering source code)
 *
 * Interfaces are also useful when testing, as concrete classes
 * can be replaced by mock DAO objects.
 */
package Daos;

import DTOs.Movie;
import Exceptions.DaoException;
import java.util.List;

public interface MovieDaoInterface
{

    public List<Movie> findAllMovies() throws DaoException;

    public List<Movie> findMoviesGenre(String genre) throws DaoException;

    public Movie getMovieByName(String name) throws DaoException;

    public List<Movie> getMovieByDirector(String name) throws DaoException;
    
    public List<Movie> getMovieByRating(String rating) throws DaoException;
    
    public List<Movie> getMovieByUserRating(double user_rating) throws DaoException;
    
    public Movie getMovieByBarCode(String barcode) throws DaoException;
    
    public Movie getMovieById(int id) throws DaoException;
    
    public List<Movie> getMovieByStarring(String starring) throws DaoException;
    
    public List<Movie> getMovieByRunTime(int runtime) throws DaoException;
    
    public boolean addMovie();
    
    public boolean updateMovie(int id,String field,String value);
    
    public boolean deleteMovie(int id); 
}
