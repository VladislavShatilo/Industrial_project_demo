package com.example.pp1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public  class YachtBuilder implements YachtsBuilderInterface {


    private final List<String> name = new ArrayList<>();
    private final List<String> material = new ArrayList<>();
    private final List<Integer> cost = new ArrayList<>();
    private final List<Integer> maxSpeed = new ArrayList<>();


    private void BufferReadRefactor(BufferedReader reader) throws IOException {
        String line;
        String[] values;
        while ((line = reader.readLine()) != null) {
            values = line.split(" ");
            name.add(values[0]);
            material.add(values[1]);
            cost.add(Integer.parseInt(values[2]));
            maxSpeed.add( Integer.parseInt(values[3]));
        }

    }
    @Override
    public YachtsBuilderInterface buildYachtTxt(String input) {

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            BufferReadRefactor(reader);
        } catch (IOException e) {
            System.out.println("Error read txt");
        }
        return this;

    }
    @Override
    public YachtsBuilderInterface buildYachtJson(String input) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(input)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray expressionsJson = (JSONArray)jsonObject.get("yachts");
            for(Object item:expressionsJson)
            {
                JSONObject expJson =(JSONObject)item;
                name.add((String) expJson.get("name"));
                material.add((String) expJson.get("material"));
                cost.add(Integer.parseInt((String)expJson.get("cost"))) ;
                maxSpeed.add(Integer.parseInt((String)expJson.get("maxSpeed"))) ;

            }
        } catch (Exception e) {
            System.out.println("j");
        }

        return this;
    }
    @Override
    public YachtsBuilderInterface buildYachtXml(String input) {

        File file1 = new File(input);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc;
        try {
            doc = dbf.newDocumentBuilder().parse(file1);
            NodeList yachtsNodes = doc.getElementsByTagName("yacht");

            for (int i = 0; i < yachtsNodes.getLength(); i++) {
                Node rootList1 = yachtsNodes.item(i);
                if (rootList1.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) rootList1;
                    name.add( element.getElementsByTagName("name").item(0).getTextContent());
                    material .add(  element.getElementsByTagName("material").item(0).getTextContent());
                    cost .add(  Integer.parseInt(element.getElementsByTagName("cost").item(0).getTextContent()));
                    maxSpeed .add(  Integer.parseInt(element.getElementsByTagName("maxSpeed").item(0).getTextContent()));
                }
            }
        } catch (Exception e) {
            System.out.println("DocumentBuilderFactory Error");
        }

        return this;
    }

    @Override
    public YachtsBuilderInterface buildYachtZip(String input) {
        try( ZipInputStream zip = new ZipInputStream(new FileInputStream(input));
            ZipFile zipFile = new ZipFile(input))
        {
            ZipEntry entry = zip.getNextEntry();
            if (entry != null) {
                try (InputStream inputStream = zipFile.getInputStream(entry);
                     InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                     BufferedReader reader = new BufferedReader(inputStreamReader)) {
                    BufferReadRefactor(reader);

                }
            }
            else {
                System.out.println("File " + input  + " is not found");
            }
        }
        catch (Exception e) {
            System.out.println("Error read from zip");
        }
        return this;
    }
    @Override
    public YachtsBuilderInterface buildYachtRarOrJar(String input) {

        try (InputStream inputStream = new FileInputStream(input);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            BufferReadRefactor(reader);
        }
        catch (Exception e) {
            System.out.println("Error read from rar or jar");
        }
        return this;
    }
    @Override
    public List<Yachts> build()
    {
        List<Yachts> yachts = new ArrayList<>();
        for(int i  = 0; i< name.size();i++) {
            yachts.add(new Yachts(name.get(i), material.get(i), cost.get(i), maxSpeed.get(i)));
        }
        return yachts;
    }

    @Override
    public Map<Integer,Yachts> buildMap() {
        Map<Integer,Yachts> yachts = new HashMap<>();
        for(int i  = 0; i< name.size();i++) {
            yachts.put(i,new Yachts(name.get(i), material.get(i), cost.get(i), maxSpeed.get(i)));
        }
        return yachts;

    }

}







