package com.example.walkitoff;

import android.content.Context;
import android.location.Location;
import java.util.Scanner;

public class Distance {

    /*
    this class keeps track of distance the user travelled.
    the plan is to create an object
     */

    private double travelledDistance, goalDistance;

    private Context mainContext;

    /*
    user distance goal in feet
     */
    //private static final int userDistanceGoal;
    private static final int DEFAULT_GOAL = 30;

    /**
     * default constructor
     *
     */
    public Distance( Context context ) {

        this( context, DEFAULT_GOAL );
    }

    /**
     * initialization constructor
     *
     * @param inGoalDistance - user set goal distance
     */
    public Distance( Context context, int inGoalDistance ) {

        travelledDistance = 0;

        goalDistance = inGoalDistance;

        mainContext = context;
    }

    /**
     * used to access travelled distance outside of class
     *
     * @return travelledDistance
     */
    public double getTravelledDistance(){

        return travelledDistance;
    }

    /**
     * called by setAlarm method in Alarm class.
     * <p>
     * updates distance every one second until goal distance is reached
     */
    public void trackDistance(){

        // loop while travelled distance less tha goal distance
        while( travelledDistance < goalDistance ){

            // call update distance
            updateDistance();
        }
        // end loop

    }
    
    /**
     * gets the user input for distance
     *
     */
    public void userGoalDistance() {
        
        Scanner reader = new Scanner(System.in);

        //System.out.println(“Enter a goal distance to travel for the alarm: “);
        
        //userDistanceGoal = reader.nextInt();
    }


    /**
     * gets current distance between current location and last known location
     */
    private void updateDistance(){

        LocationData locationTracker = new LocationData( mainContext );

        Location prevLocation = locationTracker.currentLocation();

        locationTracker.updateLocation();

        double addedDistance = locationTracker.currentLocation().distanceTo( prevLocation );

        travelledDistance += UnitsOfMeasurement.toFeet( addedDistance );
    }

}
