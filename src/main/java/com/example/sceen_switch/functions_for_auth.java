package com.example.sceen_switch;

import java.util.Locale;
import java.util.Scanner;

public class functions_for_auth {




    public class counter {
        //counter used to determine the number of failed passwords attempts.
        static int counter =0;
        static int get()
        {
            return counter;
        }
        //get counter value
        static void inc(){
            counter++;
        }
        //increment counter by 1

        static void inc_(){counter-=1;}
        // de increment counter by 1
    }
    record user (String name,String password){ }
    public static void main(String[] args) {




    }

}



