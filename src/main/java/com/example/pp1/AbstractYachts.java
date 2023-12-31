package com.example.pp1;

import java.util.Comparator;

public abstract class AbstractYachts {

    protected  String name;
    protected  String material;
    protected  int coast;
    protected  int maxSpeed;

    public  AbstractYachts( String name, String material ,int coast, int maxSpeed) {
        this.name = name;
        this.material = material;
        this.coast = coast;
        this.maxSpeed = maxSpeed;
    }

    public String GetName() {
        return name;
    }

    public String GetMaterial() {
        return material;
    }

    public int GetCoast() {
        return coast;
    }

    public int GetMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return
                "name= '" + name +
                "' , material= '" + material +
                "' , coast= '" + coast +
                "' , maxSpeed= '" + maxSpeed+" '"
                ;
    }
    static class YachtsComparator implements Comparator<Yachts> {

        public int compare(Yachts obj1, Yachts obj2) {
            int nameComparison = obj1.name.compareTo(obj2.name);
            if (nameComparison != 0) {
                return nameComparison;
            }

            int materialComparison = obj1.material.compareTo(obj2.material);
            if (materialComparison != 0) {
                return materialComparison;
            }

            int coastComparison = Integer.compare(obj1.coast, obj2.coast);
            if (coastComparison != 0) {
                return coastComparison;
            }

            return Integer.compare(obj1.maxSpeed, obj2.maxSpeed);

        }
    }
}
