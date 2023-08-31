package com.labs.java.core;

public class CmdLineArgsDemo {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("No command line arguments");
           // return;
            System.exit(0);
        }
        for(String arg : args){
            //System.out.println(arg);
            System.out.println(args[0].length());
            System.out.println(args[1].toLowerCase());
            //System.out.println(args[2].);
            System.out.println();

        }

    }
}
