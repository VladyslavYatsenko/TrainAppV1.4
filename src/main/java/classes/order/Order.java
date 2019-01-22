package classes.order;

public class Order {
    private int orderId;
    private int passangerId;
    private int trainId;

    public Order() {
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setPassangerId(int passangerId) {
        this.passangerId = passangerId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", passangerId=" + passangerId +
                ", trainId=" + trainId +
                '}';
    }

    public int getPassangerId() {
        return passangerId;
    }

    public int getTrainId() {
        return trainId;
    }


    public Order(int orderId,int trainId,int passangerId) {
        this.orderId=orderId;
        this.trainId = trainId;
        this.passangerId = passangerId;

    }
}
