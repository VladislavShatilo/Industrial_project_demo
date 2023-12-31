package com.example.pp1;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        System.out.println("List Yachts\n");
        List<Yachts> yachts;
        YachtBuilder builder = new YachtBuilder();
        FileInformation file = new FileInformation();
        ChooseInfo chooseInfo = ChooseInfo.getInstance();
        chooseInfo.chose(file);
        Manager manage = new Manager(builder,file.inputExpanse,file.outputName);
        yachts = manage.chooseBuilder();
        manage.chooseOutput(yachts,file.cipher);
        yachts.sort(Comparator.comparing(Yachts::GetName)
                .thenComparing(Yachts::GetMaterial)
                .thenComparingInt(Yachts::GetCoast)
                .thenComparingInt(Yachts::GetMaxSpeed));
        manage.chooseOutput(yachts,file.cipher);

        System.out.println("\nMap Yachts\n");
       Map<Integer,Yachts> yachtsM;
        YachtBuilder builderMap = new YachtBuilder();
        FileInformation fileMap = new FileInformation();
       ChooseInfo chooseInfoMap =  ChooseInfo.getInstance();
        chooseInfoMap.chose(fileMap);
        Manager manageMap = new Manager(builderMap,fileMap.inputExpanse,fileMap.outputName);
       yachtsM = manageMap.chooseMapBuilder();
        manageMap.chooseOutputMap(yachtsM,file.cipher);






    }

}