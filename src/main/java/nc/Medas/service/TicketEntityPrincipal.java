package nc.Medas.service;

import nc.Medas.model.Screen;
import nc.Medas.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TicketEntityPrincipal {
//require
    private long userId;
    private int screenId;
    private int chair;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public int getChair() {
        return chair;
    }

    public void setChair(int chair) {
        this.chair = chair;
    }
}
