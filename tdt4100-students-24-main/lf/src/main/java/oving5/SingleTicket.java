package oving5;

public class SingleTicket implements Ticket {

    private boolean scanned;

    public SingleTicket() {
        this.scanned = false;
    }

    @Override
    public boolean scan() {
        if (this.scanned) {
            return false;
        }
     
        this.scanned = true;
        return true;
    }
}
