/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectmovie;
    

/**
 *
 * @author C0472359
 */
    //ALL NAMES HAVE BEEN CHANGED.
public class Movie {
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES=3;
    public static final int INDEX_OF_MOVIE_NAME=0;
    public static final int INDEX_OF_RATING=1;
    public static final int INDEX_OF_ACTORS=2;
    //public static final int INDEX_OF_ORDER_ITEM=3;
    String movieName;
     String rating;
     String actors;
     //String orderItem;
    //public Movie (String contractID, String originCity, String destCity, String orderItem){
    public Movie (String movieName, String rating, String actors){
        //this.contractID = contractID;
        this.movieName = movieName;
        this.rating = rating;
        this.actors = actors;
  
    }
    public String getMovieName(){
        //return contractID;
        return movieName;
    }
    public String getRating(){
        return rating;
    }
    public String getActors(){
        return actors;
    }

    
    //boolean contains(String city) {
        //if(city.equals(originCity)) {
    boolean contains(String movie) {
        if(movieName.equals(movie)) {
            return true;
        }
        else{
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
