package org.smallkat.customtypes;

public class DHParameters {
    public double distance;
    public double radius;
    public double alpha;
    public double theta;

    public DHParameters(double d, double r, double alpha, double theta){
        this.distance = d;
        this.radius = r;
        this.alpha = alpha;
        this.theta = theta;
    }

    public double getD(){
        return distance;
    }

    public double getR(){
        return radius;
    }

    public double getAlpha(){
        return alpha;
    }

    public double getTheta(){
        return Math.toRadians(theta);
    }

}
