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
public class SelectMovie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        MovieView theView=new MovieView();
        MovieModel theModel=new MovieModel();
        MovieController theController;
        theController= new MovieController(theView, theModel);
        theView.setVisible(true);
    }
    
}
