package vn.fpt.fsoft.hcd.g0;

public class View {
        //Message 1
        static final String MSG1 = 
        		"Field cannot be blank!\nPlease input again: ";
        //Message 2
        static final String MSG2 = 
        		"This class has already existed!\n";
        //Message 3
        static final String MSG3 = 
        	"Action successfully operated.\nPress <Enter> to go back\n";
        //Message 4
        static final String MSG4 = 
        		"There is no such class\n";
        //Message 5
        static final String MSG5 = 
        		"This class is not empty.\nCan not delete!\n";
        //Message 6
        static final String MSG6 = 
        		"This subject has already existed!\n";
        //Message 7
        static final String MSG7 = "There is no such subject!\n";
        //Message 8
        static final String MSG8 = "This student has already existed!\n";
        //Message 9
        static final String MSG9 = "There is no such student!\n";
        //Message 10
        static final String MSG10 = "Invalid choice!\nPlease input again: ";
        //Message 11
        static final String MSG11 = "The number must be between 1 and 10: ";
        //Message 12
        static final String MSG12 = "This grade has already inputted!\n";
        //Message 13
        static final String MSG13 = "Invalid Input!Must be a number.\n" +
        		"Please input again: ";
        
        //Show message
        public static void showMessage(String msg) {
                System.out.print(msg);
        }
        
        //Show main menu
        public void showMainMenu() {
                System.out.println();
                System.out.println
                ("--------Student Management Application--------");
                System.out.println();
                System.out.println("Choose an option: ");
                System.out.println();
                System.out.println("1.Class Manage");
                System.out.println("2.Subject Manage");
                System.out.println("3.Student Manage");
                System.out.println("4.Report");
                System.out.println("5.Quit");
        }
        
        //Show class menu
        public void showClassMenu() {
                System.out.println();
                System.out.println
                ("--Student Management Application Manage Class--");
                System.out.println();
                System.out.println("Choose an option: ");
                System.out.println();
                System.out.println("1.Add New Class");
                System.out.println("2.Update Class");
                System.out.println("3.Delete Class");
                System.out.println("4.List All Classes");
                System.out.println("5.Quit");
        }
        
        //Show subject menu
        public void showSubjectMenu() {
                System.out.println();
                System.out.println
                ("--Student Management Application Manage Subject--");
                System.out.println();
                System.out.println("Choose an option: ");
                System.out.println();
                System.out.println("1.Add New Subject");
                System.out.println("2.Update Subject");
                System.out.println("3.Delete Subject");
                System.out.println("4.List All Subjects");
                System.out.println("5.Quit");
        }
        
        //Show student menu
        public void showStudentMenu() {
                System.out.println();
                System.out.println
                ("--Student Management Application Manage Student--");
                System.out.println();
                System.out.println("Choose an option: ");
                System.out.println();
                System.out.println("1.Add New Student");
                System.out.println("2.Update Student");
                System.out.println("3.Delete Student");
                System.out.println("4.Input Student Grade");
                System.out.println("5.Quit");
        }
        
//        Show report menu
        public void showReportMenu() {
                System.out.println();
                System.out.println
                ("--Student Management Application Report Functions--");
                System.out.println();
                System.out.println("Choose an option: ");
                System.out.println();
                System.out.println("1.Search Student");
                System.out.println("2.List Student by Class");
                System.out.println("3.List Excellent Student");
                System.out.println("4.List Low GPA Student");
                System.out.println("5.Quit");
        }
        
        //Show add class
        public void showAddClass() {
                System.out.println();
                System.out.println
                ("--------Student Management Application--------");
                System.out.println();
                System.out.println("Add New Class");
                System.out.print("Input Class ID: ");
        }
        
        //Show update class
        public void showUpdateClass() {
                System.out.println();
                System.out.println
                ("--------Student Management Application--------");
                System.out.println();
                System.out.println("Update Class");
                System.out.print("Select Class: ");
        }
        
//        Show delete class
        public void showDeleteClass() {
                System.out.println();
                System.out.println
                ("--------Student Management Application--------");
                System.out.println();
                System.out.println("Delete Class");
                System.out.print("Select Class: ");
        }
        
//        Show list all class
        public void showListAllClass() {
                System.out.println();
                System.out.println
                ("--------Student Management Application--------");
                System.out.println();
                System.out.println("List All Classes");
                System.out.println();
        }
        
//        Show search student
        public void showSearchStudent() {
                System.out.println();
                System.out.println
                ("--------Student Management Application--------");
                System.out.println();
                System.out.println("Search Student");
                System.out.print("Input String: ");
        }
        
//        Show input student grade
        public void showInputStudentGrade() {
                System.out.println();
                System.out.println
                ("--------Student Management Application--------");
                System.out.println();
                System.out.print("Input Student Grade: ");
        }
        
}
