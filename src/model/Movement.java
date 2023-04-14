package model;


import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Movement implements Serializable {
    private int movementId;
    private String type;
    private LocalDate date;
    private String destinationCountry;
    private String originCountry;
    private ArrayList<Item> items;
    private Supplier supplier;
    private Customer customer;
    
    public Movement() {
    }

    public Movement(int movementId, String type, LocalDate date, String destinationCountry,
            String originCountry, Supplier supplier,Customer customer) {
        this.movementId = movementId;
        this.type = type;
        this.date = date;
        this.destinationCountry = destinationCountry;
        this.originCountry = originCountry;
        this.items = new ArrayList<>();
        this.supplier = supplier;
        this.customer = customer;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int getMovementId() {
        return movementId;
    }

    public void setMovementId(int movementId) {
        this.movementId = movementId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double calculateItemPrice() {
        double totalPrice = 0;
        double price_w = 0;
        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getTotalWeight() > 0 && items.get(i).getTotalWeight() < 250) {
                price_w = items.get(i).getTotalWeight() * 3.4;
            }

            if (items.get(i).getTotalWeight() >= 250 && items.get(i).getTotalWeight() < 500) {
                price_w = items.get(i).getTotalWeight() * 5.2;
            }

            if (items.get(i).getTotalWeight() >= 500 && items.get(i).getTotalWeight() < 750) {
                price_w = items.get(i).getTotalWeight() * 7.8;
            }

            if (items.get(i).getTotalWeight() >= 750 && items.get(i).getTotalWeight() <= 1000) {
                price_w = items.get(i).getTotalWeight() * 9.3;
            }

            if (items.get(i).getTotalWeight() > 1000) {
                price_w = items.get(i).getTotalWeight() * 17.6;
            }
            totalPrice += price_w;
        }

        return totalPrice;
    }

    public double calculateTotalPriceByImports() {
        double totalPrice = this.calculateItemPrice();
        double itemsTotalPriceByImportation = totalPrice + ((totalPrice * 29) / 100);
        return itemsTotalPriceByImportation;
    }

    public double calculateTotalPriceByExports() {
        double totalPrice = this.calculateTotalPriceByExports();
        double itemsTotalPriceByExports = totalPrice + ((totalPrice * 12) / 100);
        return itemsTotalPriceByExports;
    }
    
    public String showTotalPrice(){
        String aux = "";
        DecimalFormat df = new DecimalFormat("#.00");
        if (type.equals("Import")) {
            aux += "Total Price of Items: " + df.format(this.calculateTotalPriceByImports()) + " EUR";
        } else {
            aux += "Total price of Items: " + df.format(this.calculateTotalPriceByImports()) + " EUR";
        }
        return aux;
    }

    @Override
    public String toString() {
        return "Movement" + "\n" + "id: " + movementId + "\n" + "Type: " + type + "\n" + "Date: " + date + 
        "\n" + "Destination Country: " + destinationCountry + "\n" + "Origin Country: " + originCountry + "\n" + "Items: " + items.size() + 
        "\n" + "Supplier: " + supplier.toString() + "\n" + "Customer: " + customer.toString() + "\n"+ this.showTotalPrice();
    }
}