package com.example.pp1;

import java.util.List;
import java.util.Map;

public interface YachtsBuilderInterface {
    YachtsBuilderInterface buildYachtTxt(String input);
    YachtsBuilderInterface buildYachtJson(String input);
    YachtsBuilderInterface buildYachtXml(String input);
    YachtsBuilderInterface buildYachtZip(String input);
    YachtsBuilderInterface buildYachtRarOrJar(String input);
    List<Yachts> build();
    Map <Integer,Yachts> buildMap();


}
