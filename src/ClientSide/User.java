/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientSide;

import DTOs.Movie;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class User
{

    private static int currentid = 1;
    private int id;
    private ArrayList<String> history;
    private ArrayList<Movie> historyResult;
    private ArrayList<Movie> movieWatch;
    public User()
    {
        this.id= currentid++;
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

}
