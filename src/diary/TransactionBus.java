package diary;

/*
    Класс, который принимает все запросы и направляет их в соответствующие сервисы
*/

import java.util.Date;
import com.alibaba.fastjson.*;

class TransactionBus {
    private Date startTime;
    private String messageType;


    TransactionBus() {
        this.startTime = new Date();
    }

    Date getStartTime() {
        return startTime;
    }

    void send(String[] args){
       // case
    }

}
