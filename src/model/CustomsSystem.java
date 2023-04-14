package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import tools.WriteObject;

public class CustomsSystem {
    private ArrayList<Item> itemsExport;
    private ArrayList<Item> itemsImport;
    private ArrayList<Movement> movements;
    private WriteObject writeFile;

    public CustomsSystem() {
        this.itemsExport = new ArrayList<>();
        this.itemsImport = new ArrayList<>();
        this.movements = new ArrayList<>();
    }

    public ArrayList<Item> getItemsExport() {
        return itemsExport;
    }

    public void setItemsExport(ArrayList<Item> itemsExport) {
        this.itemsExport = itemsExport;
    }

    public ArrayList<Item> getItemsImport() {
        return itemsImport;
    }

    public void setItemsImport(ArrayList<Item> itemsImport) {
        this.itemsImport = itemsImport;
    }

    public ArrayList<Movement> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Movement> movements) {
        this.movements = movements;
    }

    public void registerItemImport(Item item) {
        this.itemsImport.add(item);
    }

    public void registerItemExport(Item item) {
        this.itemsExport.add(item);
    }
    
    public void registerMovement(Movement movement){
        this.movements.add(movement);
    }
    
    public void createMovementsFiles(String path) throws IOException {
        for (int i = 0; i < movements.size(); i++) {
            writeFile = new WriteObject(path + "Movement_" + movements.get(i).getMovementId() + ".trade");
            writeFile.writeObject(movements.get(i));
        }
        writeFile.cleanUp();
    }

    public String filterByDate(LocalDate date) {
        String  aux = "There are no movements registered on that date. Please check the date and try again.";
        for (int i = 0; i < movements.size(); i++) {
            if (movements.get(i).getDate().equals(date)) {
                aux = "~" + movements.get(i).getMovementId() + " -> " + movements.get(i).getType() + " on " +
                        movements.get(i).getDate().getYear() + "-" + movements.get(i).getDate().getMonthValue() + "-" + movements.get(i).getDate().getDayOfMonth() + " from " +
                        movements.get(i).getOriginCountry() + " to " + movements.get(i).getDestinationCountry() + "\n";
            } 
        }
        return aux;
    }

    public String filterByExports() { 
        String aux = "There are no exports registered yet. Please register an export first.";
            for (int i = 0; i < movements.size(); i++) {
                if (movements.get(i).getType().equals("Export")){
                    aux = "~" + movements.get(i).getMovementId() + " -> " + movements.get(i).getType() + " on " +
                        movements.get(i).getDate().getYear() + "-" + movements.get(i).getDate().getMonthValue() + "-" + movements.get(i).getDate().getDayOfMonth() + " from " +
                        movements.get(i).getOriginCountry() + " to " + movements.get(i).getDestinationCountry() + "\n";
                } 
            }
        return aux;
    }

    public String filterByImports() { 
        String aux = "There are no imports registered yet. Please register an import first.";
            for (int i = 0; i < movements.size(); i++) {
                if (movements.get(i).getType().equals("Import")){
                    aux = "~" + movements.get(i).getMovementId() + " -> " + movements.get(i).getType() + " on " +
                        movements.get(i).getDate().getYear() + "-" + movements.get(i).getDate().getMonthValue() + "-" + movements.get(i).getDate().getDayOfMonth() + " from " +
                        movements.get(i).getOriginCountry() + " to " + movements.get(i).getDestinationCountry() + "\n";
                }
            }
        return aux;
    }

    public String filterByIdentification(int movementId) {
        String aux =  "There is no movement with that ID. Please check the ID and try again.";
        for (int i = 0; i < movements.size(); i++) {
            if (movements.get(i).getMovementId() == movementId) {
                aux = "~ " + movements.get(i).getMovementId() + " -> " + movements.get(i).getType() + " on " +
                        movements.get(i).getDate().getYear() + "-" + movements.get(i).getDate().getMonthValue() + "-" + movements.get(i).getDate().getDayOfMonth() + " from " +
                        movements.get(i).getOriginCountry() + " to " + movements.get(i).getDestinationCountry() + "\n";
            }
        }
        
        return aux;
    }


    public String showMovements(List<Movement> movements){
        String aux = "";
        for (int index = 0; index < movements.size(); index++) {
            aux = movements.get(index).getMovementId() + " -> " + movements.get(index).getType() + " on " +
            movements.get(index).getDate().getYear() + "-" + movements.get(index).getDate().getMonthValue() + "-" + movements.get(index).getDate().getDayOfMonth() + " from " +
            movements.get(index).getOriginCountry() + " to " + movements.get(index).getDestinationCountry() + "\n";
        }
        return aux;
    }
    
    public String showMovementsHistory() { 
        String aux = "";
        for (Movement movementHistory : movements) {
            aux = "~ " + movementHistory.getMovementId() + " -> " + movementHistory.getType() + " on " +
            movementHistory.getDate().getYear() + "-" + movementHistory.getDate().getMonthValue() + "-" + movementHistory.getDate().getDayOfMonth() + " from " +
            movementHistory.getOriginCountry() + " to " + movementHistory.getDestinationCountry() + "\n";
        }
        return aux;
    }
    
    public String showMovementInfoById(int movementId) {
        String aux = "There is no movement with that ID. Please check the ID and try again.";
        for (Movement movement: movements) {
            if (movement.getMovementId() == movementId){
                aux = movement.toString();
            }
                
        }
        return aux;
    }
    
}
