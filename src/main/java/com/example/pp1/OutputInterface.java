package com.example.pp1;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public interface OutputInterface {

    void outYachtTxt(List<Yachts> yacht, String output);
    void outYachtJson(List<Yachts> yacht, String output);
    void outYachtXml(List<Yachts> yacht,String output);
    void outYachtAES(List<Yachts> yacht, String output) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

    void outYachtTxtMap(Map<Integer,Yachts> yachtsM, String output);
    void outYachtJsonMap( Map<Integer,Yachts> yachtsM, String output);
    void outYachtXmlMap( Map<Integer,Yachts> yachtsM,String output);
    void outYachtShaMap( Map<Integer,Yachts> yachtsM,String output) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException;



}
