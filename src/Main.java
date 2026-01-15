import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
StudentDB sdb = new StudentDB();
boolean choice= true;
        Scanner scanner = new Scanner(System.in);
  while (choice){
      System.out.println("\n--- Student Management System ---");
      System.out.println("1. Add Student");
      System.out.println("2. Delete Student");
      System.out.println("3. Update Student");
      System.out.println("4. Get Student");
      System.out.println("5. List Students");
      System.out.println("6. Exit");
      System.out.print("Choose option: ");
      int option = scanner.nextInt();
      if (option == 1){
          System.out.println("Enter new student id");
          int addId = scanner.nextInt();
          scanner.nextLine(); // consume leftover newline

          System.out.println("Enter new student name");
          String addName = scanner.nextLine();

          System.out.println("Enter new student email");
          String addEmail = scanner.nextLine();

          sdb.addStudent(new Student(addId,addName,addEmail));
      }
      else if (option==2) {
          System.out.println("Enter new student id");
          int UpId = scanner.nextInt();
          scanner.nextLine(); // consume leftover newline

          System.out.println("Enter new student name");
          String UpName = scanner.nextLine();

          System.out.println("Enter new student email");
          String UpEmail = scanner.nextLine();
          sdb.updateStudent(UpId,UpName,UpEmail);
      }
      else if (option==3) {
          System.out.println("Enter student id to delete the student");
          int delId = scanner.nextInt();

          sdb.studentDelete(delId);
      }
      else if (option==4) {
          System.out.println("Enter student id to get the student");
          int getStud = scanner.nextInt();
          Student s = sdb.getStudent(getStud);
          System.out.println("Student id : " + s.getId());
          System.out.println("Student name : " +s.getSname());
          System.out.println("Student email : " + s.getSemail());


      }
      else if (option == 5) {
          List<Student> list = sdb.getAllStudents();
          for (Student s : list) {
              System.out.println(
                      "ID: " + s.getId() +
                              ", Name: " + s.getSname() +
                              ", Email: " + s.getSemail()
              );
          }
      }
else if (option==6){
    choice=false;
          System.out.println("Exist...");
      }
else {
          System.out.println("not valid");
      }
  }
    }

}