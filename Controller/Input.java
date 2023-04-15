package Controller;

import Model.*;
import View.*;


import java.util.*;
public class Input {
    
    public boolean lerSN(Apresentacao a, String message){
        Scanner s = new Scanner(System.in);
        String line;

        do{
            a.printMessage(message);
            line = s.nextLine();
        } while (!line.toUpperCase().equals("S") && !line.toUpperCase().equals("N"));

        return line.toUpperCase().equals("S");
    }   

    public double lerDouble(Apresentacao a, String message,int min,int max){
        Scanner s = new Scanner(System.in);
        double n = -1;

        do{
            a.printMessage(message);
            try {
                String line = s.nextLine();
                n = Double.parseDouble(line);
            } catch (NumberFormatException nfe) {
                a.printMessage(nfe.getMessage());
                n = -1;
            }
        } while (n < min || n > max);

        return n;
    }

    public int lerInt(Apresentacao a, String message, int min, int max) {
    Scanner s = new Scanner(System.in);
    int n = -1;

    do {
        a.printMessage(message);
        try {
            String line = s.nextLine();
            n = Integer.parseInt(line);
        } catch (NumberFormatException nfe) {
            a.printMessage(nfe.getMessage());
            n = -1;
        }
    } while (n < min || n > max);

    return n;
    }

    public float lerFloat(Apresentacao a, String message, float min, float max) {
    Scanner s = new Scanner(System.in);
    float n = Float.NaN;

    do {
        a.printMessage(message);
        try {
            String line = s.nextLine();
            n = Float.parseFloat(line);
        } catch (NumberFormatException nfe) {
            a.printMessage(nfe.getMessage());
            n = Float.NaN;
        }
    } while (n < min || n > max);

    return n;
    }

    public String lerString(Apresentacao a, String message){
        Scanner s = new Scanner(System.in);
        String line;

        a.printMessage(message);
        line = s.nextLine();

        return line;
    }
    
}
