package com.company.HotelReservation.UI;

import com.company.HotelReservation.Dto.Reservation;

import java.util.ArrayList;

public class HotelReservationView {
    private UserIOConsoleImpl io;

    public HotelReservationView(UserIOConsoleImpl io){
        this.io = new UserIOConsoleImpl();
    }

    public int getMenuSelection(){
         io.print("Welcome to Bekwai Hotel Reservation System. Please choose from one of the following options.");
         io.print("\t\t1. Get reservation. ");
         io.print("\t\t2. Upload reservations.");
         io.print("\t\t3. New reservation.");
         io.print("\t\t4. Update reservation.");
         io.print("\t\t5. View all existing reservations");
         io.print("\t\t6. Download reservations.");
         io.print("\t\t7. Exit the program.");

        return io.readInt("Select from the options above.", 1, 7);
    }

    public String getFileName(){
        return io.readString("Enter file name with reservations: ");
    }

    public void displayUploadReservationSuccessfulBanner(ArrayList<Reservation> reservations){
        if (reservations.size() > 0){
            io.print("=== Reservations Successfully uploaded ===");
        } else {
            io.print("=== Upload Unsuccessful. ===");
        }
    }

    public Reservation getReservationInformation(){
        io.print("Reservation Details ");
        String lastName = io.readString("Enter last name: ");
        String firstName = io.readString("Enter first name: ");
        int nights = io.readInt("Enter number of nights: ");
        double rate = io.readDouble("Enter daily rate: ");

        return new Reservation(lastName, firstName, nights, rate);
    }

    public void reservationSuccessfullyAddedBanner(Reservation reservation){
        if(!reservation.getLastName().isEmpty()){
            io.print("=== Reservation Successfully Added. ===");
        } else {
            io.print("=== Reservation not found ===");
        }
    }

    public String[] getFirstAndLastName(){
        String lastName = io.readString("Enter last name of reservation: ");
        String firstName = io.readString("Enter first name of reservation: ");

        return new String[]{lastName, firstName};
    }


    public Reservation getUpdateReservationInformation(){
        String lName = io.readString("Enter new first name: ");
        String fName = io.readString("Enter new last name: ");
        int nights = io.readInt("Enter new number of nights: ");
        double rate = io.readDouble("Enter new daily rate: ");

        return new Reservation(lName, fName, nights, rate);
    }


    public void displayReservationSuccessfullyUpdatedBanner(Reservation newReservation, Reservation updatedReservation) {
        if (newReservation.equals(updatedReservation)){
            io.print("Reservation Successfully Updated");
        } else {
            io.print("Reservation Not Updated.");
        }
    }

    public void printAllReservations(ArrayList<Reservation> reservations) {
        for (Reservation res : reservations){
            System.out.println(res.toString());
        }
    }

    public void printReservation(Reservation res){
        System.out.println(res.toString());
    }

    public String getFirstName() {
        return io.readString("Enter first name: ");
    }

    public String getLastName() {
        return io.readString("Enter last name: ");
    }
}
