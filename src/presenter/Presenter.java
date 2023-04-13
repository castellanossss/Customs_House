package presenter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import model.Customer;
import model.CustomsSystem;
import model.Item;
import model.Movement;
import model.Supplier;
import tools.ReadLoginInfo;
import view.CustomerView;
import view.CustomsAgentView;
import view.ItemView;
import view.Menus;
import view.MovementView;
import view.SupplierView;

public class Presenter {
    private Menus menus;
    private ReadLoginInfo rli;
    private CustomsAgentView agentView;
    private ItemView itemView;
    private MovementView movementView;
    private SupplierView supplierView;
    private CustomerView customerView;
    private CustomsSystem customSystem;

    public Presenter() {
        menus = new Menus();
        agentView = new CustomsAgentView();
        itemView = new ItemView();
        movementView = new MovementView();
        supplierView = new SupplierView();
        customerView = new CustomerView();
        customSystem = new CustomsSystem();
    }

    private boolean validateLoginInputs(String username, String password) {
        boolean isValid = false;
        try {
            rli = new ReadLoginInfo(Constants.LOGIN_INFO_PATH);
            rli.readFile();

            for (int i = 0; i < rli.getUsernames().size(); i++) {
                if (rli.getUsernames().get(i).equals(username) && rli.getPasswords().get(i).equals(password)) {
                    isValid = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            menus.printBorderedMessage(e.getMessage());
        } catch (IOException e) {
            menus.printBorderedMessage(e.getMessage());
        }
        return isValid;
    }

    private boolean validateAgentLogin() {
        boolean flag = false;
        do {
            String username = agentView.requestInfo(Constants.ASK_FOR_AGENT_USER);
            String password = agentView.requestInfo(Constants.ASK_FOR_AGENT_PASSWORD); 
            
            if (validateLoginInputs(username, password)) {
                menus.printBorderedMessage(Constants.SUCCESFUL_AGENT_LOGIN);
                flag = true;
            } else {
                menus.printBorderedMessage(Constants.UNSUCCESFUL_AGENT_LOGIN);
            }
        } while (!flag);
        return flag;
    }

    private int validateItemId() {
        boolean flag = true;
        int id = 0;
        do {
            try {
                String input = itemView.requestInfo(Constants.ASK_FOR_ITEM_ID);
                id = Integer.parseInt(input);
                flag = false;
            } catch (NumberFormatException e) {
                itemView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return id;
    }

    private double validateItemWeight() {
        boolean flag = true;
        double weight = 0;
        do {
            try {
                String input = itemView.requestInfo(Constants.ASK_FOR_ITEM_WEIGHT);
                weight = Double.parseDouble(input);
                flag = false;
            } catch (NumberFormatException e) {
                itemView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return weight;
    }

    private double validateItemPrice() {
        boolean flag = true;
        double price = 0;
        do {
            try {
                String input = itemView.requestInfo(Constants.ASK_FOR_ITEM_PRICE);
                price = Double.parseDouble(input);
                flag = false;
            } catch (NumberFormatException e) {
                itemView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return price;
    }

    private int validateItemQuantity() {
        boolean flag = true;
        int quantity = 0;
        do {
            try {
                String input = itemView.requestInfo(Constants.ASK_FOR_ITEM_QUANTITY);
                quantity = Integer.parseInt(input);
                flag = false;
            } catch (NumberFormatException e) {
                itemView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return quantity;
    }

    private Item createItem() {
        itemView.printBorderedTitleMessage();
        int itemId = validateItemId();
        String itemName = itemView.requestInfo(Constants.ASK_FOR_ITEM_NAME);
        double itemWeight = validateItemWeight();
        double itemPrice = validateItemPrice();
        Item item = new Item(itemId,itemName, itemWeight, itemPrice);

        itemView.printBorderedMessage(Constants.ITEM_REGISTERED_SUCCESSFULLY);
        return item;
    }

    private int validateSupplierId() {
        boolean flag = true;
        int supplierId = 0;
        do {
            try {
                String input = supplierView.requestInfo(Constants.ASK_FOR_SUPPLIER_ID);
                supplierId = Integer.parseInt(input);
                flag = false;
            } catch (NumberFormatException e) {
                supplierView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return supplierId;
    }

    private Supplier createSupplier() {
        supplierView.printBorderedMessage(Constants.REQUEST_SUPPLIER_INFO);
        supplierView.printBorderedTitleMessage();
        int id = validateSupplierId();
        String name = supplierView.requestInfo(Constants.ASK_FOR_SUPPLIER_NAME);

        Supplier supplier = new Supplier(id, name);
        supplierView.printBorderedMessage(Constants.SUPPLIER_REGISTERED_SUCCESSFULLY);
        return supplier;
    }
    private int validateCustomerDoc() {
        boolean flag = true;
        int customerDoc = 0;
        do {
            try {
                String input = customerView.requestInfo(Constants.ASK_FOR_CUSTOMER_DOC);
                customerDoc = Integer.parseInt(input);
                flag = false;
            } catch (NumberFormatException e) {
                customerView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return customerDoc;
    }

    private Customer createCustomer() {
        customerView.printBorderedMessage(Constants.REQUEST_CUSTOMER_INFO);
        customerView.printBorderedTitleMessage();
        int doc = validateCustomerDoc();
        String name = customerView.requestInfo(Constants.ASK_FOR_CUSTOMER_NAME);
        String phoneNumber = customerView.requestInfo(Constants.ASK_FOR_CUSTOMER_PHONE);

        Customer customer = new Customer(doc, name, phoneNumber);
        customerView.printBorderedMessage(Constants.CUSTOMER_REGISTERED_SUCCESSFULLY);
        return customer;
    }

    public Movement createMovementImport(String typeSelect){
        int movementId = validateMovementId();
        String type = typeSelect;
        LocalDate date = createDate();
        String originCountry = obtainOriginCountry();
        String destinationCountry = "Australia";
        Supplier supplier = createSupplier();
        Customer customer = createCustomer();

        Movement movement = new Movement(movementId, type, date, originCountry, destinationCountry, supplier, customer);
        movementView.printBorderedMessage(Constants.MOVEMENT_REGISTERED_SUCCESSFULLY);
        return movement;
    }

    public Movement createMovementExport(String typeSelect){
        int movementId = validateMovementId();
        String type = typeSelect;
        LocalDate date = createDate();
        String originCountry = "Australia";
        String destinationCountry = obtainDestinationCountry();
        Supplier supplier = createSupplier();
        Customer customer = createCustomer();

        Movement movement = new Movement(movementId, type, date, originCountry, destinationCountry, supplier, customer);
        movementView.printBorderedMessage(Constants.MOVEMENT_REGISTERED_SUCCESSFULLY);
        return movement;
    }
    private int validateMovementId() {
        boolean flag = true;
        int id = 0;
        do {
            try {
                String input = movementView.requestInfo(Constants.ASK_FOR_MOVEMENT_ID);
                id = Integer.parseInt(input);
                flag = false;
            } catch (NumberFormatException e) {
                itemView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return id;
    }

    private boolean validateDays(int day) {
        boolean isOutOfRange = false;
        if (!(day > 0 && day <= 31)) {
            movementView.printBorderedMessage(Constants.MOVEMENT_DAY_OUT_OF_RANGE);
            isOutOfRange = true;
        }
        return isOutOfRange;
    }

    private int validateMovementDay() {
        boolean flag = true;
        int day = 0;
        do {
            try {
                String input = movementView.requestInfo(Constants.ASK_FOR_MOVEMENT_DATE_DAY);
                day = Integer.parseInt(input);
                flag = false;
                while (validateDays(day)) {
                    input = movementView.requestInfo(Constants.ASK_FOR_MOVEMENT_DATE_DAY);
                    day = Integer.parseInt(input);
                }
            } catch (NumberFormatException e) {
                movementView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return day;
    }

    private boolean validateMonths(int month) {
        boolean isOutOfRange = false;
        if (!(month > 0 && month <= 12)) {
            movementView.printBorderedMessage(Constants.MOVEMENT_MONTH_OUT_OF_RANGE);
            isOutOfRange = true;
        }
        return isOutOfRange;
    }

    private int validateMovementMonth() {
        boolean flag = true;
        int month = 0;
        do {
            try {
                String input = movementView.requestInfo(Constants.ASK_FOR_MOVEMENT_DATE_MONTH);
                month = Integer.parseInt(input);
                flag = false;
                while (validateMonths(month)) {
                    input = movementView.requestInfo(Constants.ASK_FOR_MOVEMENT_DATE_MONTH);
                    month = Integer.parseInt(input);
                }
            } catch (NumberFormatException e) {
                movementView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return month;
    }

    private boolean validateYears(int year) {
        boolean isOutOfRange = false;
        if (!(year > 1900)) {
            movementView.printBorderedMessage(Constants.MOVEMENT_YEAR_OUT_OF_RANGE);
            isOutOfRange = true;
        }
        return isOutOfRange;
    }

    private int validateMovementYear() {
        boolean flag = true;
        int year = 0;
        do {
            try {
                String input = movementView.requestInfo(Constants.ASK_FOR_MOVEMENT_DATE_YEAR);
                year = Integer.parseInt(input);
                flag = false;
                while (validateYears(year)) {
                    input = movementView.requestInfo(Constants.ASK_FOR_MOVEMENT_DATE_YEAR);
                    year = Integer.parseInt(input);
                }
            } catch (NumberFormatException e) {
                movementView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return year;
    }

    private LocalDate createDate() {
        movementView.printBorderedMessage(Constants.REQUEST_DATE_INFO);
        int day = validateMovementDay();
        int month = validateMovementMonth();
        int year = validateMovementYear();

        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }
    
    public String obtainOriginCountry() {
        String originCountry = "";
        boolean flag = true;
        do {
            try {
                String input = movementView.showOriginCountryMenu();
                int decision = Integer.parseInt(input);
                flag = false;
                switch (decision) {
                    case 1:
                        originCountry = "Germany";
                        break;
                    case 2:
                        originCountry = "Sweden";
                        break;
                    case 3:
                        originCountry = "Japan";
                        break;
                    case 4:
                        originCountry = "Brazil";
                        break;
                    case 5:
                        originCountry = "Iceland";
                        break;
                    default:
                        movementView.printBorderedMessage(Constants.INVALID_OPTION_MESSAGE);
                        obtainOriginCountry();
                }
            } catch (NumberFormatException e) {
                movementView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);

        return originCountry;
    }

    private void createImport(String type) {
        Item item;
        Movement movement = this.createMovementImport(type);
        int itemQuantity = validateItemQuantity(); 
        for (int i = 0; i < itemQuantity; i++) {
            item = this.createItem();
            movement.addItem(item);
        }
        customSystem.registerMovement(movement);
    }

    private void createExport(String type) {
        Item item;
        Movement movement = this.createMovementExport(type);
        int itemQuantity = validateItemQuantity(); 
        for (int i = 0; i < itemQuantity; i++) {
            item = this.createItem();
            movement.addItem(item);
        }
        customSystem.registerMovement(movement);
    }
    
    public String obtainDestinationCountry() {
        String destinationCountry = "";
        boolean flag = true;
        do {
            try {
                String input = movementView.showDestinationCountryMenu();
                int decision = Integer.parseInt(input);
                flag = false;
                switch (decision) {
                    case 1:
                        destinationCountry = "Germany";
                        break;
                    case 2:
                        destinationCountry = "Sweden";
                        break;
                    case 3:
                        destinationCountry = "Japan";
                        break;
                    case 4:
                        destinationCountry = "Brazil";
                        break;
                    case 5:
                        destinationCountry = "Iceland";
                        break;
                    default:
                        movementView.printBorderedMessage(Constants.INVALID_OPTION_MESSAGE);
                        obtainOriginCountry();
                }
            } catch (NumberFormatException e) {
                movementView.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            }
        } while (flag);
        
        return destinationCountry;
    }
    
    private LocalDate createDateForFilter() {
        menus.printBorderedTitle(Constants.FILTER_BY_DATE);
        movementView.printBorderedMessage(Constants.REQUEST_DATE_INFO);
        int day = validateMovementDay();
        int month = validateMovementMonth();
        int year = validateMovementYear();

        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

    private void firstDecision() throws IOException {
        boolean flag = true;
        do {
            try {
                String input = menus.showFirstMenu();
                int decision = Integer.parseInt(input);
                flag = false;
                switch (decision) {
                    case 1:
                        movementView.printBorderedTitleMessage();
                        this.createImport("Import");
                        this.firstDecision();
                        break;
                    case 2:
                        movementView.printBorderedTitleMessage();
                        this.createExport("Export");
                        this.firstDecision();
                        break;
                    case 3:
                        this.secondDecision();
                        break;
                    case 4:
                        menus.printBorderedMessage(Constants.GOOD_BYE_MESSAGE);
                        customSystem.createMovementsFiles(Constants.OBJECT_INFO_PATH);
                        System.exit(0);
                        break;
                    default:
                        menus.printBorderedMessage(Constants.INVALID_OPTION_MESSAGE);
                        firstDecision();
                }
            } catch (NumberFormatException e) {
                menus.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            } 
        } while (flag);
    }

    private void secondDecision() throws IOException {
        boolean flag = true;
        do {
            try {
                String input = menus.showSecondMenu();
                int decision = Integer.parseInt(input);
                flag = false;
                switch (decision) {
                    case 1:
                        menus.printMessage(customSystem.filterByDate(createDateForFilter()));
                        thirdDecision();
                        break;
                    case 2:
                        menus.printBorderedMessage(Constants.FILTER_BY_IMPORTS);
                        menus.printMessage(customSystem.filterByImports());
                        thirdDecision();
                        break;
                    case 3:
                        menus.printBorderedMessage(Constants.FILTER_BY_EXPORTS);
                        menus.printMessage(customSystem.filterByExports());
                        thirdDecision();
                        break;
                    case 4:
                        menus.printBorderedMessage(Constants.FILTER_BY_IDENTIFIER);
                        String inputMovId = movementView.requestInfo(Constants.FILTER_MOVEMENT_BY_ID);
                        int movId = Integer.parseInt(inputMovId);
                        menus.printMessage(customSystem.filterByIdentification(movId));
                        thirdDecision();
                        break;
                    case 5:
                        menus.printBorderedMessage(Constants.MOVEMENTS_HISTORY);
                        menus.printMessage(customSystem.showMovementsHistory());
                        thirdDecision();
                        break;
                    case 6:
                        menus.printBorderedMessage(Constants.MOVEMENT_INFO);
                        String inputId = movementView.requestInfo(Constants.FILTER_INFO_BY_MOVEMENT_ID);
                        int idMov = Integer.parseInt(inputId);
                        menus.printMessage(customSystem.showMovementInfoById(idMov));
                        thirdDecision();
                        break;
                    case 7:
                        menus.printBorderedMessage(Constants.FILE_CREATED);
                        customSystem.createMovementsFiles(Constants.OBJECT_INFO_PATH);
                        menus.printBorderedMessage("File created successfully!");
                        thirdDecision();
                        break;
                    case 8:
                        firstDecision();
                        break;
                    case 9:
                        menus.printBorderedMessage(Constants.GOOD_BYE_MESSAGE);
                        customSystem.createMovementsFiles(Constants.OBJECT_INFO_PATH);
                        System.exit(0);
                        break;
                    default:
                        menus.printBorderedMessage(Constants.INVALID_OPTION_MESSAGE);
                        secondDecision();
                }
            } catch (NumberFormatException e) {
                menus.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            } 
        } while (flag);
    }

    private void thirdDecision() throws IOException {
        boolean flag = true;
        do {
            try {
                String input = menus.showThirdMenu();
                int decision = Integer.parseInt(input);
                flag = false;
                switch (decision) {
                    case 1:
                        secondDecision();
                        break;
                    case 2:
                        menus.printBorderedMessage(Constants.GOOD_BYE_MESSAGE);
                        customSystem.createMovementsFiles(Constants.OBJECT_INFO_PATH);
                        System.exit(0);
                        break;
                    default:
                        menus.printBorderedMessage(Constants.INVALID_OPTION_MESSAGE);
                        thirdDecision();
                }
            } catch (NumberFormatException e) {
                menus.printBorderedMessage(Constants.DISPLAY_INPUT_TYPE_ERROR);
                flag = true;
            } 
        } while (flag);
    }
    
    private void run() throws IOException {
        menus.printBorderedTitleMessage();
        if(this.validateAgentLogin()) {
            firstDecision();
        }
    }

    public static void main(String[] args) throws IOException {
        Presenter presenter = new Presenter();
        presenter.run();
    }
}