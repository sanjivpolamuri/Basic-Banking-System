package jdbcconnect;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Bank extends Exception{
	Bank(String s){
		super(s);
	}
}

public class BankProgram {
	static int balance;
	static int rbal;
	
	public static boolean checkingtheuser(Connection c,long ac,String p)throws Exception {
		PreparedStatement ps=c.prepareStatement("select * from Bank");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			if(rs.getLong("AccountNo")==ac && (rs.getString("pass")).equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean validatereceiver(Connection c,long acc)throws Exception {
		PreparedStatement ps=c.prepareStatement("select * from Bank");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			if(rs.getLong("AccountNo") == acc) {
				rbal=rs.getInt("Balance");
				return true;
			}
		}
		return  false;
	}
	
	public static void Deposit(int amt) throws Bank{
		if(amt>500) {
			balance+=amt;
		}
		else {
			try {
			throw new Bank("The amount is less than 500");
			}
			catch(Bank b) {
				System.out.println(b);
			}
		}	
	}
	
	public static void Withdraw(int amt)throws Bank{
		if(balance>=amt) {
			balance-=amt;
			System.out.println("The amount withdraw is:"+amt);
		}
		else {
			try {
				throw new Bank("low balance");
				}
			catch(Bank b) {
					System.out.println(b);
			}
		}
	}
	
	public static void update(Connection c,long accno) throws SQLException {
		PreparedStatement ps=c.prepareStatement("update Bank set Balance="+balance+" where AccountNo="+accno);
		ps.executeUpdate();
	}
	
	public static void receiverupdate(Connection c,long accno) throws SQLException {
		PreparedStatement ps=c.prepareStatement("update Bank set Balance="+rbal+" where AccountNo="+accno);
		ps.executeUpdate();
	}
	
	public static void main(String[] args) throws Bank,Exception{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/test","root","M1racle@123");
		System.out.println("Welcome to our bank");
		long accno = 0;
		String pwd="";
		int count=0;
		boolean flag=false;
		while(count<3) {
			System.out.print("Enter the Account no:");
			accno=sc.nextLong();
			sc.nextLine();
			System.out.print("Enter the password:");
			pwd=sc.nextLine();
			flag=checkingtheuser(con,accno,pwd);
			if(flag==true) {
				break;
			}
			count++;
			System.out.println(count);
		}
		if(count==3) {
			throw new Bank("Too many unsuccessful attempts");
		}
		else {
			System.out.println("welcome acccount no:"+accno+" password:"+pwd);
			PreparedStatement ps=con.prepareStatement("select * from Bank where AccountNo="+accno);
			ResultSet rs=ps.executeQuery();
			rs.next();
			BankProgram p=new BankProgram();
			p.balance=rs.getInt("Balance");
			System.out.println("Balance amount is:"+balance);
			boolean val=true;
			while(val) {
				System.out.println("1)Deposit\n2)Withdraw\n3)Balance\n4)Transfer\n5)Exit");
				int choice=sc.nextInt();
				switch(choice) {
				    case 1:{
				    	System.out.print("Enter the amount to deposit");
						int amount=sc.nextInt();
				    	Deposit(amount);
				    	update(con,accno);
				    	break;
				    }
				    
				    case 2:{
				    	System.out.print("Enter the amount to withdraw");
				    	int amount=sc.nextInt();
				    	Withdraw(amount);
				    	update(con,accno);
				    	break;
				    }
				    
				    case 3:{
				    	System.out.println("The balance amount is:"+balance);
				    	break;
				    }
				    
				    case 4:{
				    	System.out.print("Enter the receiver account no:");
				    	long r_no=sc.nextLong();
				    	if(validatereceiver(con,r_no)) {
				    		System.out.print("Enter the amount to send");
				    		int r_amount=sc.nextInt();
				    		if(balance >=r_amount) {
				    			balance-=r_amount;
				    			rbal+=r_amount;
				    			update(con,accno);
				    			System.out.println("The balance of sender is:"+balance);
				    			receiverupdate(con,r_no);
				    			System.out.println("The balance of receiver is:"+rbal);

				    		}
				    		else {
				    			try {
				    				throw new Bank("Invalid senders balance");
				    				}
				    			catch(Bank b) {
				    					System.out.println(b);
				    			}
				    		}
				    	}
				    	else {
				    		try {
				    			throw new Bank("Invalid receiver details");
								}
							catch(Bank b) {
								System.out.println(b);
							}
				    	}
				    	break;
				    }
				    case 5:{
				    	System.out.println("Thank you for visiting our bank");
				    	System.exit(0);
				    	break;
				    }
				    default:{
				    	 try {
							   throw new Bank("Enter the number between 1 and 4");
						   }
						   catch(Bank e) {
							   System.out.println(e);
						   }
				    }
				}
			}
		}
	}
}