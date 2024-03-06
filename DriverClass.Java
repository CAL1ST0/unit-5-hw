//unit5.hw
//Group members: John Jones, Jenna Johnson, James Junaid
//imports...
public class DriverClass {
  // DO NOT CHANGE ANYTHING IN THIS CLASS (DriverClass)
  public static void main(String[] args) {
  Student s;
  //***********
  s = new PhdStudent ("Zaydoun BenSellam",
  "zb5954" ,
  "Gary Richarson",
  "Fuzzy Topology" ,
  2599 );
  s.printInvoice();
  //***********
  int [] gradCrnsTaken = {7587,8997} ;
  s = new MsStudent ( "Emily Jones",
  "em1254",
  gradCrnsTaken,
  1997);
  s.printInvoice();
  //***********
  int [] undergradCrnsTaken = {4587,2599};
  s = new UndergraduateStudent ("Jamila Jones" ,
  "ja5225" ,
  undergradCrnsTaken ,
  3.0,
  false );
  s.printInvoice();
  }//end of main
  }
  //---------------------------
  abstract class Student {
  // . . .
  public Student ( String name , String id) {
  // . . .
  }
  abstract public void printInvoice();
  }
  //---------------------------
  class UndergraduateStudent extends Student{
  // . . .
  public UndergraduateStudent(String name , String id , int [] undergradCrnsTaken , double gpa, boolean resident)
  {
  super (name , id );
  // . . .
  }
  @Override
  public void printInvoice() {
  // . . .
  }
  }
  //---------------------------
  abstract class GraduateStudent extends Student {
  // . . .
  public GraduateStudent ( String name , String id , int crn ) {
  //crn is the crn that the grad student is a teaching assistant for
  super ( name , id );
  // . . .
  }
  }
  //---------------------------
  class PhdStudent extends GraduateStudent {
  // . . .
  public PhdStudent (String name, String id , String advisor, String researchSubject , int crn ) {
  //crn is the course number that the Phd student is a teaching assistant for
  super ( name , id , crn );
  // . . .
  }
  @Override
  public void printInvoice() {
  // . . .
  }
  }
  //---------------------------
  class MsStudent extends GraduateStudent {
  // . . .
  public MsStudent (String name, String id , int [] gradCrnsTaken , int crn ) {
  // gradCoursesTaken is the array of the crns that the Ms student is taking
  //crn is the course number that the Phd student is a teaching assistant for
  super ( name , id , crn );
  // . . .
  }
  @Override
  public void printInvoice() {
  // . . .
  }
  }