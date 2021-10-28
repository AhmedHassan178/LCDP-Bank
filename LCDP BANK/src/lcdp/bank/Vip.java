/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdp.bank;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author as
 */
public class Vip extends Bank1 {
	private boolean status;
	private boolean laststatus;
	private int debt;
	private int creditcard;
	private LocalDate date1 = LocalDate.now();
	private LocalDate date2 = date1.minusMonths(4);
	private Period period;
        private int dailylimit=0;
        
    @Override
  public void updateDate(){
            if (super.creditcard == 20000){
                this.date = LocalDate.now();
            
            }
        }
        public void setDailylimit(int money){
          this.dailylimit = this.dailylimit + money;
        }
  	public void draw(int money) { // withdraw from your balance		
            super.balance = super.balance - money;
	}
  	public void depositCredit(int deposit) {
		if (creditcard < 20000) {
			super.creditcard = super.creditcard + deposit;
		} else {
			super.balance = super.balance + deposit;
		}
	}
  public void setDate(int u1, int u2, int u3) {// used to set date									// "taken by data"
		if (super.creditcard < 20000) {
			this.date = LocalDate.of(u1, u2, u3);
		} else {
			this.date = LocalDate.now();
		}
	}

  @Override 
  	public String getPeriod() {// function to print the left time to be in debt
		this.period = Period.between(date2, date);
                int d1 = this.period.getMonths();
                int d2 =this.period.getDays();
                String s1 = Double.toString(d1);
                 String s2 = Double.toString(d2);
		String s = s1+" Months and "+s2+" Days left to be indebt";
                return s;
	}
        public void setCreditcard(int creditcard) {// function needed to set
													// amount you can borrow
													// from creditcard
			super.creditcard = creditcard;
	}
        
        	
    @Override
     public void setLaststatus() {// function set last status true if he draw
									// from credit card from two month ago
        if (this.date.isBefore(date2)) {
			this.laststatus = true;
		} else {
			this.laststatus = false;
		}
	}
    @Override
     	public void setDebt() {// function that set debt amount
		this.debt = 20000 - super.creditcard;
	}
    @Override
       public void setStatus() {// set status true if you borrow money from
								// creditcard
		if (super.creditcard < 20000) {
			this.status = true;
		} else {
			this.status = false;
		}
	}
    @Override
  	public void resetDebt() {
		if (this.creditcard == 20000) {
			this.debt = 0;
		} else {
			System.out.println("You Are still in debt");
		}
	}
       public boolean getStatus() {
		return this.status;
	}
//        @Override
       public int getDebt(){
        return this.debt ;
        }
       	public boolean getLaststatus() {
		return this.laststatus;
	}
      public int getDailylimit(){
        return this.dailylimit;
        }
    }


    
