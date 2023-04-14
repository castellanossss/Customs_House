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
}