package of7.lf;

import java.util.ArrayList;
import java.util.Collection;

public class PushNotificationSender {

    Collection<PushNotificationListener> subscribers = new ArrayList<>();

    public void subscribe(PushNotificationListener listener){
        if(!this.subscribers.contains(listener)){
            this.subscribers.add(listener);
        }

    }

    public void unsubscribe(PushNotificationListener listener){
        if(this.subscribers.contains(listener)){
            this.subscribers.remove(listener);
        }
    }


    public void firePushNotification(String notification){
        this.subscribers.stream()
                        .forEach(s -> s.pushNotification(notification));
                        
    }
    
}
