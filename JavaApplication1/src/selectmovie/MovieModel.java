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
    private ArrayList<Movie> theContracts;
    private int contractCounter;
    private ArrayList<Movie> theContractsAll;
    //step 7
    //private SortedSet<String> originCityList;
    private SortedSet<String> movieList;
    
   
    
    public MovieModel(){
        movieList = new TreeSet<>();
        movieCounter=0;
        theMovies=new ArrayList<>();
        
        String filename="M:\\MovieSystem\\ICS125Project\\JavaApplication1\\src\\selectmovie\\movies.txt";
    try {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        
    while ((line = bufferedReader.readLine()) != null){
        String[] tokens = line.split(",", Movie.NUMBER_OF_CONTRACT_ATTRIBUTES);
        
        // String contractID = tokens[Contract.INDEX_OF_CONTRACT_ID];
        String movieName = tokens[Movie.INDEX_OF_CONTRACT_ID];
        String rate = tokens[Movie.INDEX_OF_ORIGIN_CITY];
        String actors = tokens[Movie.INDEX_OF_DEST_CITY];
   
        //Contract dataContract = new Contract(contractID, originCity, destCity, orderItem);
        Movie dataMovie = new Movie(movieName, rate, actors);
        
        originCityList.add(originCity);
        theContracts.add(dataContract);
    }   //end while
    //step 8 
    originCityList.add("All");
    //step 9 
    theContractsAll = new ArrayList<>(theContracts);
    fileReader.close();
    }
    catch(IOException ex){
            System.out.println(ex.getMessage());
            }
    
    } //end of constructor 
    boolean foundContracts(){
        if(theContracts.size() >= 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Contract getTheContract(){
        return theContracts.get(contractCounter);
    }
    public int getContractCount(){
        return theContracts.size();
        //called in setupdisplay method
    }
    //called in setUpDisplay method
    public int getCurrentContractNum(){
        return contractCounter;
    }
    public void nextContract(){
        if (contractCounter + 1 <= theContracts.size()){
            contractCounter++;
        }
    }
    public void prevContract(){
        if (contractCounter > 0){
            contractCounter--;
    }   
    }
    
    public String[] getOriginCityList(){
        String[] a;
        a= originCityList.toArray(new String[originCityList.size()]);
        return a;
    }
    
    public void updateContractList(String city){
        theContracts = new ArrayList<>(theContractsAll);
        if (!city.equals("All")){
            theContracts.removeIf(s -> !s.contains(city));
        }
        // lynda suggestion 
        //System.out.print(city);
        contractCounter=0;
    }
  
}
