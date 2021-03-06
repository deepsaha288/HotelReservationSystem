package com.hotel.system;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {
    /**
     * method to return hotel name
     */
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel newHotel = hotelReservation.addHotel("Lakewood", "Regular", 110, 90, 3);
        Assertions.assertEquals(newHotel.getHotelName(), "Lakewood");
    }

    /**
     * method to return customer type
     */
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredCustomerType() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel newHotel = hotelReservation.addHotel("Lakewood", "Regular", 110, 60, 3);
        Assertions.assertEquals(newHotel.getcustomerType(), "Regular");
    }

    /**
     * method to return hotel weekday rate
     */
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel newHotel = hotelReservation.addHotel("Lakewood", "Regular", 110, 150, 3);
        Assertions.assertTrue(newHotel.getWeekdayRate().equals(110));
        ;
    }

    /**
     * method to return hotel weekend rate
     */
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShoulReturnEnteredWeekendRate() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel firstHotel = hotelReservation.addHotel("Lakewood", "Regular", 110, 90, 3);
        Hotel secondHotel = hotelReservation.addHotel("Bridgewood", "Regular", 160, 50, 4);
        Hotel thirdHotel = hotelReservation.addHotel("Ridgewood", "Regular", 220, 150, 5);
        Assertions.assertTrue(secondHotel.getWeekendRate().equals(50));
    }

    /**
     * method to return hotel rating
     */
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredRating() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel newHotel = hotelReservation.addHotel("Lakewood", "Regular", 110, 90, 3);
        Assertions.assertTrue(newHotel.getRating().equals(3));
    }

    /**
     * method to return cheapest hotel on the basis of cost and rating
     */
    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRateOnBasisOfCostAndRating() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<Hotel> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood", "Regular", 110, 90, 3));
        hotelArray.add(hotelReservation.addHotel("Bridgewood", "Regular", 160, 50, 4));
        hotelArray.add(hotelReservation.addHotel("Ridgewood", "Regular", 220, 150, 5));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray, "2020-09-11", "2020-09-12");
        Assertions.assertEquals("Bridgewood", cheapestHotel.getHotelName());
    }

}
