/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdp.bank;

import java.io.IOException;
import static lcdp.bank.Bank.b;

/**
 *
 * @author as
 */

        
public class Bank  {     
 static Bank1 j = new Bank1();
//  public Bank1 []b = j.load();
  public static int i;
  public static int gooo = 0;
  static Bank1 []b;
  public static boolean flag; 

//public void setB(Bank1[] b) throws IOException {
//        this.b = b;
//        this.b = j.load();
//    }
  
   
    
 
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//     Bank1 j = new Bank1();
     b = j.load();
new LOGIN().setVisible(true);
       
//     new LOGIN().setVisible(true);


    /* new MENU().setVisible(true);
     new TRANSFERPAGE().setVisible(true);
     new DEPOSITPAGE().setVisible(true);
     new WITHDRAWPAGE().setVisible(true);
     new CHECKSTATUSPAGE().setVisible(true);
     new REPAY().setVisible(true); 
     new INVALID().setVisible(true);
     new CLOSED().setVisible(true);*/

    }
    
}
