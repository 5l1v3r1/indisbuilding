package Java.Logic;

import Java.GUI.Display;
import Java.GUI.Keypad;
import javax.swing.JLabel;

public interface MethodInfc {
    public void Set_Port(int port);
    public void Access_ByCard(Display frame, Model model);
    public void Access_ByPIN(Keypad frame, Model model);
    public void Register_UID(Keypad frame, Model model);
    public void Update_ListUID(Model model);
    public void Clock(JLabel dateLbl);
    public String Get_DateTime();
    public void Direct_ToDisplay(Keypad frame, int flag);
    public void Direct_ToKeypad(Display frame);
    public void AutoDirect_ToDisplay(Keypad frame);
    public void Update_Absensi();
    public void Relay_ByPin(Display frame, Relay relay);
    public void CreateResources(Model model);
    public String getMacAddress();
    public void Process_UpdateUID(Model model);
    public void Write_Auth(String auth);
    public void Get_Auth();
}
