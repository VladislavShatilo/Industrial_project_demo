package com.example.pp1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TxtOutput implements TxtOutputInterface{

    @Override
    public void write(List<Yachts> yacht,String output) {
        try( FileWriter output1 = new FileWriter("temp.txt")) {
            for(Yachts ya:yacht) {
                output1.write("name: "+ya.GetName()+", material: "+ya.GetMaterial()+ ", cost: "+ ya.GetCoast()+ ", maxSpeed; "+ ya.GetMaxSpeed()+"\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error");
        }

    }

    @Override
    public void writeMap(Map<Integer,Yachts> yachtsM, String output) {

            try( FileWriter output1 = new FileWriter(output)) {
                for(int i = 0; i <yachtsM.size(); i++ ) {
                    output1.write(yachtsM.keySet().iterator().next());
                    output1.write("name: "+yachtsM.get(i).GetName()+", material: "+yachtsM.get(i).GetMaterial()+ ", cost: "+ yachtsM.get(i).GetCoast()+ ", maxSpeed; "+ yachtsM.get(i).GetMaxSpeed()+"\n");

                }
            }
            catch (IOException e)
            {
                System.out.println("Error");
            }

        }



}
