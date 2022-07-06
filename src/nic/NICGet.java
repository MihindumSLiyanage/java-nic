
package nic;

import javax.swing.JOptionPane;


    public class NICGet {
    

    String id;
    int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    boolean isNewFormat = false;

    public NICGet(String id) {
        
        if (id.length() == 12) {
            isNewFormat = true;
        }
    }
   
   

    public int getYear(String id) {
        if (isNewFormat) {
            return (Integer.parseInt(id.substring(0, 4)));
        }
        return (1900 + Integer.parseInt(id.substring(0, 2)));
    }

    public int getDays(String id) {
        int d;
        if (isNewFormat) {
            d = Integer.parseInt(id.substring(4, 7));
        } else {
            d = Integer.parseInt(id.substring(2, 5));
        }
        if (d > 500) {
            return (d - 500);
        } else {
            return d;
        }
    }

    public String setMonth(String id) {
        int mo = 0, da = 0;
        int days = getDays( id);

        for (int i = 0; i < month.length; i++) {
            if (days < month[i]) {
                mo = i + 1;
                da = days;
                break;
            } else {
                days = days - month[i];
            }
        }
        return "\nMonth: "+mo+"\nDate: "+da;
       
    }

public String setGender(String id) {
        String M = "Male", F = "Female";
        int d;
        if (isNewFormat) {
            d = Integer.parseInt(id.substring(4, 7));
        } else {
            d = Integer.parseInt(id.substring(2, 5));
        }
        if (d > 500) {
            return "\nGender: "+F;
        } else {
            return "\nGender: "+M;
        }       
        
    }


    
}
