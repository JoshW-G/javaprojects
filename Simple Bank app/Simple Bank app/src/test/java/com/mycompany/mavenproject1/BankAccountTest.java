package com.mycompany.mavenproject1;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void testBankAccount() {
		BankAccount test = new BankAccount(4);
		assertNotNull(test);
	}
	@Test
	public void testGetBalance() throws SQLException {
		BankAccount test = new BankAccount(1);
		double expected = 0;
		assertEquals(expected, test.getBalance(), 0.001);
	}
	
	@Test
	public void testDeposit() throws SQLException {
		BankAccount test = new BankAccount(1);
		double expected = 200;
		test.deposit(200);
		assertEquals(expected,test.getBalance(),0.001);
	}
	
	@Test
	public void testWithdraw() throws SQLException {
		BankAccount test = new BankAccount(1,200);	
		double expected = 0;
		test.withdraw(200);
		assertEquals(expected, test.getBalance(), 0.001);
		
	}
	@Test
	public void testTransfer() throws SQLException {
		BankAccount test1 = new BankAccount(1,400);
		BankAccount test2 = new BankAccount(3);
		test1.transfer(test2, 400);
		assertEquals(400, test2.getBalance(), 0.001);
	}
	

}
