package DAO.interfaces;

public interface PassangerDAO {
    public abstract void initPassengersList();
    public abstract String getPassangerFirstName(int passangerId);
    public abstract String getPassangerLastName(int passangerId);
    public abstract int getTrainId(int passangerId);
}
