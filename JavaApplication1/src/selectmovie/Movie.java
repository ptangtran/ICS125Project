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
public class Movie {
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES=3;
    public static final int INDEX_OF_MOVIE_NAME=0;
    public static final int INDEX_OF_RATE=1;
    public static final int INDEX_OF_ACTORS=2;
    //public static final int INDEX_OF_ORDER_ITEM=3;
    String movieName;
     String rate;
     String actors;
     //String orderItem;
    //public Movie (String contractID, String originCity, String destCity, String orderItem){
    public Movie (String movieName, String rate, String actors){
        //this.contractID = contractID;
        this.movieName = movieName;

        this.rate = rate;
        this.actors = actors;
  
    }
    public String getContractID(){
        return contractID;
    }
    public String getOriginCity(){
        return originCity;
    }
    public String getDestCity(){
        return destCity;
    }
    public String getOrderItem(){
        return orderItem;
    }

    boolean contains(String city) {
        if(city.equals(originCity)) {
            return true;
        }
        else{
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
