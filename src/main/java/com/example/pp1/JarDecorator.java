package com.example.pp1;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

public class JarDecorator implements TxtOutputInterface{

    TxtOutputInterface txtOutputInterface ;


    public JarDecorator(TxtOutputInterface txtOutputInterface) {
        this.txtOutputInterface = txtOutputInterface;
    }

    @Override
    public void write(List<Yachts> yacht,String output) {

        try (JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(output))) {
            String entryName = "temp.txt";

            JarEntry entry = new JarEntry(entryName);
            jarOutputStream.putNextEntry(entry);

            StringBuilder fileContent = new StringBuilder();
            for(Yachts ya:yacht) {
                fileContent.append(ya.GetName()).append(" ").append(ya.GetMaterial()).append(" ").append(ya.GetCoast()).append(" ").append(ya.GetMaxSpeed()).append("\n");
            }
            byte[] contentBytes = fileContent.toString().getBytes();
            jarOutputStream.write(contentBytes, 0, contentBytes.length);
            jarOutputStream.closeEntry();


        } catch (Exception e) {
          System.out.println("Error jar output");
        }


    }
    @Override
    public void writeMap(Map<Integer,Yachts> yachtM, String output) {

        try (JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(output))) {
            String entryName = "temp.txt";

            JarEntry entry = new JarEntry(entryName);
            jarOutputStream.putNextEntry(entry);

            StringBuilder fileContent = new StringBuilder();
            Set<Map.Entry<Integer, Yachts>> entrySet = yachtM.entrySet();
            for(Map.Entry<Integer, Yachts> entry1 : entrySet) {
                fileContent.append(entry1.getKey().toString()).append(" ").append(entry1.getValue().toString()).append("\n");
            }
            byte[] contentBytes = fileContent.toString().getBytes();
            jarOutputStream.write(contentBytes, 0, contentBytes.length);


            jarOutputStream.closeEntry();


        } catch (Exception e) {
            System.out.println("Error jar output");
        }


    }
}
