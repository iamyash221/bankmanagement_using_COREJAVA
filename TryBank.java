import java.util.*;
import java.text.*;
import java.io.*;

class Bank implements Serializable
{
	String bankname;
	String bankbranch;

	/*void GetBankDetails() throws IOException,ClassNotFoundException
	{
		Scanner s = new Scanner(System.in);
		System.out.println("\nEnter the bank: ");
		bankname = s.next();
		System.out.println("Enter the branch: ");
		bankbranch = s.next();
	}*/
}

class Admin extends Bank implements Serializable 
{	
	String accounttype;
	static int customercount = 0;

	/*void GetAdminDetails() throws IOException,ClassNotFoundException 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the type of account: ");
		accounttype = s.next();
	}*/
}

class Customer extends Admin implements Serializable
{
	String customername;
	int customerid;
	String customerpassword;
	float balance;
	float withdraw;
	float deposit;

	void GetCustomerDetails() throws IOException,ClassNotFoundException
	{
		Scanner s = new Scanner(System.in);

		System.out.println("\nEnter the bank: ");
		bankname = s.next();
		System.out.println("Enter the branch: ");
		bankbranch = s.next();

		System.out.println("Enter the type of account: ");
		accounttype = s.next();

		System.out.println("Enter your username: ");
		customername = s.next();
		System.out.println("Enter your password: ");
		customerpassword = s.next();
		System.out.println("Enter initial balance: ");
		balance = s.nextFloat();
		customerid = customercount + 1000;
		System.out.println("\nYour generated ID is: " + this.customerid);
		FileOutputStream fos = new FileOutputStream("D:\\Coding\\Java\\Bank\\" + customername);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
		fos.close();
	}
	void DisplayCustomerDetails(String fname) throws IOException,ClassNotFoundException
	{
		this.customername = customername;
		FileInputStream fis = new FileInputStream("D:\\Coding\\Java\\Bank\\" + fname);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Customer newb = (Customer)ois.readObject();
		
		System.out.format("|%-16s|%-14s|%-19s|%-15s|%-16s|%-15s|",newb.customername,newb.customerid,newb.accounttype,newb.balance,newb.bankname,newb.bankbranch);
		
		ois.close();
		fis.close();
	}
}

