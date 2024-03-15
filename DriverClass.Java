//unit5.hw
 
//Group members: Isaac Calisto, Ethan Niessener


//Group members: Isaac Calisto, Ethan Niessner
//imports... main
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
	
	String name;
	String id;
	
  int crnArray [] = {4587, 4599, 8997, 9696, 4580, 2599, 
  1997, 5696, 7587, 1599, 6997, 2696, 5580, 2099, 4997, 3696};


  //---------------------------
 main

  String courseArray [] = {"MAT 236", "COP 220", "GOL 124", "COP 100", "MAT 136", "COP 260", "CAP 424",
  "KOL 110", "MAT 936", "COP 111", "GOL 109", "COP 101", "MAT 636", "COP 268", "CAP 427", "KOL 910"};

  int creditHoursArray [] = {4, 3, 1, 3, 1, 3, 1, 2, 5, 3, 1, 3, 2, 3, 1, 2};
  
  public Student ( String name , String id) {
    this.name = name;
    this.id = id;
  }
  abstract public void printInvoice();
}
//---------------------------

class UndergraduateStudent extends Student{

	float cost = 0, total = 0, discount = 0;
	int [] undergradCrnsTaken, creditHours;
	int arrayLength;
	double gpa;
	boolean resident;
	
  public UndergraduateStudent(String name , String id , int [] undergradCrnsTaken , double gpa, boolean resident){
    super (name , id );
    this.gpa = gpa;
    this.undergradCrnsTaken = undergradCrnsTaken;
    creditHours = new int[undergradCrnsTaken.length];
    arrayLength = undergradCrnsTaken.length;
    this.resident = resident;
  }
  @Override
  public void printInvoice() {
	  
	for (int i = 0; i < undergradCrnsTaken.length; i++) {
		for (int j = 0; j < crnArray.length; j++) {
			if (undergradCrnsTaken[i] == crnArray[j]) {
				creditHours[i] = creditHoursArray[j];
			}
		}
	}
	 
	System.out.println("VALENCE COLLEGE");
	System.out.println("ORLANDO FL 10101");
	System.out.println("---------------------");
	System.out.println("\nFee Invoice Prepared for Student:");
	if (resident == false) {
		System.out.println(id + "-" + name);
		System.out.println("\n1 Credit Hour = $240.50\n");
		cost = (float)240.50;
	}
	else {
		System.out.println(id + "-" + name);
		System.out.println("\n1 Credit Hour = $120.25\n");
		cost = (float)120.25;
	}
	System.out.println("CRN\tCR_PREFIX\tCR_HOURS");
	for (int i = 0; i < arrayLength; i++) {
		System.out.printf(undergradCrnsTaken[i] + "\t" + creditHours[i] + "\t\t$ %.2f\n", (cost*creditHours[i]));
		total += cost*creditHours[i];
	}
	
	if (gpa >= 3.5) {
		discount = total * (float)0.25;
	}
	
	System.out.println("\t\t  Health & id fees  $ 35.00");
	System.out.println("-------------------------------------------");
	System.out.printf("\t\t\t$ %.2f\n", total);
	System.out.printf("\t\t       -$ %.2f\n", discount);
	System.out.println("\t\t      ----------");
	System.out.printf("      TOTAL PAYMENTS    $ %.2f", (total - discount + 35));
  }
}
//---------------------------

abstract class GraduateStudent extends Student {
// . . .
  public GraduateStudent ( String name , String id , int crn ) {
    //crn is the crn that the grad student is a teaching assistant for
    super ( name , id );
    
 
  }
}
//--------------------------

class PhdStudent extends GraduateStudent {
  // . . .
  public PhdStudent (String name, String id , String advisor, String researchSubject , int crn ) {
    //crn is the course number that the Phd student is a teaching assistant for
    super ( name , id , crn );
    // . . .
  }
  @Override
  public void printInvoice() {
	System.out.println("VALENCE COLLEGE");
	System.out.println("ORLANDO FL 10101");
	System.out.println("---------------------");
	System.out.println("\nFee Invoice Prepared for Student:");
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
    System.out.println("VALENCE COLLEGE");
    System.out.println("ORLANDO FL 10101");
    System.out.println("---------------------");
    System.out.println("\nFee Invoice Prepared for Student:");
    System.out.println();
  }
}

    private String studentName, studID;

    public Student ( String name , String id) {
      this.studentNameame = name;
      this.studID = id;
    }
    abstract public void printInvoice();
  

  //---------------------------

  class UndergraduateStudent extends Student{
    
    private String studentName, id;
    private int [] undergradCrnsTaken;
    private double gpa;
    private boolean resident;


    public UndergraduateStudent(String name , String id , int [] undergradCrnsTaken , double gpa, boolean resident){
      super (name , id );
      this.gpa = gpa;
      this.resident = resident;
      this.undergradCrnsTaken = undergradCrnsTaken;
    }

    @Override
    public void printInvoice() {
      System.out.println("VALENCE COLLEGE");
      System.out.println("ORLANDO FL 10101");
      System.out.println("----------------------");
      System.out.println();
      System.out.println("Fee Invoice Prepared for Student: ");

    }
  }

  //---------------------------

  abstract class GraduateStudent extends Student {
    
    private String studentName, id;
    private int TA;


    public GraduateStudent ( String name , String id, int crn ) {
      //crn is the crn that the grad student is a teaching assistant for
      super ( name , id);
      this.TA = crn;

    }
  }

  //---------------------------

  class PhdStudent extends GraduateStudent {
    private String studentName, id, advisor, researchSubject;
    private int TA;

    public PhdStudent (String name, String id , String advisor, String researchSubject , int crn ) {
      //crn is the course number that the Phd student is a teaching assistant for
      super ( name , id , crn);
      this.researchSubject = researchSubject;
      this.advisor = advisor;
    }
    @Override
    public void printInvoice() {
       System.out.println("VALENCE COLLEGE");
      System.out.println("ORLANDO FL 10101");
      System.out.println("----------------------");
      System.out.println();
      System.out.println("Fee Invoice Prepared for Student: ");
      
    }
  }

  //---------------------------

  class MsStudent extends GraduateStudent {
    private String studentName, id;
    private int [] gradCrnsTaken;
    private int TA;

    public MsStudent (String name, String id , int [] gradCrnsTaken , int crn ) {
      // gradCoursesTaken is the array of the crns that the Ms student is taking
      //crn is the course number that the Phd student is a teaching assistant for
      super ( name , id , crn);
      this.gradCrnsTaken = gradCrnsTaken;
    }

    @Override
    public void printInvoice() {
      System.out.println("VALENCE COLLEGE");
      System.out.println("ORLANDO FL 10101");
      System.out.println("----------------------");
      System.out.println();
      System.out.println("Fee Invoice Prepared for Student: ");
      
    }
  }

