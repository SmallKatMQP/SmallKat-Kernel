package org.smallkat;

public class Appendage {

    // DH Parameters for the appendage
    float dh_d = 0;
    float dh_r = 0;
    float dh_theta = 0;
    float dh_alpha = 0;

    public Appendage(float d, float r, float theta, float alpha){

        setDH(d, r, theta, alpha);

    }

    // Use Default DH Parameters
    public Appendage(){

    }

    protected void setDH(float d, float r, float theta, float alpha){
        this.dh_d = d;
        this.dh_r = r;
        this.dh_theta = theta;
        this.dh_alpha = alpha;
    }

    /**
     * Getter for DH Parameter for distance
     * d: the offset along previous z to the common normal
     * For more information about DH Parameters, visit https://en.wikipedia.org/wiki/Denavit%E2%80%93Hartenberg_parameters
     * @return float dh_d
     */
    public float getDH_d (){
        return dh_d;
    }

    /**
     * Getter for DH Parameter for radius
     * r: length of the common normal
     * For more information about DH Parameters, visit https://en.wikipedia.org/wiki/Denavit%E2%80%93Hartenberg_parameters
     * @return float dh_r
     */
    public float getDH_r(){
        return dh_r;
    }

    /**
     * Getter for DH Parameter for theta
     * theta: angle about previous z from old x axis to new x axis
     * For more information about DH Parameters, visit https://en.wikipedia.org/wiki/Denavit%E2%80%93Hartenberg_parameters
     * @return float dh_theta
     */
    public float getDH_theta(){
        return dh_theta;
    }

    /**
     * Getter for DH Parameter for alpha
     * alpha: angle about the common normal, from old z axis to new z axis
     * For more information about DH Parameters, visit https://en.wikipedia.org/wiki/Denavit%E2%80%93Hartenberg_parameters
     * @return float dh_alpha
     */
    public float getDH_alpha(){
        return dh_alpha;
    }


}