class TryBank implements Serializable
{	
	public static void main(String args[]) throws IOException,ClassNotFoundException
	{
		Customer c[] = new Customer[50];
		Customer q = new Customer();
		Scanner s = new Scanner(System.in);
		int choicemain;
		int y;
		String adminuser = "admin";
		String adminpassword = "admin";
		String adminusermain;
		String adminpasswordmain;
		File f = new File("D:\\Coding\\Java\\Bank");
		String name[] = f.list();
		
		for(y=0;y<102;y++)
		{
			System.out.print("=");
		}
		System.out.println("");
		for(y=0;y<40;y++)
		{
			System.out.print(" ");
		}
		System.out.println("WELCOME TO MY BANK APP");
		for(y=0;y<102;y++)
		{
			System.out.print("=");
		}
		System.out.println("\n");
	
		while(true)
		{
			System.out.println("");
			for(y=0;y<41;y++)
			{
				System.out.print("-");
			}
			System.out.print("WELCOME TO MAIN MENU");
			for(y=0;y<41;y++)
			{
				System.out.print("-");
			}
			System.out.println("\n\n1 ----- Admin Login");
			System.out.println("2 ----- Customer Login");
			System.out.println("0 ----- Exit");
			System.out.println("\nEnter your choice: ");
			choicemain = s.nextInt();
			switch(choicemain)
			{		
				case 1:
					System.out.println("\nEnter admin username: ");
					adminusermain = s.next();
					System.out.println("Enter admin password: ");
					adminpasswordmain = s.next();
					if(adminusermain.equals(adminuser) && adminpasswordmain.equals(adminpassword))
					{
						System.out.println("");
						for(y=0;y<40;y++)
						{
							System.out.print("-");
						}
						System.out.print("ADMIN LOGIN SUCCESSFUL");
						for(y=0;y<40;y++)
						{
							System.out.print("-");
						}
						System.out.println("\n");

						int choiceadmin;
						while(true)
						{
							System.out.println("");
							for(y=0;y<46;y++)
							{
								System.out.print("-");
							}
							System.out.print("LOGIN PAGE");
							for(y=0;y<46;y++)
							{
								System.out.print("-");
							}
							System.out.println("\n");			
	
							System.out.println("1 ----- Create New User");
							System.out.println("2 ----- Display User");
							System.out.println("3 ----- Search User");
							System.out.println("4 ----- Sort User");
							System.out.println("5 ----- Remove User");
							System.out.println("0 ----- Back To Main Menu");
							System.out.println("\nEnter your choice: ");
							choiceadmin = s.nextInt();
							switch(choiceadmin)
							{
								case 1:
									c[Customer.customercount] = new Customer();
									c[Customer.customercount].GetCustomerDetails();
									Customer.customercount++;
									
									System.out.println("");
									for(y=0;y<43;y++)
									{
										System.out.print("-");
									}
									System.out.print("CUSTOMER CREATED");
									for(y=0;y<43;y++)
									{
										System.out.print("-");
									}
									System.out.println("\n");
									break;

								case 2:
									c[Customer.customercount] = new Customer();

									name = f.list();
									System.out.println("");
									for(y=0;y<102;y++)
									{
										System.out.print("=");
									}
									System.out.println("");
									System.out.format("|%-16s|%-14s|%-19s|%-15s|%-16s|%-15s|","UserName","UserID","AccountType","Balance","BankName","BankBranch");
									System.out.println("");
									for(y=0;y<102;y++)
									{
										System.out.print("=");
									}
									System.out.println("");

									for(int i=0;i<name.length;i++)
									{
										Customer c1 = new Customer();
										//c[Customer.customercount] = new Customer();
										c1.DisplayCustomerDetails(name[i]);
										System.out.println("");
									}
									for(y=0;y<102;y++)
									{
										System.out.print("=");
									}
									System.out.println("\n");
									break;
								case 3:
									int customeridsearch;
									System.out.println("\nEnter the ID you want to search:");
									customeridsearch = s.nextInt() - 1000;
									int customeridsearchtemp = customeridsearch + 1000;
									int flags = 0;
									for(int i=0;i<Customer.customercount;i++)
									{
										if(customeridsearchtemp == (c[i].customerid))
										{
											flags = 1;
											break;
										} 
									}
									if(flags == 1)
									{
										System.out.println("");
										for(y=0;y<102;y++)
										{
											System.out.print("=");
										}
										System.out.println("");
										System.out.format("|%-16s|%-14s|%-19s|%-15s|%-16s|%-15s|","UserName","UserID","AccountType","Balance","BankName","BankBranch");
										System.out.println("");
										for(y=0;y<102;y++)
										{
											System.out.print("=");
										}
										System.out.println("");
										System.out.format("|%-16s|%-14s|%-19s|%-15s|%-16s|%-15s|",c[customeridsearch].customername,c[customeridsearch].customerid,c[customeridsearch].accounttype,c[customeridsearch].balance,c[customeridsearch].bankname,c[customeridsearch].bankbranch);
										System.out.println("");
										for(y=0;y<102;y++)
										{
											System.out.print("=");
										}
										System.out.println("\n");
									}
									else
									{
										System.out.println("\nID Invalid");
									}
									break;
								case 4:
									int choiced;
									int n,j,k,bla = 0;
									System.out.println("\n1 ----- Sort In Ascending Order By UserName");
									System.out.println("2 ----- Sort In Descending Order By UserName");
									System.out.println("3 ----- Sort In Ascending Order By ID");
									System.out.println("4 ----- Sort In Descending Order By ID");
									System.out.println("\nEnter your choice: ");
									choiced = s.nextInt();
									System.out.println("");
									for(y=0;y<102;y++)
									{
										System.out.print("=");
									}
									System.out.println("");
									System.out.format("|%-16s|%-14s|%-19s|%-15s|%-16s|%-15s|","UserName","UserID","AccountType","Balance","BankName","BankBranch");
									System.out.println("");
									for(y=0;y<102;y++)
									{
										System.out.print("=");
									}
									System.out.println("");
									Customer ctemp = new Customer();
									switch(choiced)
									{
										case 1:
											for(n=0;n<Customer.customercount;n++)
											{
		               									for(j=0;j<Customer.customercount-1;j++) 
												{
								                	 		if((c[j].customername.charAt(0))>(c[j+1].customername.charAt(0))) 
													{
					                						 	//Customer ctemp = new Customer();
									                		 	ctemp.customername=c[j].customername;
		                									 	ctemp.customerid=c[j].customerid;
					                					 		ctemp.accounttype=c[j].accounttype;
					                					 		ctemp.balance=c[j].balance;
					                					 		ctemp.bankname=c[j].bankname;
					                					 		ctemp.bankbranch=c[j].bankbranch;
					        			        			 	c[j].customername=c[j+1].customername;
					        			        			 	c[j].customerid=c[j+1].customerid;
					        			        			 	c[j].accounttype=c[j+1].accounttype;
					        			        			 	c[j].balance=c[j+1].balance;
					        			        			 	c[j].bankname=c[j+1].bankname;
					        			        			 	c[j].bankbranch=c[j+1].bankbranch;
		                									 	c[j+1].customername=ctemp.customername;
		                									 	c[j+1].customerid=ctemp.customerid;
		                									 	c[j+1].accounttype=ctemp.accounttype;
		                									 	c[j+1].balance=ctemp.balance;
		                									 	c[j+1].bankname=ctemp.bankname;
		                									 	c[j+1].bankbranch=ctemp.bankbranch;
														bla = 1;
										                        }
												}
									           	}	   
		            								for(k=0;k<Customer.customercount;k++)
											{
													System.out.format("|%-16s|%-14s|%-19s|%-15s|%-16s|%-15s|",c[k].customername,c[k].customerid,c[k].accounttype,c[k].balance,c[k].bankname,c[k].bankbranch);
													System.out.println("");
											}
											for(y=0;y<102;y++)
											{
												System.out.print("=");
											}
											System.out.println("\n");
											break;
										case 2:
											for(n=0;n<Customer.customercount;n++)
											{
		               									for(j=0;j<Customer.customercount-1;j++) 
												{
								                	 		if((c[j].customername.charAt(0))<(c[j+1].customername.charAt(0))) 
													{
					                						 	//Customer ctemp = new Customer();

									                		 	ctemp.customername=c[j].customername;
		                									 	ctemp.customerid=c[j].customerid;
					                					 		ctemp.accounttype=c[j].accounttype;
					                					 		ctemp.balance=c[j].balance;
					                					 		ctemp.bankname=c[j].bankname;
					                					 		ctemp.bankbranch=c[j].bankbranch;

					        			        			 	c[j].customername=c[j+1].customername;
					        			        			 	c[j].customerid=c[j+1].customerid;
					        			        			 	c[j].accounttype=c[j+1].accounttype;
					        			        			 	c[j].balance=c[j+1].balance;
					        			        			 	c[j].bankname=c[j+1].bankname;
					        			        			 	c[j].bankbranch=c[j+1].bankbranch;

		                									 	c[j+1].customername=ctemp.customername;
		                									 	c[j+1].customerid=ctemp.customerid;
		                									 	c[j+1].accounttype=ctemp.accounttype;
		                									 	c[j+1].balance=ctemp.balance;
		                									 	c[j+1].bankname=ctemp.bankname;
		                									 	c[j+1].bankbranch=ctemp.bankbranch;
														bla = 1;
										                        }
												}
									           	}	   
		            								for(k=0;k<Customer.customercount;k++)
											{
													System.out.format("|%-16s|%-14s|%-19s|%-15s|%-16s|%-15s|",c[k].customername,c[k].customerid,c[k].accounttype,c[k].balance,c[k].bankname,c[k].bankbranch);
													System.out.println("");
											}
											for(y=0;y<102;y++)
											{
												System.out.print("=");
											}
											System.out.println("\n");
											break;
										case 3:
											for(n=0;n<Customer.customercount;n++)
											{
		               									for(j=0;j<Customer.customercount-1;j++) 
												{
								                	 		if((c[j].customerid)>(c[j+1].customerid)) 
													{
					                						 	//Customer ctemp = new Customer();
									                		 	ctemp.customername=c[j].customername;
		                									 	ctemp.customerid=c[j].customerid;
					                					 		ctemp.accounttype=c[j].accounttype;
					                					 		ctemp.balance=c[j].balance;
					                					 		ctemp.bankname=c[j].bankname;
					                					 		ctemp.bankbranch=c[j].bankbranch;
					        			        			 	c[j].customername=c[j+1].customername;
					        			        			 	c[j].customerid=c[j+1].customerid;
					        			        			 	c[j].accounttype=c[j+1].accounttype;
					        			        			 	c[j].balance=c[j+1].balance;
					        			        			 	c[j].bankname=c[j+1].bankname;
					        			        			 	c[j].bankbranch=c[j+1].bankbranch;
		                									 	c[j+1].customername=ctemp.customername;
		                									 	c[j+1].customerid=ctemp.customerid;
		                									 	c[j+1].accounttype=ctemp.accounttype;
		                									 	c[j+1].balance=ctemp.balance;
		                									 	c[j+1].bankname=ctemp.bankname;
		                									 	c[j+1].bankbranch=ctemp.bankbranch;
														bla = 1;
										                        }
												}
									           	}	   
		            								for(k=0;k<Customer.customercount;k++)
											{
													System.out.format("|%-16s|%-14s|%-19s|%-15s|%-16s|%-15s|",c[k].customername,c[k].customerid,c[k].accounttype,c[k].balance,c[k].bankname,c[k].bankbranch);
													System.out.println("");
											}
											for(y=0;y<102;y++)
											{
												System.out.print("=");
											}
											System.out.println("\n");
											break;
										case 4:
											for(n=0;n<Customer.customercount;n++)
											{
		               									for(j=0;j<Customer.customercount-1;j++) 
												{
								                	 		if((c[j].customerid)<(c[j+1].customerid)) 
													{
					                						 	//Customer ctemp = new Customer();
									                		 	ctemp.customername=c[j].customername;
		                									 	ctemp.customerid=c[j].customerid;
					                					 		ctemp.accounttype=c[j].accounttype;
					                					 		ctemp.balance=c[j].balance;
					                					 		ctemp.bankname=c[j].bankname;
					                					 		ctemp.bankbranch=c[j].bankbranch;
					        			        			 	c[j].customername=c[j+1].customername;
					        			        			 	c[j].customerid=c[j+1].customerid;
					        			        			 	c[j].accounttype=c[j+1].accounttype;
					        			        			 	c[j].balance=c[j+1].balance;
					        			        			 	c[j].bankname=c[j+1].bankname;
					        			        			 	c[j].bankbranch=c[j+1].bankbranch;
		                									 	c[j+1].customername=ctemp.customername;
		                									 	c[j+1].customerid=ctemp.customerid;
		                									 	c[j+1].accounttype=ctemp.accounttype;
		                									 	c[j+1].balance=ctemp.balance;
		                									 	c[j+1].bankname=ctemp.bankname;
		                									 	c[j+1].bankbranch=ctemp.bankbranch;
														bla = 1;
										                        }
												}
									           	}	   
		            								for(k=0;k<Customer.customercount;k++)
											{
													System.out.format("|%-16s|%-14s|%-19s|%-15s|%-16s|%-15s|",c[k].customername,c[k].customerid,c[k].accounttype,c[k].balance,c[k].bankname,c[k].bankbranch);
													System.out.println("");
											}
											for(y=0;y<102;y++)
											{
												System.out.print("=");
											}
											System.out.println("\n");
											break;
									}
									if(bla == 1)
									{
										for(n=0;n<Customer.customercount;n++)
											{
		               									for(j=0;j<Customer.customercount-1;j++) 
												{
								                	 		if((c[j].customerid)>(c[j+1].customerid)) 
													{
					                						 	//Customer ctemp = new Customer();
									                		 	ctemp.customername=c[j].customername;
		                									 	ctemp.customerid=c[j].customerid;
					                					 		ctemp.accounttype=c[j].accounttype;
					                					 		ctemp.balance=c[j].balance;
					                					 		ctemp.bankname=c[j].bankname;
					                					 		ctemp.bankbranch=c[j].bankbranch;
					        			        			 	c[j].customername=c[j+1].customername;
					        			        			 	c[j].customerid=c[j+1].customerid;
					        			        			 	c[j].accounttype=c[j+1].accounttype;
					        			        			 	c[j].balance=c[j+1].balance;
					        			        			 	c[j].bankname=c[j+1].bankname;
					        			        			 	c[j].bankbranch=c[j+1].bankbranch;
		                									 	c[j+1].customername=ctemp.customername;
		                									 	c[j+1].customerid=ctemp.customerid;
		                									 	c[j+1].accounttype=ctemp.accounttype;
		                									 	c[j+1].balance=ctemp.balance;
		                									 	c[j+1].bankname=ctemp.bankname;
		                									 	c[j+1].bankbranch=ctemp.bankbranch;
														bla = 1;
										                        }
												}
									           	}
									}
								case 5:
									int chrmv;
									c[Customer.customercount] = new Customer();
									System.out.println("1 ----- Remove User Physically");
									System.out.println("2 ----- Remove User Logically");
									System.out.println("0 ----- Back");
									System.out.println("Enter your choice: ");
									chrmv = s.nextInt();
									switch(chrmv)
									{
										case 1: 
											int temprmv=0;
											int customeridremove;
											String customernameremove;
											int i;
											System.out.println("Enter user ID to remove: ");
											customeridremove = s.nextInt();
											System.out.println("Enter user name to remove: ");
											customernameremove = s.next();
											for(i=0;i<Customer.customercount;i++)
											{
												if(customernameremove.equalsIgnoreCase(c[i].customername))
												{
													
													temprmv = 1;
													break;
												}
											}
											if(temprmv == 0)
											{
												File fr = new File("D:\\Coding\\Java\\Bank\\" + customernameremove);
												if(fr.delete())
												{
													System.out.println("\n****** PHYSICALLY REMOVED USER SUCCESFULLY ******");
												}
												else
												{
													System.out.println("\n****** COULDNT FOUND FILE ******");
												}
											}
											else
											{
												System.out.println("\n****** INVALID ID ******");
											}
											break;

										case 2: 
											temprmv = 0;
											String rename;
											System.out.println("Enter user ID to remove: ");
											customeridremove = s.nextInt();
											System.out.println("Enter user name to remove: ");
											customernameremove = s.next();
											for(i=0;i<Customer.customercount;i++)
											{
												if(customernameremove.equalsIgnoreCase(c[i].customername))
												{
													
													temprmv = 1;
													break;
												}
											}
											if(temprmv == 0)
											{
												File of = new File("D:\\Coding\\Java\\Bank\\" + customernameremove);
												System.out.println("Enter the name to rename the user file: ");
												rename = s.next();
												File nf = new File("D:\\Coding\\Java\\Bank\\" + rename);
												if(of.renameTo(nf))
												{
													System.out.println("\n****** RENAMED USER SUCCESFULLY ******");
												}
												else
												{
													System.out.println("\n****** COULDNT FOUND FILE ******");
												}
											}
											else
											{
												System.out.println("\n****** INVALID ID ******");
											}
											break;
									}
								case 0:
									break;
							}
							if(choiceadmin == 0)
							{
								break;
							}
						}
					}
					else
					{
						System.out.println("\n***** WRONG ID OR PASSWORD *****");
					}
					break;
				case 2:
					String customernamemain;
					int customeridmain;
					String customerpasswordmain;
					int customeridtransfer;
					int customerchoicemain;
					int flagcus = 0;
					float balancemain;

					System.out.println("\nEnter customer username: ");
					customernamemain = s.next();
					System.out.println("Enter customer ID: ");
					customeridmain = s.nextInt() - 1000;
					System.out.println("Enter customer password: ");
					customerpasswordmain = s.next();
					try
					{
						if(customernamemain.equalsIgnoreCase(c[customeridmain].customername) && customerpasswordmain.equals(c[customeridmain].customerpassword))
						{
							System.out.println("");
							for(y=0;y<39;y++)
							{
								System.out.print("-");
							}
							System.out.print("CUSTOMER LOGIN SUCCESFUL");
							for(y=0;y<39;y++)
							{
								System.out.print("-");
							}
							System.out.println("\n");					

							while(true)
							{
								System.out.println("");
								for(y=0;y<44;y++)
								{
									System.out.print("-");
								}
								System.out.print("CUSTOMER  PAGE");
								for(y=0;y<44;y++)
								{
									System.out.print("-");
								}
								System.out.println("\n");					
	
								System.out.println("1 ----- Check Balance");
								System.out.println("2 ----- Withdraw");
								System.out.println("3 ----- Deposit");
								System.out.println("4 ----- Transfer");
								System.out.println("0 ----- Back to Main Menu");
								System.out.println("\nEnter your choice: ");
								customerchoicemain = s.nextInt();
								switch(customerchoicemain)
								{
									case 1:
										System.out.println("\nYour balance is: " + c[customeridmain].balance);
										break;
									case 2:
										System.out.println("\nEnter the amount to withdraw: ");
										c[customeridmain].withdraw = s.nextFloat();
										if(c[customeridmain].withdraw < 0)
										{
											System.out.println("\n***** ENTER VALID AMOUNT ******");
											break;
										}
										if(c[customeridmain].balance - c[customeridmain].withdraw < 5000)
										{
											System.out.println("\n****** ENTER LESSER AMOUNT ******");
										}
										else
										{
											System.out.println("\n****** WITHDRAWN SUCCESSFULLY ******");
											c[customeridmain].balance = c[customeridmain].balance - c[customeridmain].withdraw;
											System.out.println("\nYour balance is: " + c[customeridmain].balance);
										}
										File f1 = new File("D:\\Coding\\Java\\Bank\\" + customernamemain);
										FileOutputStream fos1 = new FileOutputStream(f1);
										ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
										oos1.writeObject(c[customeridmain]);
										oos1.close();
										fos1.close();
										FileInputStream fis1 = new FileInputStream(f1);
										ObjectInputStream ois1 = new ObjectInputStream(fis1);
										ois1.close();
										fis1.close();
										break;
									case 3:
										System.out.println("\nEnter the amount to deposit: ");
										c[customeridmain].deposit = s.nextFloat();
										if(c[customeridmain].deposit < 0)
										{
											System.out.println("\n***** ENTER VALID AMOUNT ******");
											break;
										}
										else
										{
											System.out.println("\n***** DEPOSITED SUCCESSFULLY ******");
											c[customeridmain].balance = c[customeridmain].balance + c[customeridmain].deposit;
											System.out.println("\nYour balance is: " + c[customeridmain].balance);
										}
										File f2 = new File("D:\\Coding\\Java\\Bank\\" + customernamemain);
										FileOutputStream fos2 = new FileOutputStream(f2);
										ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
										oos2.writeObject(c[customeridmain]);
										oos2.close();
										fos2.close();
										FileInputStream fis2 = new FileInputStream(f2);
										ObjectInputStream ois2 = new ObjectInputStream(fis2);
										ois2.close();
										fis2.close();
										break;
									case 4:
										int flagt = 0;
										System.out.println("\nEnter the customer id to which you want to transfer: ");
										customeridtransfer = s.nextInt() - 1000;
										int customeridtransfertemp = customeridtransfer + 1000;	
										for(int i=0;i<Customer.customercount;i++)
										{
											if(customeridtransfertemp == (c[i].customerid))
											{
												flagt = 1;
												break;
											} 
										}
										if(flagt == 1)
										{
											System.out.println("\nEnter the amount to transfer: ");
											balancemain = s.nextFloat();
											if(c[customeridmain].balance - balancemain < 5000)
											{
												System.out.println("\n***** ENTER LESSER AMOUNT *****");
											}	
											else
											{
												c[customeridtransfer].balance = c[customeridtransfer].balance + balancemain;
												c[customeridmain].balance = c[customeridmain].balance - balancemain;
												System.out.println("\n****** TRANSFERED SUCCESSFULLY *****");
												System.out.println("\nYour balance is: " + c[customeridmain].balance);
											}
										}
										else
										{
											System.out.println("\n***** ID INVALID *****");
										}
										File f3 = new File("D:\\Coding\\Java\\Bank\\" + customernamemain);
										FileOutputStream fos3 = new FileOutputStream(f3);
										ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
										oos3.writeObject(c[customeridmain]);
										oos3.close();
										fos3.close();
										FileInputStream fis3 = new FileInputStream(f3);
										ObjectInputStream ois3 = new ObjectInputStream(fis3);
										ois3.close();
										fis3.close();
										break;
									case 0:
										break;
								}
								if(customerchoicemain == 0)
								{
									break;
								}
							}
						}
						else
						{
						System.out.println("\n***** WRONG ID OR PASSWORD ******");
						}
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("***** ID INVALID *****");		
					}
					break;
				case 0:
					System.exit(0);
					break;
			}
		}
	}
}