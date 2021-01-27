package vn.fpt.fsoft.hcd.g0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Model {
    //ID Position
        private static final int ID_POSITION = 5;
        //Class file path
		static final String CLASS_FILE_PATH = ".\\Data\\class.txt";
        //Student file path
        static final String STUDENT_FILE_PATH = ".\\Data\\student.txt";
        //Subject file path
        static final String SUBJECT_FILE_PATH = ".\\Data\\subject.txt";
        //Grade file path
        static final String GRADE_FILE_PATH = ".\\Data\\grade.txt";
        //Is existed class
        public boolean isExistedClass(String identification) {
                
                try{
                        FileReader fr = new FileReader(CLASS_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        
                        while((line = br.readLine()) != null) {
                                if ((identification.toLowerCase()).equals(line.split("_")[0].toLowerCase())) {
                                        return true;
                                }
                        }
                } catch(FileNotFoundException f) {
                        f.printStackTrace();
                } catch(IOException io) {
                        io.printStackTrace();
                }
                
                return false;
        }
        
        //Is empty class
        public boolean isEmptyClass(String identification) {
                
                try{
                        FileReader fr = new FileReader(STUDENT_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        
                        while((line = br.readLine()) != null) {
                                if ((identification.toLowerCase()).equals(line.split("_")[ID_POSITION].toLowerCase())) {
                                        return false;
                                }
                        }
                } catch(FileNotFoundException f) {
                        f.printStackTrace();
                } catch(IOException io) {
                        io.printStackTrace();
                }
                
                return true;
        }
        
        //Is existed student
        public boolean isExistedStudent(String identification) {
                
                try{
                        FileReader fr = new FileReader(STUDENT_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        
                        while((line = br.readLine()) != null) {
                                if ((identification.toLowerCase()).equals(line.split("_")[0].toLowerCase())) {
                                        return true;
                                }
                        }
                } catch(FileNotFoundException f) {
                        f.printStackTrace();
                } catch(IOException io) {
                        io.printStackTrace();
                }
                
                return false;
        }
        
        //Is existed subject
        public boolean isExistedSubject(String identification) {
                
                try{
                        FileReader fr = new FileReader(SUBJECT_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        
                        while((line = br.readLine()) != null) {
                                if ((identification.toLowerCase()).equals(line.split("_")[0].toLowerCase())) {
                                        return true;
                                }
                        }
                } catch(FileNotFoundException f) {
                        f.printStackTrace();
                } catch(IOException io) {
                        io.printStackTrace();
                }
                
                return false;
        }
        
        //Is existed grade
        public boolean isExistedGrade(String studentID, String subjectID) {
                
                try{
                        FileReader fr = new FileReader(GRADE_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        
                        while((line = br.readLine()) != null) {
                                if ((studentID.toLowerCase()).equals(line.split("_")[0].toLowerCase())
                                     && subjectID.toLowerCase().equals(line.split("_")[1].toLowerCase())) {
                                        return true;
                                }
                        }
                } catch(FileNotFoundException f) {
                        f.printStackTrace();
                } catch(IOException io) {
                        io.printStackTrace();
                }
                
                return false;
        }
        
        //Add class to file
        public void addClassToFile(String identification, String userName) {
        	
        	try {
        	        FileWriter fw = new FileWriter(CLASS_FILE_PATH,true);
        		    BufferedWriter bw = new BufferedWriter(fw);
        		    bw.newLine();
        		    bw.append(identification.toUpperCase()+"_"+userName.toUpperCase());
    			    bw.close();
        	} catch(FileNotFoundException f) {
                    f.printStackTrace();
            } catch(IOException io) {
                    io.printStackTrace();
            }
        	
        }
        
        //Rename class
        public void renameClass(String identification, String name) {
                
                try {
                        FileReader fr = new FileReader(CLASS_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        ArrayList<String> lineList = new ArrayList<String>();
                        String line;
                        
                        while((line = br.readLine()) != null) {
                            lineList.add(line);
                        }
                        br.close();
                        PrintWriter pr = new PrintWriter(CLASS_FILE_PATH);
                        for(int i=0; i < lineList.size() ;i++){
                            line = lineList.get(i);
                            if(line.split("_")[0].toLowerCase().equals(identification.toLowerCase())) {
                                line= identification.toUpperCase() + "_" + name.toUpperCase();
                            }
                            pr.println(line);
                        }
                        pr.flush();
                        pr.close();
                } catch(FileNotFoundException f) {
                        f.printStackTrace();
                } catch(IOException io) {
                        io.printStackTrace();
                }
                
        }
        
        //Delete class
        public void deleteClass(String identification) {
                
                try {
                        FileReader fr = new FileReader(CLASS_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        ArrayList<String> lineList = new ArrayList<String>();
                        String line;
                        
                        while((line = br.readLine()) != null) {
                            lineList.add(line);
                        }
                        br.close();
                        PrintWriter pr = new PrintWriter(CLASS_FILE_PATH);
                        for(int i=0; i < lineList.size() ;i++){
                            line = lineList.get(i);
                            if(line.split("_")[0].toLowerCase().equals(identification.toLowerCase())) {
                                continue;
                            }
                            pr.println(line);
                        }
                        pr.flush();
                        pr.close();
                } catch(FileNotFoundException f) {
                        f.printStackTrace();
                } catch(IOException io) {
                        io.printStackTrace();
                }
        }
        
        //List all class
        public void listAllClass() {
                try{
                        FileReader fr = new FileReader(CLASS_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        while((line = br.readLine()) != null) {
                                View.showMessage(line.split("_")[0] + " " + line.split("_")[1] + "\n");
                        }
                } catch(Exception e){
                        e.printStackTrace();
                }
        }
        
        //Search student
        public void searchStudent(String keyword) {
                
                try {
                        FileReader fr = new FileReader(STUDENT_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        
                        View.showMessage("Result\n");
                        while((line = br.readLine()) != null) {
                                if (line.split("_")[1].toLowerCase().contains(keyword.toLowerCase())) {
                                        View.showMessage(line.split("_")[1] + "\n");
                                }
                        }
                } catch(FileNotFoundException f) {
                        f.printStackTrace();
                } catch(IOException io) {
                        io.printStackTrace();
                }
        }
        
        //Add grade to file
        public void addGradeToFile(String studentID, String subjectID, String grade) {
                
                try {
                        FileWriter fw = new FileWriter(GRADE_FILE_PATH,true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.newLine();
                        bw.append(studentID.toUpperCase() + "_" + subjectID.toUpperCase() + "_" + grade);
                        bw.close();
                } catch(FileNotFoundException f) {
                        f.printStackTrace();
                } catch(IOException io) {
                        io.printStackTrace();
                }
                
            }

}
