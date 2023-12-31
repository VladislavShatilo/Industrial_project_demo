package com.example.pp1;

import java.util.Scanner;

public class ChooseInfo {
    private static ChooseInfo instance;
    private ChooseInfo() {

    }

    public static ChooseInfo getInstance() {
        if (instance == null){
            instance = new ChooseInfo();
        }
        return instance;

    }
    public void  chose(FileInformation file)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What type of input file do you want to work with?\n" +
                "txt,json,xml,zip,jar");

       file.inputExpanse = scan.next();
        boolean correctData;
        do{
            if (file.inputExpanse.equals("txt")|| file.inputExpanse.equals("json")||file.inputExpanse.equals("xml")||file.inputExpanse.equals("zip")||file.inputExpanse.equals("jar")) {

                correctData = true;
            }
            else {
                System.out.println("Incorrect data, please input again!\n");
                file.inputExpanse = scan.next();
                correctData = false;
            }
        } while(!correctData);


        System.out.println("What type of output file do you want to work with\n" +
                "txt,json,xml,zip,jar");
        file.outputExpanse=scan.next();

        do{
            if ( file.outputExpanse.equals("txt"))  {
                System.out.println("""
                        Do you want cipher output?
                        1.YES
                        2.NO""");

                file.cipher = scan.nextInt();
                do{
                    if (file.cipher == 1) {

                        correctData = true;

                    } else if (file.cipher == 2) {

                        correctData = true;
                    } else {
                        System.out.println("Incorrect data, please input again!\n");
                        correctData = false;
                    }
                } while(!correctData);

            }
            else if(file.outputExpanse.equals("json")||file.outputExpanse.equals("xml")||file.outputExpanse.equals("zip")||file.outputExpanse.equals("jar")){
                correctData = true;
            }
            else {
                System.out.println("Incorrect data, please input again!\n");
                file.outputExpanse = scan.next();
                correctData = false;
            }
        } while(!correctData);

        String nameOfOutputFile;
        System.out.println("Input name of output file");
        nameOfOutputFile = scan.next();

        file.outputName = nameOfOutputFile+"."+file.outputExpanse;

    }

}
