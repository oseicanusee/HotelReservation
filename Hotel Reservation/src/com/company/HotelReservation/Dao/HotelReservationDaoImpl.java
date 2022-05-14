package com.company.HotelReservation.Dao;

import com.company.HotelReservation.Dto.Reservation;


import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class HotelReservationDaoImpl implements HotelReservationDao {
    private ArrayList<Reservation> reservations;

    public HotelReservationDaoImpl(){
        this.reservations = new ArrayList<>();
    }

    @Override
    public ArrayList<Reservation> uploadReservation() throws FileNotFoundException {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {
                String res = scanner.nextLine();
                if (res.isEmpty()) {
                    continue;
                }

                Reservation reservation = unmarshallReservation(res);
                this.reservations.add(reservation);
            }
            scanner.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
            return this.reservations;
    }

    private Reservation unmarshallReservation(String reservation){
        // takes the line and splits. Returns the line as a reservation to add to the ArrayList.
        String[] line = reservation.split(" ");
        String lastName = line[0];
        String firstName = line[1];
        int nights = Integer.parseInt(line[2]);
        Double dailyRate = Double.parseDouble(line[3]);

        return new Reservation(lastName, firstName, nights, dailyRate);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        Reservation res = reservation;
        this.reservations.add(res);
        return res;
    }

    @Override
    public Reservation updateReservation(Reservation oldReservation, Reservation newReservation) {

        for (Reservation res : reservations){
            if (res.getLastName().equalsIgnoreCase(oldReservation.getLastName()) && res.getFirstName().equalsIgnoreCase(oldReservation.getFirstName())){
                res.setLastName(newReservation.getLastName());
                res.setFirstName(newReservation.getFirstName());
                res.setNumOfNights(newReservation.getNumOfNights());
                res.setDailyRate(newReservation.getDailyRate());
                return res;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Reservation> getAllReservations() {
        return this.reservations;
    }



    @Override
    public Reservation getReservation(String lastName, String firstName) {
        for (Reservation res : this.reservations){
            if (res.getLastName().equalsIgnoreCase(lastName) && res.getFirstName().equalsIgnoreCase(firstName)){
                return res;
            }
        }
        return null;
    }

    public Reservation getReservation(String[] info){
        String lastName = info[0];
        String fName = info[1];

        for(Reservation res : this.reservations){
            if(res.getLastName().equalsIgnoreCase(lastName) && res.getFirstName().equalsIgnoreCase(fName)){
                return res;
            }
        }
        return null;
    }

    @Override
    public void downloadReservations(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter((new FileWriter("reservations.txt")));

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String res;
        for(Reservation reservation : this.reservations){
            res = marshallDvd(reservation);
            writer.write(res);
            writer.flush();
        }

        writer.close();
    }

    private String marshallDvd(Reservation reservation){
        String lName = reservation.getLastName();
        String fName = reservation.getFirstName();
        int nights = reservation.getNumOfNights();
        double rate = reservation.getDailyRate();

        String line = lName + " " + fName + " " + nights + " " + rate;
        return line;
    }

}
