package org.smallkat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MotorTester {


    LinkedList<Motor> motorlist;

    MotorTester() {
        motorlist = new LinkedList<>();

        motorlist.add(new Motor("Motor1"));
        motorlist.add(new Motor("Motor2"));
        motorlist.add(new Motor("Motor3"));
        motorlist.add(new Motor("Motor4"));
    }


    public static void main(String[] args) {
        MotorTester tester = new MotorTester();
        Scanner sc = new Scanner(System.in);

        boolean stop = false;

        while (!stop) {
            System.out.println("What motor would you like to control? Or type \"exit\" to exit the program");
            String motorin = sc.nextLine();

            if (!motorin.equals("exit")) {

                for (Motor motor : tester.getMotorlist()) {
                    if (motor.getName().equals(motorin)) {
                        boolean exitMotorControl = false;
                        while (!exitMotorControl) {
                            System.out.println("Please input the motor position you would like," +
                                    " or type \"exit\" return to previous menu:");
                            String input = sc.nextLine();
                            try {
                                double pos = Double.parseDouble(input);
                                motor.setPosition(pos);
                            } catch(NumberFormatException e){
                                if (input.equals("exit")){
                                    exitMotorControl = true;
                                } else {
                                    System.out.println("The input was not a valid number");
                                }
                            }

                        }
                    }
                }

            } else {
                stop = true;
            }
        }
    }

    public LinkedList<Motor> getMotorlist() {
        return motorlist;
    }


}
