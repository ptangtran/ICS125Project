/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectmovie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author C0472359
 */
class MovieController {
    
    private MovieView theView;
    private MovieModel theModel;
    private ConfirmBuy theBuy;
    private Movie theMovie;
    
    public MovieController(MovieView movieView, MovieModel movieModel){
    theView = movieView;
    theModel = movieModel;
    this.theView.addPrevListener(new PrevButtonListener());
    this.theView.addBidListener(new BuyButtonListener());
    this.theView.addNextListener(new NextButtonListener());
    this.theView.addcomboBoxListener(new ComboListener());
    setUpDisplay();
    //step 12
    theView.setOriginCityList(theModel.getOriginCityList());
    }
    //FINISH LATER BC U DED AF
  private void setUpDisplay() {
      try{
          if(theModel.foundContracts()){
              Movie c = theModel.getTheMovie();
                      //theView.setContractID(c.getContractID());
                      //theView.setDestCity(c.getDestCity());
                      theView.setMovieName(c.getMovieName());
                      theView.setRating(c.getRating());
                      theView.setActors(c.getActors());
                      //theView.setOriginCity(c.getOriginCity());
                      //theView.setOrderItem(c.getOrderItem());
          }else {
          theView.setMovieName("N/A");
          theView.setRating("N/A");
          theView.setActors("N/A");
        }
          theView.updateMovieViewPanel(theModel.getCurrentContractNum(), theModel.getContractCount());
      }catch (Error ex){
          System.out.println(ex);
          theView.displayErrorMessage("Error: There was a problem setting the contract.\n" + "             contract Number: " + theModel.getCurrentContractNum());
      }
  } 
  class PrevButtonListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e){
          //change currentcontractnum
          if (theModel.getCurrentContractNum() ==0){
              return;
          }
          try{
              theModel.prevMovie();
          }catch (Exception ex){
              System.out.println(ex);
              theView.displayErrorMessage(
              "Error: There is a problem setting a previous contract.");
          }
          setUpDisplay();
          }

        
      }
  class NextButtonListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e){
          if (theModel.getCurrentContractNum() >= theModel.getContractCount() -1){
              return;
          }
          try{
              theModel.nextMovie();
              //theModel.nextContract();
          }catch (Exception ex){
              System.out.println(ex);
              theView.displayErrorMessage(
              "Error: There is a problem setting a next movie.");
          }
          setUpDisplay();
          }
      }
  
   class ComboListener implements ItemListener {
       @Override
       public void itemStateChanged(ItemEvent e){
           System.out.println(e.getItem().toString());
           if(e.getStateChange() == ItemEvent.SELECTED){
               String selectedMovie = e.getItem().toString();
               //String selectedCity = e.getItem().toString();
               System.out.println(selectedMovie);
               theModel.updateContractList(selectedMovie);
               setUpDisplay();
           } //end if
       } // end itemStateChanged
   } // end ComboListener
   
   class BidButtonListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e){
          try{
              //Contract c = theModel.getTheContract();
              //String l = c.getContractID();
              ConfirmBuy cb = new ConfirmBuy(theView, true, theModel.getTheMovie());
              cb.setLocationRelativeTo(null);
              cb.setVisible(true);
          }
          catch (Exception ex){
              System.out.println(ex);
              theView.displayErrorMessage("Error: The numbers entered must be integers.");
          } //end catch
      } //end action 
      }//end bidbuttonListener
  }
