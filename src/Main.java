import java.util.Scanner;
import java.lang.Character;
public class Main
{
   static String continueOrNot="Y",option="",amount="";
   static int intOption=0,i=0;
   static double doubleAmount=0;
   static double []result= new double[10];
   static boolean loop= false;
   static Scanner input= new Scanner(System.in);
   private static Character ch= new Character('a');

   private static boolean isYorN(String yn)
    {// This function check if the user enter y or N
        if (ch.isUpperCase(yn.charAt(0)) && ((yn.charAt(0)=='Y')|| (yn.charAt(0)=='N')) &&yn.length()==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private static void printFirstMessage()
    {// this function print the first message
        System.out.println("Welcome to currency converter");
    }

    private static void chooseDollartoIlsOrIlsToDollar()
    {// this function will check if user chose dollar to ILS or ILS to dollar.
        loop=false;
        System.out.println("Please choose an option (1/2):");
        System.out.println("1.Dollars to Shekels \n2.Shekels to Dollars");

        while (loop==false)
        {
            option= input.next();
            try
            {  intOption = Integer.parseInt(option);
                loop=true;

                if (intOption==1|| intOption==2)
                {
                    loop=true;
                }
                else{
                    loop=false;
                    throw new NumberFormatException();
                }
            }
            catch (NumberFormatException e)
            {
                loop= false;
                System.out.print("Invalid Choice, please try again");
            }
        }
    }
    private static void convert()
    {//this fuction get the amount to convert from user , and check the result of the convert math.(print the result)
        loop=false;
        System.out.println("Please enter an amount to convert");
        while (loop==false)
        {
            amount= input.next();
            try
            {  doubleAmount = Double.parseDouble(amount);
                loop=true;
            }
            catch (NumberFormatException e)
            {
                loop= false;
                System.out.print("Invalid amount input, please try again");
            }
        }

        if ((Integer.parseInt(option)==2))
        {
            ILS ils= new ILS();
            System.out.println("The Result is: " + doubleAmount*ils.getValue());
            result[i]=doubleAmount*ils.getValue();
        }
        if ((Integer.parseInt(option)==1))
        {
            USD usd= new USD();
            System.out.println("The Result is: " +doubleAmount*usd.getValue());
            result[i]=doubleAmount*usd.getValue();
        }
    }
    private  static void checkIfUserWantToStartOver()
    { //this function checks if user Want To Start Over
    System.out.println("Do you want to start over? - Y/N");
    loop=false;
    while (!loop) {
        continueOrNot = input.next();
        if (!isYorN(continueOrNot))
        {
            System.out.print("Invalid input,Do you want to start over? - Y/N ");
            loop = false;
        } else {
            loop = true;
        }
    }

    i++;
}
    private static void PrintLastMessageAndArrayResults()
    { // this function print the thanks last message and prints the array results
        System.out.println("Thanks for using our currency conventer");
        for(int index=0;index<result.length-1;index++)
        {
            if (result[index]!=0.0)
            {
                System.out.println(result[index]);
            }
        }
    }


    public static void main(String[] args)
    {//Main
        printFirstMessage();
        while( continueOrNot.equals("Y"))
     {// while user choose to continue converting
         chooseDollartoIlsOrIlsToDollar();
         convert();
         checkIfUserWantToStartOver();
     }
        PrintLastMessageAndArrayResults();
    }
}
