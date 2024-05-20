package of7.lf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class App extends PushNotificationSender{

    private int lastNotificationSent = 0;

    @Override
    public void firePushNotification(String notification){
       if(lastNotificationSent == (int) LocalDate.now().toEpochDay()){
        throw new IllegalArgumentException("Daily notification already sent");
       } 

       super.firePushNotification(notification);
       lastNotificationSent = (int) LocalDate.now().toEpochDay();

    }
    
}
