package lcdp.bank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Bank1 {
	private String firstname;
	private String lastname;
	private int user;
	private int password;
	private boolean status;
	private boolean laststatus;
	protected int balance;
	private int debt;
	protected int creditcard;
	private LocalDate date1 = LocalDate.now();
	private LocalDate date2 = date1.minusMonths(2);
	protected LocalDate date;
	private Period period;
        private int dailylimit = 0; 

	public Bank1[] load() throws IOException {
            // PLEASE PUT THE PATH OF CSV IN STRING PATH = ^_^
            // here we read the csv as an array
		String path = "C://Users//as//OneDrive//Desktop//data.csv";
		String line = "";
		Bank1[] b = new Bank1[20];
		BufferedReader br = new BufferedReader(new FileReader(path));
		int i = 0;
		while ((line = br.readLine()) != null) {
			String[] values = line.split(",");
			int temp = Integer.parseInt(values[2]);
			int temp1 = Integer.parseInt(values[3]);
			int temp2 = Integer.parseInt(values[4]);
			int temp4 = Integer.parseInt(values[5]);
			int temp5 = Integer.parseInt(values[6]);
			int temp6 = Integer.parseInt(values[7]);
			int temp7 = Integer.parseInt(values[8]);
			if (temp2 < 10000) {//regular account
				b[i] = new Bank1();
				b[i].setFirstname(values[0]);
				b[i].setLastname(values[1]);
				b[i].setUser(temp);
				b[i].setPassword(temp1);
				b[i].setBalance(temp2);
				b[i].setCreditcard(temp4);
				b[i].setDate(temp5, temp6, temp7);
				b[i].setLaststatus();
				b[i].setStatus();
			} else {  //vip account
				b[i] = new Vip();
				b[i].setFirstname(values[0]);
				b[i].setLastname(values[1]);
				b[i].setUser(temp);
				b[i].setPassword(temp1);
				b[i].setBalance(temp2);
				b[i].setCreditcard(temp4);
				b[i].setDate(temp5, temp6, temp7);
				b[i].setLaststatus();
				b[i].setStatus();
			}
			i++;
		}
		br.close();
		return b;
	}
        public void updateDate(){
            if (this.creditcard == 10000){
                this.date = LocalDate.now();
            // update date when the debt is repayed
            }
        }

	public String getPeriod() {// function to print the left time to be in debt
		this.period = Period.between(date2, date);
                int d1 = this.period.getMonths();
                int d2 =this.period.getDays();
                String s1 = Double.toString(d1);
                 String s2 = Double.toString(d2);
		String s = s1+" Months and "+s2+" Days left to be indebt";
                return s;
               
	}

	public void setLaststatus() {// function set last status true if he draw
									// from credit card from two month ago
		if (this.date.isBefore(date2)) {
			this.laststatus = true;
		} else {
			this.laststatus = false;
		}
	}

	public void setDate(int u1, int u2, int u3) {// used to set date
													// "taken by data"
		if (this.creditcard < 10000) {
			this.date = LocalDate.of(u1, u2, u3);
		} else {
			this.date = LocalDate.now();
		}
	}
    

	public void setDebt() {// function that set debt amount
		this.debt = 10000 - this.creditcard;
	}

	public void setCreditcard(int creditcard) {// function needed to set
													// amount you can borrow
													// from creditcard
		
			this.creditcard = creditcard;
	}

	public void setStatus() {// set status true if you borrow money from
								// creditcard
		if (creditcard < 10000) {
			this.status = true;
		} else {
			this.status = false;
		}
	}

	public void setBalance(int balance) {// function needed to set balance
											// from data
		this.balance = balance;
	}
       public void setDailylimit(int money){
          this.dailylimit = this.dailylimit + money;
        }
	public void setFirstname(String name) {// function to set First name
		this.firstname = name;
	}

	public void setLastname(String name) {// function to set Last name
		this.lastname = name;
	}

	public void setUser(int n) {// set of User to CreditCard
			this.user = n;
	}

	public void setPassword(int n) {// set Password to CreditCard
		if (n > 999 && n < 10000) {
			this.password = n;
                }
	}
        public int getCreditamount(){ //get the credit amount
        return this.creditcard;
        }
        public int getDebt(){ //return the debt
        return this.debt ;
        }

	public String getFirstname() {// function to get First name
		return firstname;
	}

	public String getLastname() {// function to get last name
		return lastname;
	}

	public void resetDebt() { //check if the debt is repayed hence reset it
		if (creditcard == 10000) {
			this.debt = 0;
                }
        }

	public void transferMoney(Bank1 b, Bank1 b2, int x) { //transfer the money 
		b2.deposit(x);
		b.draw(x);
	}

	public boolean getStatus() { //check if you are in debt or not
		return this.status;
	}

	public boolean getLaststatus() { // true if your account is closed
		return this.laststatus;
	}
        public int getDailylimit(){ //return the daily limit
          return this.dailylimit;
        }
	public void deposit(int deposit) { //deposit money
		this.balance = this.balance + deposit;
	}

	public void depositCredit(int deposit) { //deposit to credit
		if (creditcard < 10000) {
			this.creditcard = this.creditcard + deposit;
		} else {
			this.balance = this.balance + deposit;
		}
	}

	public void draw(int money) { // withdraw from your balance
			this.balance = this.balance - money;
	}
        
	public void drawCredit(int money) { //withdraw money from your credit
		if (this.creditcard >0 && this.creditcard >= money) {
			this.creditcard = this.creditcard - money;
		}
	}

	public int checkBalance() { //check the user balance
		return this.balance;
	}

	public int getUser() {// return User of CreditCard
		return this.user;
	}

	public int getPassword() {// return Password of CreditCard
		return this.password;
	}

	public int checkCredit(int n1, int n2, Bank1 b[]) {// Check That User and
		int c = 0;
		int i = 0;
		boolean flag = true;
		while (flag) {
			if (b[i].user == n1 && b[i].password == n2) {
				c = i;
				flag = false;
			} else {
				i++;
			}
		}
		return c;
	}

	public int checkUser(int n1, Bank1 b[]) {// Check That User of credit and
												// return it's number
		int c = 0;
		int i = 0;
		boolean flag = true;
		while (flag) {
			if (b[i].user == n1 && i < 20) {
				c = i;
				flag = false;
			} else {
				i++;
			}
		}
		return c;
	}
        public boolean checkUserb(int n1, Bank1 b[]) {// Check That User of credit and
										// return it's number
		boolean c = false;
		int i = 0;
		boolean flag = true;
		while (flag && i<20) {
			if (b[i].user == n1 && i < 20) {
				c = true ;
				flag = false;
			} else {
				i++;
			}
		}
		return c;
	}

	public boolean checkCreditb(int n1, int n2, Bank1 b[]) {// Check That User is found
															// and
		boolean flag = true;
		int i = 0;
		while (flag && i < 20) {
			if (b[i].user == n1 && b[i].password == n2) {
				flag = false;
			} else {
				i++;
			}
		}
		return !flag;
	}
        

}