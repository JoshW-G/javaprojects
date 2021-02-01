package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
   A bank account has a balance that can be changed by
   deposits and withdrawals.
*/
public class BankAccount
{

   private int accountNumber;
   private double balance;

   /**
      Constructs a bank account with a given balance.
      @param anAccountNumber the account number
   */
   public BankAccount(int anAccountNumber)
   {
      accountNumber = anAccountNumber;
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param anAccountNumber the account number
      @param startingBalance the starting balance
   */
   public BankAccount(int anAccountNumber, double startingBalance)
   {
      accountNumber = anAccountNumber;
      balance = startingBalance;
   }

   /**
      Deposits money into a bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
      throws SQLException
   {
      balance = balance + amount;
   }

   /**
      Withdraws money from a bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
      throws SQLException
   {
      balance = balance - amount;
   }

   /**
      Gets the balance of a bank account.
      @return the account balance
   */
   public double getBalance()
      throws SQLException
   {
      return balance;
   }
   

   /**
    * Transfers money from this bank account to other bank.
    * @param other the bank account to transfer money to
    * @param amount the amount to transfer
    * @throws SQLException 
    */
   public void transfer(BankAccount other, double amount) throws SQLException {
     withdraw(amount);
     other.deposit(amount);
   }

}