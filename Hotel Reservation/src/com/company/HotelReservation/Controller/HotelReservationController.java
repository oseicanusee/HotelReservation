package com.company.HotelReservation.Controller;

import com.company.HotelReservation.Dao.HotelReservationDaoImpl;
import com.company.HotelReservation.Dto.Reservation;
import com.company.HotelReservation.UI.HotelReservationView;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HotelReservationController {
    private HotelReservationView view;
    private HotelReservationDaoImpl dao;


    public HotelReservationController(HotelReservationDaoImpl dao, HotelReservationView view){
        this.view = view;
        this.dao = dao;
    }

    public void run() throws FileNotFoundException {
        boolean keepGoing = true;

        while(keepGoing){
            int choice = getMenuSelection();

            switch (choice){
                case 1: getReservation();
                        break;
                case 2: uploadReservations();
                        break;
                case 3: newReservation();
                        break;
                case 4: updateReservation();
                        break;
                case 5: viewAllReservations();
                        break;
                case 6: downloadReservations();
                        break;
                case 7: keepGoing = false;
                        break;
            }
        }


    }

    public void getReservation(){
        String fName = view.getFirstName();
        String lName = view.getLastName();
        Reservation reservation = dao.getReservation(lName, fName);
        view.printReservation(reservation);
    }

    public void downloadReservations(){
       dao.downloadReservations();
    }

    public int getMenuSelection(){
        return view.getMenuSelection();
    }

    public void uploadReservations() throws FileNotFoundException {
        ArrayList<Reservation> reservationsList = dao.uploadReservation();
        view.displayUploadReservationSuccessfulBanner(reservationsList);
    }

    public void newReservation(){
        Reservation reservation = view.getReservationInformation();
        Reservation reservation1 = dao.addReservation(reservation);
        view.reservationSuccessfullyAddedBanner(reservation1);
    }

    public void updateReservation(){
        String[] info = view.getFirstAndLastName();
        Reservation currReservation = dao.getReservation(info);
        Reservation newReservation = view.getUpdateReservationInformation();
        Reservation updatedReservation = dao.updateReservation(currReservation, newReservation);
        view.displayReservationSuccessfullyUpdatedBanner(newReservation, updatedReservation);
    }

    public void viewAllReservations(){
        ArrayList<Reservation> allReservations = dao.getAllReservations();
        view.printAllReservations(allReservations);
    }
}
