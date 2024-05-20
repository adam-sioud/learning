package of6.lf;

import java.util.ArrayList;
import java.util.Collection;

public class App {

    Collection<AppListener> subscribes = new ArrayList<>();

    public void subscribe(AppListener listener){
        if(!this.subscribes.contains(listener)){
            this.subscribes.add(listener);
        }
    }

    public void unsubscribe(AppListener listener){
        if(this.subscribes.contains(listener)){
            this.subscribes.remove(listener);
        }
    }

    public void firePushNotification(String notification){
        this.subscribes.forEach(listener -> listener.recivePushNotification(notification));
    }
    

    
}

