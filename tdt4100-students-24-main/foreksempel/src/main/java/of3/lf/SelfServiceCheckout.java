package of3.lf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelfServiceCheckout {

    private static final List<String> DAYS = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,10}$";
    private static final double WEEKEND_TACO_DISCOUNT = 0.3;

    private String day;
    private String phoneNumber;
    private boolean adminMode;
    private String password;
    private List<Item> shoppingCart;

    public SelfServiceCheckout(String day, String phoneNumber, String password) {
        this.validateDay(day);
        this.day = day;

        if (!this.validatePhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Not a valid phone number");
        }

        if (!validatePassword(password)) {
            throw new IllegalArgumentException("Not a valid password");
        }

        this.phoneNumber = phoneNumber;
        this.password = password;
        this.adminMode = false;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean isMember() {
        return this.phoneNumber != null;
    }

    public void enableAdminMode(String password) {
        if (this.adminMode) {
            throw new IllegalStateException("Admin mode is already enabled!");
        }

        if (!this.password.equals(password)) {
            throw new IllegalArgumentException("Wrong password!");
        }

        this.adminMode = true;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!this.validatePhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Not a valid phone number");
        }

        this.phoneNumber = phoneNumber;
    }

    public void scanItem(Item item) {
        this.shoppingCart.add(item);
        System.out.println(item.getName() + ": " + item.getPrice() + " kr");
    }

    public void scanItems(Iterable<Item> list) {
        for (Item item : list) {
            this.scanItem(item);
        }
    }

    public void removeFromCart(int index) {
        if (!this.adminMode) {
            throw new IllegalStateException("This operation requires admin mode!");
        }

        this.shoppingCart.remove(index);
    }

    public double getDiscountForItem(Item item) {
        if (!item.getCategory().equals("taco")) {
            return 0.0;
        }

        if (!this.day.equals("fri") && !this.day.equals("sat")) {
            return 0.0;
        }

        return item.getPrice() * WEEKEND_TACO_DISCOUNT;
    }

    // Interne valideringsmetoder

    private static boolean validatePassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return true;
        }

        String cleanPhoneNumber = phoneNumber.replaceAll("\\s", "");

        if (cleanPhoneNumber.startsWith("0047")) {
            if (!(cleanPhoneNumber.startsWith("00479") || cleanPhoneNumber.startsWith("00474"))) {
                return false;
            }

            if (cleanPhoneNumber.length() != 12) {
                return false;
            }
        } else if (cleanPhoneNumber.startsWith("+47")) {
            if (!(cleanPhoneNumber.startsWith("+479") || cleanPhoneNumber.startsWith("+474"))) {
                return false;
            }

            if (cleanPhoneNumber.length() != 11) {
                return false;
            }
        } else {
            return false;
        }

        String subCleanPhoneNumber = cleanPhoneNumber.substring(cleanPhoneNumber.length() - 8);

        char[] chars = subCleanPhoneNumber.toCharArray();

        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private void validateDay(String day) {
        if (!DAYS.contains(day)) {
            throw new IllegalArgumentException("Not a valid day");
        }
    }

    public static void main(String[] args) {
        SelfServiceCheckout s1 = new SelfServiceCheckout("mon", "+47 41009110", "pass123");
        System.out.println(s1.isMember());

        Item item1 = new Item("Tortilla", 40, "taco");
        Item item2 = new Item("Melk", 30, "meieri");
        Item item3 = new Item("Smør", 30, "meieri");

        s1.scanItem(item1);
        s1.scanItems(Arrays.asList(item1, item2, item3));

        System.out.println(s1.shoppingCart.size());

        s1.enableAdminMode("pass123");
        s1.removeFromCart(1);

        System.out.println(s1.shoppingCart.size());
    }
}
