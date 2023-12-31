package com.example.pp1;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDecorator implements TxtOutputInterface{
    TxtOutputInterface txtOutputInterface ;
    public ZipDecorator(TxtOutputInterface txtOutputInterface) {
        this.txtOutputInterface = txtOutputInterface;
    }
    @Override
    public void write(List<Yachts> yacht,String output) {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(output))) {
            ZipEntry entry = new ZipEntry("temp.txt");
            zipOutputStream.putNextEntry(entry);

            StringBuilder fileContent = new StringBuilder();
            for(Yachts ya:yacht) {
                fileContent.append(ya.GetName()).append(" ").append(ya.GetMaterial()).append(" ").append(ya.GetCoast()).append(" ").append(ya.GetMaxSpeed()).append("\n");
            }
            byte[] contentBytes = fileContent.toString().getBytes();
            zipOutputStream.write(contentBytes, 0, contentBytes.length);

            zipOutputStream.closeEntry();
            zipOutputStream.closeEntry();
        }
        catch (Exception e)
        {
            System.out.println("error");
        }


    }

    @Override
    public void writeMap(Map<Integer,Yachts> yachtM, String output) {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(output))) {
            ZipEntry entry = new ZipEntry("temp.txt");
            zipOutputStream.putNextEntry(entry);

            StringBuilder fileContent = new StringBuilder();

            Set<Map.Entry<Integer, Yachts>> entrySet = yachtM.entrySet();
            for(Map.Entry<Integer, Yachts> entry1 : entrySet) {
                fileContent.append(entry1.getKey().toString()).append(" ").append(entry1.getValue().toString()).append("\n");
            }
            byte[] contentBytes = fileContent.toString().getBytes();
            zipOutputStream.write(contentBytes, 0, contentBytes.length);

            zipOutputStream.closeEntry();
            zipOutputStream.closeEntry();
        }
        catch (Exception e)
        {
            System.out.println("error");
        }


    }
}
