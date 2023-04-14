package presenter;

public class Constants {
    public static final String GOOD_BYE_MESSAGE = "Thank you for using our system!";
    public static final String INVALID_OPTION_MESSAGE = "Not a valid option. Please try again.";
    public static final String DISPLAY_INPUT_TYPE_ERROR = "Error: Only numbers are allowed! Please try again.";

    //Movement info
    public static final String ASK_FOR_MOVEMENT_ID = "Enter the movement ID: ";
    public static final String ASK_FOR_MOVEMENT_ITEM_ID = "Enter the item ID: ";
    public static final String ASK_FOR_MOVEMENT_DATE_DAY = "Enter the day of the date: ";
    public static final String ASK_FOR_MOVEMENT_DATE_MONTH = "Enter the month of the date: ";
    public static final String ASK_FOR_MOVEMENT_DATE_YEAR = "Enter the year of the date: ";

    //Movement Different Messages
    public static final String REQUEST_DATE_INFO = "TO ENTER THE DATE, WE WILL ASK FOR THE DAY, MONTH AND YEAR.";
    public static final String MOVEMENT_REGISTERED_SUCCESSFULLY = "Registered Successfully!";
    public static final String MOVEMENT_DAY_OUT_OF_RANGE = "The day must be between 1 and 31. Please try again.";
    public static final String MOVEMENT_MONTH_OUT_OF_RANGE = "The month must be between 1 and 12. Please try again.";
    public static final String MOVEMENT_YEAR_OUT_OF_RANGE = "The year must be superior to 1900. Please try again.";

    //Item info
    public static final String ASK_FOR_ITEM_ID = "Enter the item ID: ";
    public static final String ASK_FOR_ITEM_NAME = "Enter the item name: ";
    public static final String ASK_FOR_ITEM_WEIGHT = "Enter the item weight: ";
    public static final String ASK_FOR_ITEM_PRICE = "Enter the item price: ";
    public static final String ASK_FOR_ITEM_QUANTITY = "Enter items to register: ";

    //Item Different Messages
    public static final String ITEM_REGISTERED_SUCCESSFULLY = "Item Registered Successfully!";

    //Customer info
    public static final String ASK_FOR_CUSTOMER_DOC = "Enter the customer document: ";
    public static final String ASK_FOR_CUSTOMER_NAME = "Enter the customer name: ";
    public static final String ASK_FOR_CUSTOMER_PHONE = "Enter the customer phone number: ";

    //Customer Different Messages
    public static final String REQUEST_CUSTOMER_INFO = "TO REGISTER A CUSTOMER, WE WILL ASK FOR THE DOCUMENT, NAME AND PHONE NUMBER.";
    public static final String CUSTOMER_REGISTERED_SUCCESSFULLY = "Customer Registered Successfully!";

    //Supplier info
    public static final String ASK_FOR_SUPPLIER_ID = "Enter the supplier ID: ";
    public static final String ASK_FOR_SUPPLIER_NAME = "Enter the supplier name: ";

    //Supplier Different Messages
    public static final String REQUEST_SUPPLIER_INFO = "TO REGISTER A SUPPLIER, WE WILL ASK FOR THE ID AND NAME.";
    public static final String SUPPLIER_REGISTERED_SUCCESSFULLY = "Supplier Registered Successfully!";

    //Customs Agent info
    public static final String ASK_FOR_AGENT_USER = "Enter the agent username: ";
    public static final String ASK_FOR_AGENT_PASSWORD = "Enter the agent password: ";

    //Customs Agent Different Messages
    public static final String SUCCESFUL_AGENT_LOGIN = "Login Successful, Welcome!";
    public static final String UNSUCCESFUL_AGENT_LOGIN = "Login Unsuccessful, Please try again.";

    //Paths
    public static final String LOGIN_INFO_PATH = "data/loginInfo.txt";
    public static final String OBJECT_INFO_PATH = "data/";

    //Filters Messages Titles
    public static final String FILTER_BY_DATE = "Filter by date";
    public static final String FILTER_BY_IMPORTS = "Filter by imports";
    public static final String FILTER_BY_EXPORTS = "Filter by exports";
    public static final String FILTER_BY_IDENTIFIER = "Filter by identifier";
    public static final String MOVEMENTS_HISTORY = "Movements History";
    public static final String MOVEMENT_INFO = "Movement Info";
    
    //Filters Messages
    public static final String FILTER_INFO_BY_MOVEMENT_ID = "Enter the movement ID to show the info: ";
    public static final String FILTER_MOVEMENT_BY_ID = "Enter the movement ID to filter: ";
    public static final String FILE_CREATED = "File created succesfully!";
}
