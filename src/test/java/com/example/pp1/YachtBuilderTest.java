package com.example.pp1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class YachtBuilderTest {

    @Test
    void buildYachtTxt() {
        List<Yachts> yachts;
        YachtBuilder builder = new YachtBuilder();
        yachts = builder.buildYachtTxt("input.txt").build();

        List<Yachts> yachts1 = new ArrayList<>();
        yachts1.add(new Yachts("superBoat","plastic",490,30));
        yachts1.add(new Yachts("maria","wood",650,45));
        yachts1.add(new Yachts("freedom","steel",560,40));

        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtJson() {
        List<Yachts> yachts;
        YachtBuilder builder = new YachtBuilder();
        yachts = builder.buildYachtJson("input.json").build();

        List<Yachts> yachts1 = new ArrayList<>();
        yachts1.add(new Yachts("Grace","wood",500,45));
        yachts1.add(new Yachts("SecondWind","plastic",670,63));
        yachts1.add(new Yachts("Serenity","steel",590,50));

        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtXml() {
        List<Yachts> yachts;
        YachtBuilder builder = new YachtBuilder();
        yachts = builder.buildYachtXml("input.xml").build();

        List<Yachts> yachts1 = new ArrayList<>();
        yachts1.add(new Yachts("Perseverance","wood",780,69));
        yachts1.add(new Yachts("Therapy","steel",400,35));
        yachts1.add(new Yachts("RumRunner","plastic",510,49));

        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtZip() {
        List<Yachts> yachts;
        YachtBuilder builder = new YachtBuilder();
        yachts = builder.buildYachtZip("input.zip").build();

        List<Yachts> yachts1 = new ArrayList<>();
        yachts1.add(new Yachts("maria","wood",640,45));
        yachts1.add(new Yachts("superBoat","plastic",890,30));
        yachts1.add(new Yachts("freedom","steel",740,40));

        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtJar() {
        List<Yachts> yachts;
        YachtBuilder builder = new YachtBuilder();
        yachts = builder.buildYachtRarOrJar("input.jar").build();

        List<Yachts> yachts1 = new ArrayList<>();
        yachts1.add(new Yachts("maria","wood",620,37));
        yachts1.add(new Yachts("Therapy","plastic",830,60));
        yachts1.add(new Yachts("freedom","steel",940,40));

        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtRar() {
        List<Yachts> yachts;
        YachtBuilder builder = new YachtBuilder();
        yachts = builder.buildYachtRarOrJar("input.rar").build();

        List<Yachts> yachts1 = new ArrayList<>();
        yachts1.add(new Yachts("maria","wood",620,37));
        yachts1.add(new Yachts("Therapy","plastic",830,60));
        yachts1.add(new Yachts("freedom","steel",940,40));

        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtTxtMap() {
        Map<Integer,Yachts> yachts ;
        YachtBuilder builder = new YachtBuilder();
        yachts = builder.buildYachtTxt("input.txt").buildMap();

        Map<Integer,Yachts> yachts1 = new HashMap<>();
        yachts1.put(0,new Yachts("superBoat","plastic",490,30));
        yachts1.put(1,new Yachts("maria","wood",650,45));
        yachts1.put(2,new Yachts("freedom","steel",560,40));


        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtJsonMap() {
        Map<Integer,Yachts> yachts ;
        YachtBuilder builder = new YachtBuilder();

        yachts = builder.buildYachtJson("input.json").buildMap();

        Map<Integer,Yachts> yachts1 = new HashMap<>();
        yachts1.put(0,new Yachts("Grace","wood",500,45));
        yachts1.put(1,new Yachts("SecondWind","plastic",670,63));
        yachts1.put(2,new Yachts("Serenity","steel",590,50));


        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtXmlMap() {
        Map<Integer,Yachts> yachts ;
        YachtBuilder builder = new YachtBuilder();
        yachts = builder.buildYachtXml("input.xml").buildMap();

        Map<Integer,Yachts> yachts1 = new HashMap<>();
        yachts1.put(0,new Yachts("Perseverance","wood",780,69));
        yachts1.put(1,new Yachts("Therapy","steel",400,35));
        yachts1.put(2,new Yachts("RumRunner","plastic",510,49));

        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtZipMap() {
        Map<Integer,Yachts> yachts ;
        YachtBuilder builder = new YachtBuilder();
        yachts = builder.buildYachtZip("input.zip").buildMap();

        Map<Integer,Yachts> yachts1 = new HashMap<>();
        yachts1.put(0,new Yachts("maria","wood",640,45));
        yachts1.put(1,new Yachts("superBoat","plastic",890,30));
        yachts1.put(2,new Yachts("freedom","steel",740,40));


        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtJarMap() {
        Map<Integer,Yachts> yachts ;
        YachtBuilder builder = new YachtBuilder();

        yachts = builder.buildYachtRarOrJar("input.jar").buildMap();

        Map<Integer,Yachts> yachts1 = new HashMap<>();
        yachts1.put(0,new Yachts("maria","wood",620,37));
        yachts1.put(1,new Yachts("Therapy","plastic",830,60));
        yachts1.put(2,new Yachts("freedom","steel",940,40));


        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }

    @Test
    void buildYachtRarMap() {
        Map<Integer,Yachts> yachts ;
        YachtBuilder builder = new YachtBuilder();
        yachts = builder.buildYachtRarOrJar("input.rar").buildMap();

        Map<Integer,Yachts> yachts1 = new HashMap<>();
        yachts1.put(0,new Yachts("maria","wood",620,37));
        yachts1.put(1,new Yachts("Therapy","plastic",830,60));
        yachts1.put(2,new Yachts("freedom","steel",940,40));


        Assertions.assertEquals(yachts1.toString(), yachts.toString());
    }


}