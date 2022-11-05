/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author welli
 */
public class Car implements CarInterface {

    private Make make;
    private double rate;
    private Map<Month, boolean[]> availability;//MAP HAS KEY MONTH AND VALUE BOOLEAN
    private int id;
    private int carQuantity;

    @Override
    public Map<Month, boolean[]> createAvailability() {
        this.availability = new HashMap<>();// instantiating a hashmap

        for (Month month : Month.values()) {//FOR EACH USING MONTH AS A TYPE AND VALUES OF MONTH AS PAR
            boolean[] days = new boolean[month.getNumberOfDays()];//DAYS ARE AN ARRAY O BOOLEANS WITH NUMBER OF DAYS PARAMETER

            int index = 0;

            while (index < days.length) {
                days = true;
                //ATTEMPTING TO ASSIGNE TRUE TO ALL DAYS BOOLEAN VALUES
            }
            return this.availability;
        }
    }

    @Override
    public Make getMake() {
        return this.make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public double getRate() {
        return this.rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {
        return this.availability;
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        this.availability = availability;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        return this.availability.get(month) && day; //ATTEMPTING OF RETURNING MONTH AND DAY VALUE
    }

    @Override
    public boolean book(Month month, int day) {
        boolean available = this.isAvailable(month, day);

        if (available) {
            boolean[] days = this.availability.get(month);
            days[day] = false;
            this.availability.put(month, days);
            return true;
        }
        return false;
    }
}
