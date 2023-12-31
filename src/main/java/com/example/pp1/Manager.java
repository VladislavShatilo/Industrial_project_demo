package com.example.pp1;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class Manager {

    private final String input;
    private final String output;
    private final OutputClass out = new OutputClass();


    private final YachtBuilder builder;

    public Manager(YachtBuilder builder,String input,String output) {
        super();
        this.input = input;
        this.output = output;
        this.builder = builder;
        if (this.builder == null) {
            throw new IllegalArgumentException("Automotive Engineer can't work without Car Builder!");
        }
    }

    public List<Yachts> chooseBuilder() {


        return switch (input) {
            case "txt" -> builder.buildYachtTxt("input.txt").build();
            case "json" -> builder.buildYachtJson("input.json").build();
            case "xml" -> builder.buildYachtXml("input.xml").build();
            case "zip" -> builder.buildYachtZip("input.zip").build();
            case "rar" -> builder.buildYachtRarOrJar( "input.rar").build();
            case "jar" -> builder.buildYachtRarOrJar( "input.jar").build();
            default -> null;
        };
    }

    public Map<Integer,Yachts> chooseMapBuilder() {


        return switch (input) {
            case "txt" -> builder.buildYachtTxt("input.txt").buildMap();
            case "json" -> builder.buildYachtJson("input.json").buildMap();
            case "xml" -> builder.buildYachtXml("input.xml").buildMap();
            case "zip" -> builder.buildYachtZip("input.zip").buildMap();
            case "rar" -> builder.buildYachtRarOrJar( "input.rar").buildMap();
            case "jar" -> builder.buildYachtRarOrJar( "input.jar").buildMap();
            default -> null;
        };
    }
    public void chooseOutput(List<Yachts> yacht,int chose) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        int lastDotIndex = output.lastIndexOf(".");
        String fileExtension = output.substring(lastDotIndex + 1);
        switch (fileExtension) {
            case "txt": {
                if(chose == 1)
                {
                    out.outYachtAES(yacht,output);
                }
                else if(chose == 2){
                   out.outYachtTxt(yacht,output);
                }
                break;
            }
            case "json": {
                out.outYachtJson(yacht,output);
                break;
            }
            case "xml": {
                out.outYachtXml(yacht,output);
                break;
            }
            case "zip": {
                TxtOutputInterface zipTextFile = new ZipDecorator(new TxtOutput());
                zipTextFile.write(yacht,output);

            }

            case "jar": {
                TxtOutputInterface jarTextFile = new JarDecorator(new TxtOutput());
                jarTextFile.write(yacht,output);
                break;
            }

        }
    }

    public void chooseOutputMap(Map<Integer,Yachts> yacht,int chose) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        int lastDotIndex = output.lastIndexOf(".");
        String fileExtension = output.substring(lastDotIndex + 1);
        switch (fileExtension) {
            case "txt": {
                if(chose == 1)
                {
                    out.outYachtShaMap(yacht,output);
                }
                else if(chose == 2){
                    out.outYachtTxtMap(yacht,output);
                }
                break;
            }
            case "json": {
                out.outYachtJsonMap(yacht,output);
                break;
            }
            case "xml": {
                out.outYachtXmlMap(yacht,output);
                break;
            }
            case "zip": {
                TxtOutputInterface zipTextFile = new ZipDecorator(new TxtOutput());
                zipTextFile.writeMap(yacht,output);

            }

            case "jar": {
                TxtOutputInterface jarTextFile = new JarDecorator(new TxtOutput());
                jarTextFile.writeMap(yacht,output);
                break;
            }

        }
    }




}

