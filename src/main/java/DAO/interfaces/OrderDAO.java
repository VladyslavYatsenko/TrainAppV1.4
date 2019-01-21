package DAO.interfaces;

public interface OrderDAO {
    public abstract void initOrdersList();
    public abstract int getTrainId(int orderId);
    public abstract int getPassangerId(int orderId);
}
