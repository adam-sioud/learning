package of6.lf;

import java.util.ArrayList;
import java.util.Collection;

public class Phone implements AppListener {

    Collection<String> notifications = new ArrayList<>();
    Collection<App> subscribing = new ArrayList<>();

    @Override
    public void recivePushNotification(String notification) {
        this.notifications.add(notification);
        System.out.println(notification);
    }

    public void addApp(App app){
        if(!this.subscribing.contains(app)){
            this.subscribing.add(app);
            app.subscribe(this);
        }
    }

    public void removeApp(App app){
        if(this.subscribing.contains(app)){
            this.subscribing.remove(app);
            app.unsubscribe(this);
        }
    }






    
}
