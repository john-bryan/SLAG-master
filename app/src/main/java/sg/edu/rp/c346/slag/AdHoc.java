package sg.edu.rp.c346.slag;

public class AdHoc {

        private int userID;
        private String name;
        private String address;
        private String itemsCollected;
        // constructors

    public AdHoc(int userID, String name, String address, String itemsCollected) {
            this.userID = userID;
            this.name = name;
            this.address = address;
            this.itemsCollected = itemsCollected;
        }

    // properties
    public void setUserID(int id) {
        this.userID = id;
    }
    public int getID() {
        return this.userID;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getItemsCollected() {
        return itemsCollected;
    }

    public void setItemsCollected(String itemsCollected) {
        this.itemsCollected = itemsCollected;
    }
}

