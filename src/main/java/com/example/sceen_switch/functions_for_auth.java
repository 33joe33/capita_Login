package com.example.sceen_switch;

import java.util.Locale;
import java.util.Scanner;

public class functions_for_auth {




    public class counter {
        static int counter =0;
        static int get()
        {
            return counter;
        }
        static void inc(){
            counter++;
        }

        static void inc_(){counter-=1;}
    }
    record user (String name,String password){ }
    public static void main(String[] args) {




    }

}



