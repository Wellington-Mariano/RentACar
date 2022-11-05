/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author welli
 */
public class RentACar implements RentACarInterface {

    private String name;//PROPERTY STRING NAME AND ARRAY
    private List<CarInterface> cars = new ArrayList<>();

    @Override
    public List<CarInterface> getCars() {
        return this.cars;
    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {

        CarInterface car = new Car();//INSTANTIATION OF CAR SO THAT CARINTERFACE METHODS CAN BE USED HERE

        for (CarInterface carIndex : this.cars) {//FOR EACH LOOP OF CARINTERFACE TYPE UNITL LENGHT OF CARS ARRAYLIST
            if (carIndex.getMake() == make) { // IF ITERATION IS EQUAL TO THE MAKE OF PARAMETER BREAK LOOP
                car = carIndex;//ADD TO OBJECT CAR AND BREAK LOOP
                break;
            }
        }

        boolean[] daysOfStay = car.getAvailability().get(month);
        //TAKING CAR AVAILABILITY AND THOWING INSIDE DAYSOFSTAY VALUE OF RETURN IS BOOLEAN

        for (int i = day; i < lengthOfRent; i++) {//IF NOT DAYS ENOUGH AVAILABLE RETURN FALSE
            if (daysOfStay[i] == false) {
                return false;
            }
        }
        return true; // ELSE TRUE
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        CarInterface car = new Car(); //INSTANTIATION OF CAR SO THAT CARINTERFACE METHODS CAN BE USED HERE

        for (CarInterface carIndex : this.cars) {
            if (carIndex.getMake() == make) {//ACCESSING METHOD GET MAKE FROM CAR INTERFACE
                car = carIndex;
                break;
            }
        }

        return car.getId();
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        Car car = new Car();
        //LOOPING THROUGH THE CARS TO FIND AVAILABLE DAY AND AVAILABLE LENGTH
        for(int i = 0; i < this.cars.size(); i++){
            if(this.cars.get(i) == make){
                cars.get(i);
                break;
            }
        }
    }

    @Override
    public int getNumberOfCars() {
        int total = 0;

        
        for (CarInterface car : this.cars) {
            total += car.getId();
        }

        return total;
    }

}
