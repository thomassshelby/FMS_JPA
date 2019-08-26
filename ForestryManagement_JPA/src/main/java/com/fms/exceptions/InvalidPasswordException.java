package com.fms.exceptions;

public class InvalidPasswordException extends RuntimeException{
	 public InvalidPasswordException(){
		 System.out.println("Enter valid Password");
	 }
}
