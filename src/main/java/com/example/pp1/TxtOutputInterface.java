package com.example.pp1;

import java.util.List;
import java.util.Map;

public interface TxtOutputInterface {
     void write(List<Yachts> yacht,String output);
     void writeMap(Map<Integer,Yachts> yachtM,String output);
}
