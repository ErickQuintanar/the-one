package report;

import core.ConnectionListener;
import core.DTNHost;

import java.util.Random;


public class EpidemicReport extends Report
        implements ConnectionListener {
    public int start;
    private double noMask[] = new double[]{85,43,68,68,70};
    private double ffp2Mask[] = new double[]{0.48,0.17,0.28,0.28,0.30};
    private double surgicalMask[] = new double[]{38,16,25,25,26};
    //Magistrale,MI HS 1,MI HS 2,MI HS 3,Typical Classroom // the order of the array
    public EpidemicReport() {
        init();
    }

    public void hostsConnected(DTNHost h1, DTNHost h2) {
        if (isWarmup() || h1.getState() ==121 || h2.getState() == 121) {
            addWarmupID(connectionString(h1, h2));
            return;
        }

        newEvent();
        double spreadStats[];
        if(h1.getMaskType().equals("surgical"))
            spreadStats = surgicalMask;
        else if(h1.getMaskType().equals("ffp2"))
            spreadStats = ffp2Mask;
        else
            spreadStats = noMask;

        if (!(h1.getIsInfected() && h2.getIsInfected())&&(h1.getIsInfected() || h2.getIsInfected())){
            boolean infected = false;
            double chance = this.getRandomValue();
            //define condition for spread depending on the room type
            switch (h1.getState()){
                case 120://RX
                    if(chance <= spreadStats[4])
                        infected=true;
                    break;
                case 122://Magistrale
                    if(chance <= spreadStats[0])
                    break;
                case 123://HS1
                    if(chance <= spreadStats[1])
                    break;
                case 124://HS2
                    if(chance <= spreadStats[2])
                    break;
                case 125://HS3
                    if(chance <= spreadStats[3])
                    break;
            }
            if (infected){
                h1.setIsInfected(true);
                h2.setIsInfected(true);
                write(createTimeStamp() + " " + connectionString(h1, h2) + " up in state : " +h1.getState()+" => successful transmission");
            }
            else{
                write(createTimeStamp() + " " + connectionString(h1, h2) + " up in state : " +h1.getState()+" => failed transmission");
            }
        }
        else
            write(createTimeStamp() + " " + connectionString(h1, h2) + " up in state : " +h1.getState()+" => no transmission");
    }

    public void hostsDisconnected(DTNHost h1, DTNHost h2) {
        String conString = connectionString(h1, h2);

        if (isWarmup() || isWarmupID(conString)) {
            removeWarmupID(conString);
            return;
        }

        newEvent();
        //write("" + createTimeStamp() + " " + conString + " down" + " STATE");
    }

    /**
     * Creates and returns a "@" prefixed time stamp of the current simulation
     * time
     * @return time stamp of the current simulation time
     */
    private String createTimeStamp() {
        return String.format("@%.2f", getSimTime());
    }

    /**
     * Creates and returns a String presentation of the connection where the
     * node with the lower network address is first
     * @param h1 The other node of the connection
     * @param h2 The other node of the connection
     * @return String presentation of the connection
     */
    private String connectionString(DTNHost h1, DTNHost h2) {
        if (h1.getAddress() < h2.getAddress()) {
            return h1 + " <-> " + h2;
        }
        else {
            return h2 + " <-> " + h1;
        }
    }

    //random number generator
    public double getRandomValue(){
        double numb =(new Random().nextDouble() * (100 - 1)) + 1;
        return Double.parseDouble(String.format("%." + 2 + "f", numb));
    }
}
