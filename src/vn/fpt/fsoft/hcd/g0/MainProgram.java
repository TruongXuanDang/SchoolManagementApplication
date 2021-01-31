package vn.fpt.fsoft.hcd.g0;

public class MainProgram {
		/**
		 * Represents Other choice.
		 */ 
        private static final int OTHER_CHOICE = 5;
        /**
		 * List all choice.
		 */ 
		private static final int LIST_ALL_CHOICE = 4;
		/**
		 * Other manage choice.
		 */ 
		private static final int OTHER_MANAGE_CHOICE = 5;
		/**
		 * Manage report choice.
		 */
		private static final int MANAGE_REPORT_CHOICE = 4;
		/**
		 * Manage student choice.
		 */
		private static final int MANAGE_STUDENT_CHOICE = 3;
		/**
		 * Delete choice.
		 */
		private static final int DELETE_CHOICE = 3;
		/**
		 * Screen.
		 */
		static View screen = new View();
		/**
		 * Control.
		 */
        static Controller control = new Controller();
        /**
		 * Connector.
		 */
        static Model connector = new Model();
        
        /**
		 * Main function.
		 * @param args
		 */
	public static void main(String[] args) {
	        
	        startUp();
	}
	
	/**
	 * Represents start up function.
	 */ 
	public static void startUp() {
	            screen.showMainMenu();
                int choice =  control.getChoice();
                
                switch(choice) {
                case 1: // manage class
                	screen.showClassMenu();
        	        int choice1= control.getChoice();
        	        
        	        switch(choice1) {
	        	        case 1: addNewClass();
	        	                break;
	        	        case 2: updateClass();
	        	                break;
	        	        case DELETE_CHOICE: deleteClass();
	        	                break;
	        	        case LIST_ALL_CHOICE: listAllClass();
	        	                break;
	        	        case OTHER_CHOICE: System.exit(0);
	                        break;
					default:
						break;
        	        }
        	         break ;
                case 2: // manage subject
                	 screen.showSubjectMenu();
         	        int choice2 = control.getChoice();
         	        
         	        switch(choice2) {
	         	        case 1: addNewSubject();
	         	                break;
	         	        /*case 2: updateSubject();
	         	                break;
	         	        case 3: deleteSubject();
	         	                break;
	         	        case 4: listAllSubject();
	         	                break;
	         	        case 5: System.exit(0);
	         	                break;*/
					default:
						break;
         	        }
                        break;
                case MANAGE_STUDENT_CHOICE: //manage student
                	  screen.showStudentMenu();
                      break;
                case MANAGE_REPORT_CHOICE: //manage report
                	    screen.showReportMenu();
                        break;
                case OTHER_MANAGE_CHOICE: System.exit(0);
                        break;
				default:
					break;
                }
	}
	
	/**
	 * Represent addNewClass function.
	 */ 
	public static void addNewClass() {
	        boolean flag = true;
	        String classID = null;
	        String className = null;
	        
	        while(flag) {
	                screen.showAddClass();
	                classID = control.getInput();
	                if ((flag == connector.isExistedClass(classID))) {
	                        View.showMessage(View.MSG2);
	                }
	        }
	        
	        View.showMessage("Input class name: ");
	        className = control.getInput();
	        connector.addClassToFile(classID, className);
	        View.showMessage(View.MSG3);
	        control.waitKeyPress();
	        startUp();
	}
	
	/**
	 * Represents updateClass function.
	 */ 
	public static void updateClass() {
		
		boolean flag = false;
		String classID = null;
		String className = null;
		
		while(!flag) {
			screen.showUpdateClass();
			classID = control.getInput();
			if (!(flag == connector.isExistedClass(classID))) {
				View.showMessage(View.MSG4);
			}
		}
			
		View.showMessage("Input new class name: ");
		className = control.getInput();
		connector.renameClass(classID, className);
		View.showMessage(View.MSG3);
                control.waitKeyPress();
                startUp();
	}
	
	/**
	 * Represents Delete class function.
	 */ 
	public static void deleteClass() {
	        
	        boolean flag = false;
	        String classID = null;
	        String confirm = null;
	        
	        while(!flag) {
	                screen.showDeleteClass();
	                classID = control.getInput();
	                flag = true;
	                
	                if (!connector.isExistedClass(classID)) {
                                View.showMessage(View.MSG4);
                                flag = false;
                        }
	                if(!connector.isEmptyClass(classID)) {
	                        View.showMessage(View.MSG5);
	                        flag = false;
	                }
	        }
	        
	        View.showMessage("Are you sure want to delete this(Y/N)? ");
	        confirm = control.getConfirm();
	        if (confirm.equals("N")) {
	                startUp();
	                return;
	        } else {
	                connector.deleteClass(classID);
	                View.showMessage(View.MSG3);
	                control.waitKeyPress();
	                startUp();
	        }
	}
	
	/**
	 * Represents List all class function.
	 */ 
	public static void listAllClass() {
	        screen.showListAllClass();
	        connector.listAllClass();
	        View.showMessage(View.MSG3);
                control.waitKeyPress();
                startUp();
	}
	
	/**
	 * Represents Add new subject function.
	 */
	public static void addNewSubject() {
	        
	}
	
	/**
	 * Represents searchStudent function.
	 */
	public static void searchStudent() {
	        
	        String keyword = null;
	        
	        screen.showSearchStudent();
	        keyword = control.getInput();
	        connector.searchStudent(keyword);
	        View.showMessage(View.MSG3);
	        control.waitKeyPress();
	        startUp();
	}
	
	/**
	 * Represents inputStudentGrade function.
	 */ 
	public static void inputStudentGrade() {
	        
	        String studentID = null;
	        String subjectID = null;
	        String grade = null;
	        boolean flag = true;
	        
	        screen.showInputStudentGrade();
	        
	        while(flag) {
	                do {
	                        View.showMessage("Select Student: ");
	                        studentID = control.getInput();
	                        if(!connector.isExistedStudent(studentID)) {
	                                View.showMessage(View.MSG9);
	                        }
	                }
	                while(!(connector.isExistedStudent(studentID)));
	                do {
	                        View.showMessage("Select subject: ");
	                        subjectID = control.getInput();
	                        if(!connector.isExistedSubject(subjectID)) {
	                                View.showMessage(View.MSG7);
	                        }
	                }
	                while(!connector.isExistedSubject(subjectID));
	                if((connector.isExistedGrade(studentID, subjectID))) {
	                        View.showMessage(View.MSG12);
	                        continue;
	                }
	                flag = false;	                
	        }
	        
	        View.showMessage("Input grade: ");
	        grade = control.getGrade();
	        connector.addGradeToFile(studentID, subjectID, grade);
	        View.showMessage(View.MSG3);
	        control.waitKeyPress();
	        startUp();
	}

}
