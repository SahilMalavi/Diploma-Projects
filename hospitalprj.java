import java.util.*;
import java.io.*;

class demo extends Thread
{
    Scanner sc=new Scanner(System.in);
    int op,k;

    //used for clear screen
    public static void cls()
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    void login()
    {
        cls();
        Scanner sc=new Scanner(System.in);
        String myname="manthan",mypass="M@123", name,pass;

        System.out.println("\n\n\t\t___________LOGIN___________\n");
        System.out.print("\t\tEnter Username: ");
        name=sc.nextLine();
        System.out.print("\n\t\tEnter Password: ");
        pass=sc.nextLine();
        System.out.print("\t\t___________________________");

        if(myname.equalsIgnoreCase(name)&&mypass.equals(pass))
        {
            System.out.print("\n\n\t\tSUCCESSFULLY LOGIN.");
            try{
                for(int i=0;i<5;i++)
                {
                    System.out.print(".");
                    Thread.sleep(400);
                }
            }
            catch(InterruptedException e)
            {
                System.out.print("."+e);
            }
            menu();
        }
        else
        {
            try{
                System.out.println("\n\n\t Please check you username and password!\n\n");
                Thread.sleep(2400);
            }
            catch(InterruptedException e)
            {
                System.out.println("\n\t"+e);
            }
            login() ;
        }
    }
    void menu()
    {
        cls();
        System.out.println("\n\n ________________________________________________________");
        System.out.println(" \t******WELCOME IN HOSPITAL MANTHAN*******  ");
        System.out.println(" ________________________________________________________\n");
        System.out.println("\n\t.........MENU............");
        System.out.println("\t|1.Admit Patient        |");
        System.out.println("\t|2.Make patient's bill  |");
        System.out.println("\t|3.Medicines status     |");
        System.out.println("\t|4.Insurance and schemes|");
        System.out.println("\t|5.Display patients     |");
        System.out.println("\t|6.Hospital Staff       |");
        System.out.println("\t|7.Logout               |");
        System.out.println("\t|_______________________|");
        try{
            System.out.print("\n\tEnter option: ");
            op=sc.nextInt();

            switch(op)
            {
                case 1:
                    op1();
                    break;
                case 2:
                    op2();
                    break;
                case 3:
                    op3();
                    break;
                case 4:
                    op4();
                    break;
                case 5:
                    op5();
                case 6:
                    op6();
                case 7:
                    System.out.println("\n\n\t\tThank you | do visit again!");
                    System.exit(0);
                default:
                    System.out.println("\nEnter option between 1 to 7 !");
                    menu();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error! Enter number's only!  ");
            sc.next();
            menu();
        }

    }


    String fname[]=new String[50];
    String lname[]=new String[50];
    String ph_n[]=new String[50];
    String adr[]=new String[50];
    String id[]=new String[50];

    void op1()
    {

        Scanner ob=new Scanner(System.in);

        for(k=1;k<=50;k++)
        {
            System.out.println("\npatient No: ["+k+"]");

            System.out.print("Enter patient's first name: ");
            fname[k] = ob.nextLine();
            System.out.print("Enter patient's last name: ");
            lname[k] = ob.nextLine();
            System.out.print("Enter patient's ID: ");
            id[k] = ob.nextLine();
            System.out.print("Enter patient's Phone no: ");
            ph_n[k] = ob.nextLine();
            System.out.print("Enter patient's address: ");
            adr[k] = ob.nextLine();

            System.out.print("\nWant to Add another patient information(y/n):");
            String dec= ob.nextLine();

            if(dec.equalsIgnoreCase("y"))
                continue;
            else
                break;

        }
        System.out.println("\n\n\tDisplay patient information?(y/n)");
        String dec2= ob.nextLine();
        if(dec2.equalsIgnoreCase("y"))
            display_op1();
        else
            menu();
        cls();
    }

    void display_op1()
    {
        cls();
        System.out.println("\nHow many patients info you want to see:");
        int get=sc.nextInt();

        for(int i=1;i<=k;i++)
        {
            System.out.println("\npatient no: ["+i+"]");
            System.out.println("\nPatient Name:"+fname[i]+" "+lname[i]);
            System.out.println("\nPatient ID:"+id[i]);
            System.out.println("\nPatient phone no:"+ph_n[i]);
            System.out.println("\npatient address:"+adr[i]);
            System.out.println("\n_____________________________\n");

        }
        System.out.println("\n\n\tWant to continue:(y/n)");
        char dec1=sc.next().charAt(0);
        if(dec1=='y')
            display_op1();
        else
            menu();
    }
    void op2()
    {
        cls();
        if(k==0)
        {
            System.out.println("\nPlease add some patients first!");
            op1();
        }

        System.out.println("___________________________________________");
        String getin;
        int i;
        long total=0;
        //  String next;

        try {

            System.out.print("Enter patient ID:");
            getin =sc.next();


            for (i = 1; i <= k ; i++)
            {

                if (id[i].equals(getin))
                {

                    System.out.println("\nPatient found successfully.");
                    System.out.println("\n\tName: " + fname[i] + " " + lname[i]);
                    break;
                }


                if(i==k)
                {
                    System.out.println("\nPatient not found!");

                    System.out.print("\n--------------\nWant to continue(y/n):");
                    String dec1 = sc.next();
                    if (dec1.equalsIgnoreCase("y"))
                        op2();
                    else
                        menu();
                }
            }


            System.out.print("\nStay Days: ");
            int days = sc.nextInt();
            sc.nextLine();

            System.out.print("\nEnter Disease name: ");
            String di_name = sc.nextLine();

            System.out.print("\nEnter Disease type(simple,average,critical): ");
            String di_type = sc.nextLine();


            if (di_type.equalsIgnoreCase("simple"))
            {
                total= 500*days;
            }
            else if (di_type.equalsIgnoreCase("average"))
            {
                total = 1000*days;
            }
            else if (di_type.equalsIgnoreCase("critical"))
            {
                total = 2000*days;
            }
            else
            {
                System.out.println("please enter disease type! ");
                op2();
            }


            System.out.println("\n\t |------* HOSPITAL MANTHAN* ------| ");
            System.out.println("\n\t   Name: "+fname[i]+" "+lname[i]);
            System.out.println("\t   ID: "+id[i]);
            System.out.println("\t   Disease: "+di_name+"("+di_type+")");
            System.out.println("\t   Stay Days: "+days);
            System.out.println("\n\t\tTotal bill: "+total+" rs");
            System.out.println("\n\t    Thank you do visit again.");
            System.out.println("\t |________________________________|");


            System.out.print("\nWant to go back to main menu(y/n):");
            String dec1 = sc.next();
            if (dec1.equalsIgnoreCase("n"))
                op2();
            else
                menu();

        }
        catch (Exception e)
        {
            System.out.println(e);
            op2();
        }
    }

    int count=5;
    String med_name[] = new String[50];
    String med_comp[] = new String[50];
    String exp_date[] = new String[50];
    String med_cost[] = new String[50];

    public void op3()
    {
        cls();

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                     **MEDICINE SECTION**");
        System.out.println("--------------------------------------------------------------------------------");


        med_name[0] = "Corex";
        med_comp[0] = "Cin pvt";
        exp_date[0] = "29-5-23";
        med_cost[0] = "50";

        med_name[1] = "Nytra";
        med_comp[1] = "Ace pvt";
        exp_date[1] = "24-4-23";
        med_cost[1] = "500";

        med_name[2] = "Brufa";
        med_comp[2] = "Reckitt";
        exp_date[2] = "12-7-23";
        med_cost[2] = "55";

        med_name[3] = "Pride";
        med_comp[3] = "DDF pvt";
        exp_date[3] = "12-4-24";
        med_cost[3] = "1100";

        med_name[4] = "glazmo";
        med_comp[4] = "pharma  ";
        exp_date[4] = "12-1-24";
        med_cost[4] = "400";

        System.out.print("1.Add New Entry\n2.Existing Medicines List\n\nChoose option: ");
        int get2 = sc.nextInt();


        switch (get2)
        {
            case 1:
            {
                input_op3();
                break;
            }
            case 2:
            {
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("sr.no \t Name \t  Company \t Expiry Date \t Cost(rs)");
                System.out.println("--------------------------------------------------------------------------------");
                for (int j = 0; j < count; j++)
                {
                    System.out.println(j+1+"|\t"+med_name[j]+"\t "+med_comp[j]+"\t    "+exp_date[j]+"\t      "+med_cost[j]);
                }
                break;
            }
            default:
                System.out.println("Enter number 1 or 2!");
        }

        System.out.print("\nWant to go back to main menu(y/n):");
        String dec1 = sc.next();
        if (dec1.equalsIgnoreCase("y"))
            menu();
        else
            op3();


    }
    void input_op3()
    {   String dec=null;

        while(dec!="n")
        {
            //adding medicine after previous addings
            int dup=count;
            dup=dup+1;

            System.out.println("\nMedicine no: ["+dup+"]");
            // if(count==5)
            //{
            sc.nextLine();//this statement are written only for escape error occured when you used sc.nextline after sc.nextInt
            //  }
            System.out.print("Enter Medicine name: ");
            med_name[count] = sc.nextLine();
            System.out.print("Enter Medicine company: ");
            med_comp[count] = sc.nextLine();
            System.out.print("Enter Medicine Expiry Data: ");
            exp_date[count] =sc.nextLine();
            System.out.print("Enter Medicine Cost: ");
            med_cost[count] = sc.nextLine();

            count=count+1;

            System.out.print("\nWant to Add another Medicine(y/n):");
            dec = sc.nextLine();

            if (dec.equalsIgnoreCase("y"))
                continue;
            else
                op3();

        }
    }

    void op4()
    {
        cls();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                     **Insurance Schemes**");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("\n\tOur Insurance schemes associated with LIC\n");
        System.out.println("\t _______________________________________________");
        System.out.println("\t| sr.no         Plan Name            Plan no    |");
        System.out.println("\t|  1        LIC's cancer cover        905       |");
        System.out.println("\t|  2        LIC's Arogya Rakshak      906       |");
        System.out.println("\t|  3        LIC's jeevan umang        907       |");
        System.out.println("\t _______________________________________________");

        System.out.print("\n\nWant to Apply for Insurance(y/n):");
        String dec=sc.next();
        for(int i=0;i<1;i++) {
            if (dec.equalsIgnoreCase("n"))
                menu();
            else if (dec.equalsIgnoreCase("y")) {
                break;
            } else
                System.out.println("enter only y/n !");
            op4();
        }

        //checking for any patient availability
        if(k==0)
        {
            System.out.println("\nHospital Patient's Database is empty,add patients first!");
            op1();
        }

//checking patient are admited in hospital or not.
        String getin;
        int i;
        long total=0;

        System.out.print("Enter patient ID who apply for scheme:");
        getin =sc.next();

        for (i = 1; i <= k ; i++)
        {

            if (id[i].equals(getin))
            {

                System.out.println("\nPatient found successfully.");
                System.out.println("\n\tName: " + fname[i] + " " + lname[i]);
                break;
            }

            if(i==k) //system search upto last record, still patient not found
            {
                System.out.println("\nPatient not found!");

                System.out.print("\n--------------\nWant to continue(y/n):");
                String dec1 = sc.next();
                if (dec1.equalsIgnoreCase("y"))
                    op4();
                else
                    menu();
            }

        }
        try {

            System.out.print("\nEnter Insurance plan no:");
            int i_no = sc.nextInt();

            switch (i_no)
            {
                case 905:
                    System.out.println("\n***You successfully purchased a life insurance..");
                    System.out.println("\t \t\nLICs cancer cover\n\tplan no: 905\n\tMonthly: 950rs");
                    break;
                case 906:
                    System.out.println("\n***You successfully purchased life a insurance..");
                    System.out.println("\t \t\nLIC's Arogya Rakshak \n\tplan no: 906\n\tMonthly: 1200rs");
                    break;
                case 907:
                    System.out.println("\n***You successfully purchased life a insurance..");
                    System.out.println("\t\t \nLIC's jeevan umang \n\tplan no: 907\n\tMonthly:1500rs");
                    break;
                default:
                    System.out.println("\nEnter no. of insurance plan only!");
                    op4();
            }

        }  catch (NumberFormatException e)
        {
            System.out.println("Enter number only..");
            op4();
        }

        System.out.print("\nWant to go back to main menu(y/n):");
        String dec1 = sc.next();
        if (dec1.equalsIgnoreCase("y"))
            menu();
        else
            op4();
    }
    void op5()
    {
        cls();
        if(k==0)
        {
            System.out.println("\nPatient Database is empty,Please add some patients first!");
            op1();
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                     **Admitted Patients**");
        System.out.println("--------------------------------------------------------------------------------");

        display_op1();

    }
    String d_id[]=new String[50];
    String d_name[]=new String[50];
    String d_specility[]=new String[50];
    String d_age[]=new String[50];
    String d_quali[]=new String[50];
    int d_count=5;
    void input_op6()
    {
        String dec=null;

        while(dec!="n")
        {
            //adding medicine after previous addings
            int dup_c=d_count;
            dup_c=dup_c+1;
            System.out.println("\nDoctor no: ["+dup_c+"]");

            sc.nextLine();//this statement are written only for escape error occured when you used sc.nextline after sc.nextInt


            System.out.print("Enter Doctor ID: ");
            d_id[d_count] = sc.nextLine();

            System.out.print("Enter Doctor name: ");
            d_name[d_count] = sc.nextLine();

            System.out.print("Enter Doctor Designation: ");
            d_specility[d_count] = sc.nextLine();

            System.out.print("Enter Doctor Qualification: ");
            d_quali[d_count] =sc.nextLine();

            System.out.print("Enter Doctor Age: ");
            d_age[d_count] = sc.nextLine();

            d_count=d_count+1;

            System.out.print("\nWant to Add another Doctor info(y/n):");
            dec = sc.nextLine();

            if (dec.equalsIgnoreCase("y"))
                continue;
            else
                op6();

        }

    }
    void op6()
    {
        cls();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                     **Hospital Staff**");
        System.out.println("--------------------------------------------------------------------------------");


        d_id[0]= "24";
        d_name[0] = "Dr.A Ashok";
        d_specility[0] = "Brain Serg.";
        d_quali[0] = "MBBS,MD";
        d_age[0] = "40";

        d_id[1]= "07";
        d_name[1] = "Dr.S Saraf";
        d_specility[1] = "Physician.";
        d_quali[1] = "MBBS,MS";
        d_age[1] = "42";

        d_id[2]= "17";
        d_name[2] = "Dr.S Patil";
        d_specility[2] = "Sergeon   ";
        d_quali[2] = "BDM";
        d_age[2] = "32";

        d_id[3]= "53";
        d_name[3] = "Dr.M Kabil";
        d_specility[3] = "Artho     ";
        d_quali[3] = "BDM,MBBS";
        d_age[3] = "50";

        d_id[4]= "15";
        d_name[4] = "Dr.O Jadhav";
        d_specility[4] = "Therapist";
        d_quali[4] = "MBBS";
        d_age[4] = "45";

        System.out.print("1.Display Existing Staff\n2.Add new Staff member\n\nChoose option: ");
        int opt=sc.nextInt();

        switch (opt)
        {
            case 1:
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("sr.no"+" \t"+" Name    "+" \t"+" ID  "+" \t"+" Designation "+"\t"+"Age    Qualification");
                System.out.println("--------------------------------------------------------------------------------");

                for (int j = 0; j < d_count; j++)
                {
                    System.out.println(j+1+"|\t"+d_name[j]+"\t"+d_id[j]+"\t"+d_specility[j]+"\t"+d_age[j]+"\t"+d_quali[j]);
                }
                break;

            case 2:
                input_op6();
                break;

            default:
                System.out.println("!!!Enter number 1 or 2");
        }

        System.out.print("\nWant to go back to main menu(y/n):");
        String dec1 = sc.next();
        if (dec1.equalsIgnoreCase("y"))
            menu();
        else
            op6();
    }
}


class hospitalprj
{
    public static void main(String args[])
    {
        demo ob=new demo();

        ob.login();

    }

}