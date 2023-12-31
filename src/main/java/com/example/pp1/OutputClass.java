package com.example.pp1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class OutputClass implements OutputInterface{

    public OutputClass() {

    }
    @Override
    public void outYachtTxt(List<Yachts> yacht,String output) {
        try( FileWriter output1 = new FileWriter(output)) {
            for(Yachts ya:yacht) {
                output1.write("name: "+ya.GetName()+", material: "+ya.GetMaterial()+ ", cost: "+ ya.GetCoast()+ ", maxSpeed; "+ ya.GetMaxSpeed()+"\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error");
        }
        System.out.println("File is done");
    }

    @Override
    public void outYachtJson(List<Yachts> yacht,String output) {
        JSONObject elem = new JSONObject();
        JSONArray yachtsList = new JSONArray();
        StringBuilder jsonString= new StringBuilder();
        try (PrintWriter out = new PrintWriter(new FileWriter(output))){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            for(Yachts ya:yacht) {
                elem.put("name", ya.GetName());
                elem.put("material", ya.GetMaterial());
                elem.put("cost", ya.GetCoast());
                elem.put("maxSpeed", ya.GetMaxSpeed());
                yachtsList.add(elem);
            }
            jsonString.append(gson.toJson(yachtsList));
            out.write(jsonString.toString());
        } catch (Exception e) {
            System.out.println("Error open Json writer");
        }
        System.out.println("File is done");
    }

    @Override
    public void outYachtXml(List<Yachts> yacht,String output) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("yachtsList");
            doc.appendChild(rootElement);

            Element yachtElement = doc.createElement("yachts");

            for(Yachts ya:yacht) {
                Element name = doc.createElement("name");
                name.setTextContent(ya.GetName());
                yachtElement.appendChild(name);

                Element material = doc.createElement("material");
                material.setTextContent(ya.GetMaterial());
                yachtElement.appendChild(material);

                Element cost = doc.createElement("cost");
                cost.setTextContent(String.valueOf(ya.GetCoast()));
                yachtElement.appendChild(cost);

                Element maxSpeed = doc.createElement("maxSpeed");
                maxSpeed.setTextContent(String.valueOf(ya.GetMaxSpeed()));
                yachtElement.appendChild(maxSpeed);

                rootElement.appendChild(yachtElement);
            }

            xmlRefactor(doc,output);


        } catch (Exception e) {
            System.out.println("Error write in XML");
        }
    }

    private byte[] ciphers(StringBuilder yachtString)throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec("oleg1337oleg2228".getBytes(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        return cipher.doFinal(yachtString.toString().getBytes());

    }
    @Override
    public void outYachtAES(List<Yachts> yacht, String output) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        StringBuilder yachtString = new StringBuilder() ;
        for(Yachts ya:yacht )
        {
            yachtString.append(ya.toString());
        }
        try (FileOutputStream outputStream = new FileOutputStream(output);
             OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            writer.write(new String(ciphers(yachtString), StandardCharsets.UTF_8));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void outYachtTxtMap( Map<Integer,Yachts> yachtsM,String output) {
        try( FileWriter output1 = new FileWriter(output)) {

            Set<Entry<Integer, Yachts>> entrySet = yachtsM.entrySet();
            for(Entry<Integer, Yachts> entry : entrySet)
            {
                output1.write(entry.getKey().toString()+" " +entry.getValue().toString()+"\n");
            }

        }
        catch (IOException e)
        {
            System.out.println("Error");
        }
        System.out.println("File is done");
    }

    @Override
    public void outYachtJsonMap( Map<Integer,Yachts> yachtsM,String output) {
        JSONObject elem = new JSONObject();
        JSONArray yachtsList = new JSONArray();
        StringBuilder jsonString= new StringBuilder();
        try (PrintWriter out = new PrintWriter(new FileWriter(output))){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            for(int i = 0; i <yachtsM.size(); i++ ) {
                elem.put("id",yachtsM.keySet().iterator().next());
                elem.put("name", yachtsM.get(i).GetName());
                elem.put("material", yachtsM.get(i).GetMaterial());
                elem.put("cost", yachtsM.get(i).GetCoast());
                elem.put("maxSpeed", yachtsM.get(i).GetMaxSpeed());
                yachtsList.add(elem);
            }
            jsonString.append(gson.toJson(yachtsList));
            out.write(jsonString.toString());
        } catch (Exception e) {
            System.out.println("Error open Json writer");
        }
        System.out.println("File is done");
    }
    private void xmlRefactor(Document doc,String output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty("indent", "yes");
        transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);

        File file = new File(output);
        StreamResult res = new StreamResult(file);

        transformer.transform(source, res);


    }

    @Override
    public void outYachtXmlMap( Map<Integer,Yachts> yachtsM,String output) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("yachtsList");
            doc.appendChild(rootElement);

            Element yachtElement = doc.createElement("yachts");

            for(int i = 0; i <yachtsM.size(); i++ )  {

                Element id = doc.createElement("id");
                id.setTextContent(yachtsM.keySet().iterator().next().toString());
                yachtElement.appendChild(id);

                Element name = doc.createElement("name");
                name.setTextContent(yachtsM.get(i).GetName());
                yachtElement.appendChild(name);

                Element material = doc.createElement("material");
                material.setTextContent(yachtsM.get(i).GetMaterial());
                yachtElement.appendChild(material);

                Element cost = doc.createElement("cost");
                cost.setTextContent(String.valueOf(yachtsM.get(i).GetCoast()));
                yachtElement.appendChild(cost);

                Element maxSpeed = doc.createElement("maxSpeed");
                maxSpeed.setTextContent(String.valueOf(yachtsM.get(i).GetMaxSpeed()));
                yachtElement.appendChild(maxSpeed);

                rootElement.appendChild(yachtElement);
            }
            xmlRefactor(doc,output);



        } catch (Exception e) {
            System.out.println("Error write in XML");
        }
    }

    @Override
    public void outYachtShaMap(Map<Integer,Yachts> yachtsM, String output) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        StringBuilder yachtString = new StringBuilder();
        for (int i = 0; i < yachtsM.size(); i++) {
            yachtString.append(yachtsM.get(i).toString());
        }

        try (FileOutputStream outputStream = new FileOutputStream(output);
             OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            writer.write(new String(ciphers(yachtString), StandardCharsets.UTF_8));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
