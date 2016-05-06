package Java.Logic;

import java.util.ArrayList;
import java.util.List;

public class Model {
    
    //List collect data di txt 
    public List<String> listUID = new ArrayList<>();
    public List<String> update = new ArrayList<>();
    public List<String> uidDb = new ArrayList<>();
    public List<String> uidTxt = new ArrayList<>();
    public List<String> statusDb = new ArrayList<>();
    public List<String> uidTemp = new ArrayList<>();
    public List<String> timerTemp = new ArrayList<>();
    
    private String UID;
    private String UpdateUID;
    private String UpdateDate;
    private String UpdateTime;
    private String UpdateStatus;

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUpdateUID() {
        return UpdateUID;
    }

    public void setUpdateUID(String UpdateUID) {
        this.UpdateUID = UpdateUID;
    }

    public String getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(String UpdateDate) {
        this.UpdateDate = UpdateDate;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public String getUpdateStatus() {
        return UpdateStatus;
    }

    public void setUpdateStatus(String UpdateStatus) {
        this.UpdateStatus = UpdateStatus;
    }

}
