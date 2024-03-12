//unit5.hw
//Group members: Isaac Calisto, Ethan Niessener
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
    String crnArray [] = {"4587", "4599", "8997", "9696", "4580", "2599", 
    "1997", "5696", "7587", "1599", "6997", "2696", "5580", "2099", "4997", "3696"};

    String courseArray [] = {"MAT 236", "COP 220", "GOL 124", "COP 100", "MAT 136", "COP 260", "CAP 424",
    "KOL 110", "MAT 936", "COP 111", "GOL 109", "COP 101", "MAT 636", "COP 268", "CAP 427", "KOL 910"};

    String creditHoursArray [] = {"4", "3", "1", "3", "1", "3", "1", "2", "5", "3", "1", "3", "2", "3", "1", "2"};
    
    public Student ( String name , String id) {
      // . . .
    }
    abstract public void printInvoice();
  }
  //---------------------------
  class UndergraduateStudent extends Student{
    // . . .
    public UndergraduateStudent(String name , String id , int [] undergradCrnsTaken , double gpa, boolean resident){
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