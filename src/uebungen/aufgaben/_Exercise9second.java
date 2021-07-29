package uebungen.aufgaben;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
public class _Exercise9second {
	
    public static void main(String[] args) {
         try {
 
         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("*****************************");
         System.out.println("*** WILLKOMMEN BEIM LOTTO ***");
         System.out.println("*****************************");
 
 int[] zufallsZahlen= new int [6]  ;
 int[] getippteZahlen= new int [6]  ;
 
 int g = 0;
 
          for (int i = 0; i <=5; i++)
          {
          g++;           
          System.out.println("Bitte geben Sie die " +g+ ". Zahl ein");
          getippteZahlen[i] = Integer.parseInt( input.readLine());
          }
          System.out.println("Sie haben folgende Zahlen getippt");
          for (int i = 0; i <=5; i++)
          {
              System.out.println ( getippteZahlen[i] );
          }
          System.out.println("");
 
          for (int i = 0; i <=5; i++)
          {
          //Zufallsgenerator Anlegen
          Random mygenerator = new Random();
          // Zufallsahl ziwschen 0 und 49 (50 ist exklusive
          // Grenze) erzeugen und in aktuelle/ahl speichern
          zufallsZahlen[i]=mygenerator.nextInt(50);
          }
 
          System.out.println("Die Gewinnzahlen Lauten:");
 
          for (int i = 0; i <=5; i++)
          {
              System.out.println ( zufallsZahlen[i] );
          }
 
          System.out.println("Sie haben mit folgenden Zahlen gewonnen:");
          for(int i=0; i<=5; i++)
          {
              for(int j=0; j<=5; j++)
              {
                  if (zufallsZahlen[i] == getippteZahlen[j])
                      System.out.println(getippteZahlen[j]);
              }
          }            
 
 
         }
         catch(Exception ex)
         {
  System.out.println("Irgendwas ist schief gelaufen !!!");
 
  System.out.println(ex.getMessage() );
 
         }
    }
 
}