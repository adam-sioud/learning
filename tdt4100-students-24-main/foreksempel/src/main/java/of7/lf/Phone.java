package of7.lf;

import java.util.ArrayList;
import java.util.Collection;

public class Phone implements PushNotificationListener {

    Collection<String> notifications = new ArrayList<>();
    Collection<PushNotificationSender> apps = new ArrayList<>();

    @Override
    public void pushNotification(String notification) {
        this.notifications.add(notification);
        System.out.println(notification);
    }

    public void subscribe(PushNotificationSender app){
        if(!this.apps.contains(app)){
            this.apps.add(app);
            app.subscribe(this);
        }
    }
    
    public void unsubscribe(PushNotificationSender app){
        if(this.apps.contains(app)){
            this.apps.remove(app);
            app.unsubscribe(this);
        }
    }



    
}
