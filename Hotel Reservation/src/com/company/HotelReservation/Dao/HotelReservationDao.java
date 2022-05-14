package com.company.HotelReservation.Dao;

import com.company.HotelReservation.Dto.Reservation;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface HotelReservationDao {

    ArrayList<Reservation> uploadReservation() throws FileNotFoundException;
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation oldReservation, Reservation newReservation);
    ArrayList<Reservation> getAllReservations();
    Reservation getReservation(String lastName, String firstName);
    void downloadReservations();
}
