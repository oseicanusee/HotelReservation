package com.company;
import com.company.HotelReservation.Controller.HotelReservationController;
import com.company.HotelReservation.Dao.HotelReservationDaoImpl;
import com.company.HotelReservation.UI.HotelReservationView;
import com.company.HotelReservation.UI.UserIOConsoleImpl;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        UserIOConsoleImpl io = new UserIOConsoleImpl();
        HotelReservationView view = new HotelReservationView(io);
        HotelReservationDaoImpl dao = new HotelReservationDaoImpl();
        HotelReservationController controller = new HotelReservationController(dao, view);
        controller.run();
    }
}

