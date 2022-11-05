/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import ooc.enums.Make;

/**
 *
 * @author welli
 */
public class BookingSystem implements BookingSystemInterface {

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        
        String title = in.readLine();//LINE RECEIVES THE NAME OF THE CAR RENTAL
        int lineIndex = 0;

        String info = "";
        
        RentACarInterface carRental = new RentACar();//RENTACAR INSTANTIATION TO APPLY THE METHODS INSIDE RENTACAR INTERFACE
        
        ArrayList<CarInterface> cars = new ArrayList<CarInterface>();//LSIT TO STORE CARS

        while (title != null) {//WHILE LINE NOT NULL KEEP GOING
            if (lineIndex == 0) {//APPLY TITLE TO THE TITLE VARIABLE
                info = in.readLine();
            } else {//NO LONGER FIRST LINE AND FILE FOLLOWS A PATTERN SO ELSE FITS HERE
                String[] data = title.split(":");
                String make = data[0];//EVERY FIRST WORD GOES ASSIGNES THE MAKE

                int carQuantity = Integer.valueOf(data[2]);//EVERY THIRD WORD FROM FILE BECOMES AMOUNT OF CARS

                Car car = new Car(); //NEW CAR OBJECT IN ORDER TO SET MAKE AND RATE METHODS THAT ARE INSIDE CAR CLASS

                car.setMake(Make.valueOf(make));
                car.setRate(carQuantity);
                cars.add(car);//CAR ADDED TO THE LIST FINALLY
            }
            lineIndex++;//CHANGE INDEX SO NEXT LINE IS READ
        }

        carRental.setCars(cars);//CARRENTAL SET CARS CALLED TO APPLY LIST TO THIS METHOD
        carRental.setName(title);//SETTING THE NAME FOR OUR RENTAL CAR

        return carRental;//RETURN A RENTACARINTERFACE
    }
}
