package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Scanner;

public class Demo {
    WebDriver driver;
   public static void main(String []args) {
       Demo d=new Demo();
       d.show();
//       Scanner sc=new Scanner(System.in);
//       Demo d=new Demo();
//       d.show();
//
//       //Factorial
//       int number = 8;
//       int a = 1;
//       for (int i = 1; i <= number; i++) {
//           a = a * i;
//       }
//       System.out.println("Factorial of "+number+" is: "+a);
   }

   public void show(){
       int a=10;
       int b=20;
       String x="hello";
       String y="connections";
       System.out.println(a+b+x+y);
   }
}


