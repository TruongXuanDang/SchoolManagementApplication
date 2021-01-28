package vn.fpt.fsoft.hcd.g0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controller {
//        lower boundary value
        private static final int LOWER_BOUNDARY_VALUE = 1;
//        upper boundary value
		private static final int UPPER_BOUNDARY_VALUE = 5;
//		maximum age
		private static final int MAXIMUM_AGE = 10;

        //Get choice
		public int getChoice() {
                System.out.print("Your option is: ");
                
                int choice = 0;
                boolean flag = false;
                
                while(flag) {
                        Scanner sc = new Scanner(System.in);
                        String input = sc.nextLine();
                        flag = true;
                        try {
                                choice = Integer.parseInt(input);
                        } catch (Exception e){
                                View.showMessage(View.MSG10);
                                flag = false;
                        }
                        if((choice >UPPER_BOUNDARY_VALUE 
                        		|| choice < LOWER_BOUNDARY_VALUE) 
                        		&& (choice != 0)){
                                View.showMessage(View.MSG10);
                                flag = false;
                        }
                }
                return choice;
        }
        
        //Get input
        public String getInput() {
                boolean flag = false;
                String input = null;
                Scanner sc = new Scanner(System.in);
                
                while(flag){
                        flag = true;
                        input = sc.nextLine();
                        if (input.equals("")) {
                                View.showMessage(View.MSG1);
                                flag = false;
                        }
                }
                return input;
        }
        
        //Get confirm
        public String getConfirm() {
                boolean flag = false;
                String input = null;
                Scanner sc = new Scanner(System.in);
                
                while(flag){
                        flag = true;
                        input = sc.nextLine();
                        if (input.equals("")) {
                                View.showMessage(View.MSG1);
                                flag = false;
                        }
                        if (!(input.toLowerCase().equals("y") 
                        		|| input.toLowerCase().equals("n"))) {
                                View.showMessage(View.MSG10);
                                flag = false;
                        }
                }
                return input.toUpperCase();
        }
        
        //Wait key press
        public boolean waitKeyPress() {
        	try {
	        		BufferedReader in = new BufferedReader
	        			(new InputStreamReader(System.in));
	        		int key = in.read();
	        		if(key != -1) {
	        			return true;
	        		}
	        	} catch(IOException io) {
        		io.printStackTrace();
        	}
        	
        	return false;
        }
        
        //Get grade
        public String getGrade() {
                boolean flag = false;
                String input = null;
                Scanner sc = new Scanner(System.in);
                int grade = -1;
                
                while(flag){
                        flag = true;
                        input = sc.nextLine();
                        if (input.equals("")) {
                                View.showMessage(View.MSG1);
                                flag = false;
                                continue;
                        }
                        
                        try {
                                grade = Integer.parseInt(input);
                        } catch(Exception e) {
                                View.showMessage(View.MSG13);
                                flag = false;
                                continue;
                        }
                        
                        if(grade > MAXIMUM_AGE || grade < 0) {
                                View.showMessage(View.MSG11);
                                flag = false;
                                continue;
                        }
                }
                return input;
        }
}
