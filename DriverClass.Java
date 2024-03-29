//Unit5.hw
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
    
    int[] crnArray  = {4587, 4599, 8997, 9696, 4580, 2599, 
    1997, 5696, 7587, 1599, 6997, 2696, 5580, 2099, 4997, 3696};
    
   
    //---------------------------
   
  
    String[] courseArray  = {"MAT 236", "COP 220", "GOL 124", "COP 100", "MAT 136", "COP 260", "CAP 424",
    "KOL 110", "MAT 936", "COP 111", "GOL 109", "COP 101", "MAT 636", "COP 268", "CAP 427", "KOL 910"};
  
    int[] creditHoursArray  = {4, 3, 1, 3, 1, 3, 1, 2, 5, 3, 1, 3, 2, 3, 1, 2};

   
    
    public Student ( String name , String id) {
      this.name = name;
      this.id = id;
    }
    abstract public void printInvoice();
  }
  //---------------------------
  
  class UndergraduateStudent extends Student{
  
    double cost = 0.0, total = 0.0, discount = 0.0;
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
      System.out.printf(undergradCrnsTaken[i] + "\t" +courseArray[i] + "\t\t" +creditHours[i] + "\t    $ %.2f\n", (cost*creditHours[i]));
      total += cost*creditHours[i];
    }
    
    if (gpa >= 3.5) {
      discount = total * (float)0.25;
    }
    System.out.println();
    System.out.println("\t\t  Health & id fees  $ 35.00");
    System.out.println();
    System.out.println("---------------------------------------------");
    System.out.printf("\t\t\t\t    $ %.2f\n", total);
    System.out.printf("\t\t\t           -$ %.2f\n", discount);
    System.out.println("\t\t\t           ----------");
    System.out.printf("\t\t TOTAL PAYMENTS     $ %.2f", (total - discount + 35));
    }
  }
  //---------------------------
  
  abstract class GraduateStudent extends Student {
  int crn;
    public GraduateStudent ( String name , String id , int crn ) {
      //crn is the crn that the grad student is a teaching assistant for
      super ( name , id );
      this.crn = crn;
  
    }
  }
  //--------------------------
  
  class PhdStudent extends GraduateStudent {
    String advisor, researchSubject;
    public PhdStudent (String name, String id , String advisor, String researchSubject , int crn ) {
      //crn is the course number that the Phd student is a teaching assistant for
      super ( name , id , crn );
      this.advisor = advisor;
      this.researchSubject = researchSubject;
    }
    @Override
    public void printInvoice() {
    System.out.println("VALENCE COLLEGE");
    System.out.println("ORLANDO FL 10101");
    System.out.println("---------------------");
    System.out.println("\nFee Invoice Prepared for Student:");
    System.out.println(id + "-" + name);
    System.out.println( );
    System.out.println("RESEARCH");
    System.out.println(researchSubject+"\t\t    $ 700.00\n");
    System.out.println("\t   Health & id fees $ 35.00");
    System.out.println( );
    System.out.println("----------------------------------");
    System.out.println("\tTotal Payments      $ 735.00");
    System.out.println( );


    }
  }
  //---------------------------
  
  class MsStudent extends GraduateStudent {
    int [] gradCrnsTaken;
    double cost = 0.0, total = 0.0;
    int arrayLength;
    int flag = -1;
    int len = creditHoursArray.length;
   
    
    public MsStudent (String name, String id , int [] gradCrnsTaken , int crn ) {
      // gradCoursesTaken is the array of the crns that the Ms student is taking
      //crn is the course number that the Phd student is a teaching assistant for
      super ( name , id , crn );
      this.gradCrnsTaken = gradCrnsTaken;
      arrayLength = gradCrnsTaken.length;
      for (int i = 0; i<len; i++){
        if (crn == crnArray[i])
          flag = i;
      }
    }
     
    
    

    @Override
    public void printInvoice() {
      System.out.println("VALENCE COLLEGE");
      System.out.println("ORLANDO FL 10101");
      System.out.println("---------------------");
      System.out.println("\nFee Invoice Prepared for Student:");
      System.out.println( );

      
      System.out.println(id + "-" + name);
      System.out.println("\n1 Credit Hour = $300.00\n");
      cost = (float)300.00;

      System.out.println("CRN\tCR_PREFIX\tCR_HOURS");
      System.out.println(crnArray[flag]+"\t"+ courseArray[flag]+"\t"+"\t"+creditHoursArray[flag]+ "\t    $ "+ cost*creditHoursArray[flag]);
      total += cost*creditHoursArray[flag];
      System.out.println( );
      System.out.println("\t\t  Health & id fees  $ 35.00");
      System.out.println( );
      System.out.println("---------------------------------------------");
      System.out.printf("\t    TOTAL PAYMENTS          $ %.2f", (total+35.00));
      System.out.println( );
      System.out.println();
    }
  }
  

  
  
