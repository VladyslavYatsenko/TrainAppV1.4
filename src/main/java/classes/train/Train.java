package classes.train;

import java.util.Objects;


public class Train {
    private int trainId;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private int trainNumber;
    private String initialStation;
    private String endStation;
    private double cost;

    public int getTrainId() {
        return trainId;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getInitialStation() {
        return initialStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public double getCost() {
        return cost;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trainId == train.trainId &&
                trainNumber == train.trainNumber &&
                Double.compare(train.cost, cost) == 0 &&
                Objects.equals(initialStation, train.initialStation) &&
                Objects.equals(endStation, train.endStation) &&
                Objects.equals(departureDate, train.departureDate) &&
                Objects.equals(departureTime, train.departureTime) &&
                Objects.equals(arrivalDate, train.arrivalDate) &&
                Objects.equals(arrivalTime, train.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainId, trainNumber, initialStation, endStation, cost, departureDate, departureTime, arrivalDate, arrivalTime);
    }



    public Train(int trainNumber, String initialStation, String endStation, double cost, String departureDate, String departureTime, String arrivalDate, String arrivalTime) {
        this.trainNumber = trainNumber;
        this.initialStation = initialStation;
        this.endStation = endStation;
        this.cost = cost;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
    }


    public Train(int trainId, int trainNumber, String initialStation, String endStation, double cost,
                 String departureDate, String departureTime, String arrivalDate, String arrivalTime) {
        this.trainId = trainId;
        this.trainNumber = trainNumber;
        this.initialStation = initialStation;
        this.endStation = endStation;
        this.cost = cost;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", trainNumber=" + trainNumber +
                ", initialStation='" + initialStation + '\'' +
                ", endStation='" + endStation + '\'' +
                ", cost=" + cost +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }
}


