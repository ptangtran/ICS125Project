/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectmovie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author C0472359
 */
class MovieModel {
    private ArrayList<Movie> theMovies;
    private int movieCounter;
    private ArrayList<Movie> theMoviesAll;
    //step 7
    //private SortedSet<String> originCityList;
    private SortedSet<String> movieList;
    
   
    
    public MovieModel(){
        movieList = new TreeSet<>();
        movieCounter=0;
        theMovies=new ArrayList<>();
        
        String filename="M:\\125Sadness\\ICS125Project\\JavaApplication1\\src\\selectmovie\\movies.txt";
    try {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        
    while ((line = bufferedReader.readLine()) != null){
        String[] tokens = line.split(",", Movie.NUMBER_OF_CONTRACT_ATTRIBUTES);
        
        // String contractID = tokens[Contract.INDEX_OF_CONTRACT_ID];
        String movieName = tokens[Movie.INDEX_OF_MOVIE_NAME];
        String rate = tokens[Movie.INDEX_OF_RATING];
        String actors = tokens[Movie.INDEX_OF_ACTORS];
   
        //Contract dataContract = new Contract(contractID, originCity, destCity, orderItem);
        Movie dataMovie = new Movie(movieName, rate, actors);
        
        //originCityList.add(originCity);
        movieList.add(movieName);
        theMovies.add(dataMovie);
    }   //end while
    //step 8 
    movieList.add("All");
    //step 9 
    theMoviesAll = new ArrayList<>(theMovies);
    fileReader.close();
    }
    catch(IOException ex){
            System.out.println(ex.getMessage());
            }
    
    } //end of constructor 
    boolean foundMovies(){
        if(theMovies.size() >= 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    //public Contract getTheContract(){
    public Movie getTheMovie(){    
        //return theContracts.get(contractCounter);
        return theMovies.get(movieCounter);
    }
    //public int getMovieCount(){
    public int getMovieCount(){    
        return theMovies.size();
        //called in setupdisplay method
    }
    //called in setUpDisplay method
    public int getCurrentMoviesNum(){
        return movieCounter;
    }
    //public void nextContract(){
    public void nextMovie(){
        if (movieCounter + 1 <= theMovies.size()){
            movieCounter++;
        }
    }
    public void prevMovie(){
        if (movieCounter > 0){
            movieCounter--;
    }   
    }
    
    public String[] getMovieList(){
        String[] a;
        a= movieList.toArray(new String[movieList.size()]);
        return a;
    }
    //public void updateContractList(String city){
    public void updateMovieList(String movie){
        //theContracts = new ArrayList<>(theContractsAll);
        theMovies = new ArrayList<>(theMoviesAll);
        if (movie != "All") {
        //if (!movie.equals("All")){
            theMovies.removeIf(s -> !s.contains(movie));
        }
        // lynda suggestion 
        //System.out.print(city);
        movieCounter=0;
    }
  
}
