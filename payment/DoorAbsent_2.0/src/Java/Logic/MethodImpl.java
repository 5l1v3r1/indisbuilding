package Java.Logic;

import Java.GUI.Display;
import Java.GUI.Keypad;
import Java.GUI.Menu;
import static com.mufasa.Platform.connect;
import static com.mufasa.Platform.getUid;
import static com.mufasa.Platform.terminal;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.smartcardio.CardException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MethodImpl implements MethodInfc{
     
    Timer TIMER_1 = new Timer();
    Timer TIMER_2 = new Timer();
    Timer TIMER_3 = new Timer();
    private final String USER_AGENT = "";
    private String URL_1=null;
    private String URL_2=null;
    private final String MAC_ADDRESS = "9C-B7-0D-4C-83-B3";//getMacAddress();
    private final String PIN_1 = "12345";
    private final String PIN_2 = "67890";
    private int FLAG_1 = 0;
    private int FLAG_2 = 0;

    /*
     *AKSES DENGAN KARTU
    */
    @Override
    public void Set_Port(int port) {
        connect(port);
    }
    @Override
    public void Access_ByCard(Display frame, Model model) {
        Relay relay = new Relay();
        TIMER_1.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    if(terminal.isCardPresent()){
                        FLAG_2=0;
                        Get_ListUID(model);
                        model.setUID(getUid()); 
                        for(String listUID : model.listUID) {
                            if(listUID.matches(model.getUID())){
                                FLAG_2=1;
                                Check_Status(frame, model);
                                if(FLAG_1==0){
                                    FLAG_1=1;
                                }
                                Relay_ByCard(frame, relay);
                                Update_Absensi();
                                break;
                            }
                        }
                        if(FLAG_2==0){
                            if(FLAG_1==0){
                                FLAG_1=1;
                                Write_History(model, "Akses Ditolak");
                            }
                            frame.headerText.setText("Akses Ditolak");
                        }
                    }
                    else{
                        OnLockDisplay(frame);
                    }
                } catch (CardException ex) {
                    ex.getStackTrace();
                }
            }
        }, 500L, 500L);
    }
    private void Get_ListUID(Model model) {
        try{
            model.listUID.clear();
            File file = new File("resources/listUID.txt");
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader readText = new BufferedReader(fileReader);
            String uid;
            while((uid = readText.readLine()) != null){
                model.listUID.add(uid);
            }
            //==================================================================
            Get_TempUID(model);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy - HH:mm:ss");
            Date date = new Date();
            for(int x=0; x<model.uidTemp.size();){
                if(dateFormat.parse(dateFormat.format(date))
                        .before(dateFormat.parse(model.timerTemp.get(x)))){
                    model.listUID.add(model.uidTemp.get(x));
                }
                x++;
            }
            readText.close();
            fileReader.close();
        }catch(IOException | ParseException ex){  
            ex.printStackTrace();
        }
    }
    
    /*
     *REG UID DENGAN PIN
    */
    @Override
    public void Access_ByPIN(Keypad frame, Model model){
        String PIN = frame.PIN().trim();
        if(PIN.equalsIgnoreCase(PIN_1)){
            Direct_ToDisplay(frame, 1);
        }
        else{
            frame.list.clear();
            frame.simbol.clear();
            frame.pinText.setText("_________");
        }
    }
    @Override
    public void Register_UID(Keypad frame, Model model){
        Relay relay = new Relay();
        TIMER_2.schedule(new TimerTask() {
            @Override
            public void run() {  
                FLAG_2=0;
                try {  
                    String UID = frame.PIN();
                    if(UID.equalsIgnoreCase(PIN_2)){
                        frame.pinText.setText("Silahkan Tempelkan Kartu");
                        frame.pinText.setFont(new java.awt.Font("Tahoma", 0, 30));
                    }
                    if(terminal.isCardPresent()){
                        if(UID.equalsIgnoreCase(PIN_2)){
                            model.setUID(getUid());
                            Process_RegisterUID(frame, model);
                        }
                        else {
                            frame.pinText.setText("_________");
                            frame.pinText.setFont(new java.awt.Font("Tahoma", 0, 72));
                        }
                    }
                    else{
                        if(frame.PIN().isEmpty()){
                            frame.pinText.setText("_________");
                            frame.pinText.setFont(new java.awt.Font("Tahoma", 0, 72));
                        }
                    }
                } catch (Exception ex) { 
                    ex.printStackTrace();
                }
            }
        }, 500L, 500L);
    }
    private void Process_RegisterUID(Keypad frame, Model model){
        try{
            Get_TempUID(model);
            String UID = model.getUID();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy - HH:mm:ss");
            Date date = new Date();

            int flag=0;
            for(int x=0; x<model.uidTemp.size();){
                if(model.uidTemp.get(x).matches(UID)){
                    try {
                        if(dateFormat.parse(dateFormat.format(date))
                                .before(dateFormat.parse(model.timerTemp.get(x)))){
                            flag=1;
                            break;
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                }
                x++;
            }
            
            if(flag==0){
                String tempUID = UID+" = "+dateFormat.format(date.getTime()+7200000);
                Write_TempUID(model, tempUID);
                frame.pinText.setText("Kartu Telah Terdaftar");
                frame.pinText.setFont(new java.awt.Font("Tahoma", 0, 30));
                Thread.sleep(3000L);
                frame.list.clear();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void Get_TempUID(Model model){
        try {
            File file = new File("resources/tempUID.txt");
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader readText = new BufferedReader(fileReader);
            String[] data;
            String uid;
            while((uid = readText.readLine()) != null){
                data = uid.split(" = ");
                model.uidTemp.add(data[0]);
                model.timerTemp.add(data[1]);
            }
            readText.close();
            fileReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void Write_TempUID(Model model, String tempUID){
        try {
            File file = new File("resources/tempUID.txt");
            String fileFos = String.valueOf(file.getAbsolutePath()).replaceAll("\\\\", "//");
            FileWriter wr = new FileWriter(fileFos, true);
            CharSequence form = tempUID.trim() + "\n";
            wr.append(form);
            wr.flush();
            wr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /*
     *GET UID LIST
    */
    @Override
    public void Update_ListUID(Model model){
        try{
            ServerSocket listener = new ServerSocket(443);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if(listener.isBound()){
                        try {
                            SocketTriger socket = new SocketTriger(listener);
                            socket.run();
                            if(socket.readTriger().matches("1")){
                                if(CheckConn_1(URL_1) == true){
                                   Process_UpdateUID(model);
                                   socket.writeTriger("0");
                                }  
                                else if(CheckConn_1(URL_1) == false){
                                    System.out.println("get uid gagal : koneksi terputus");
                                }
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } 
                    else if(!listener.isBound()){
                        System.out.println("koneksi trputus");
                    }
                }
            },1000L, 1000L); 
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void Process_UpdateUID(Model model){
        try{ 
            Get_UidDb(model);
            Get_UidTxt(model);
            int sizeDb = model.uidDb.size();
            int sizeTxt = model.uidTxt.size();  
                if(sizeDb != sizeTxt){
                    for(int x=0; x<model.statusDb.size(); x++){
                        model.update.add(model.uidDb.get(x));
                    }
                    Write_ListUID(model);
                }  
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void Get_UidDb(Model model){
        try {
            model.uidDb.clear();
            model.statusDb.clear();
            URL server = new URL(URL_1+"?mac="+URLEncoder.encode(MAC_ADDRESS, "UTF-8"));
            HttpURLConnection connect = (HttpURLConnection) server.openConnection();
            connect.setRequestMethod("GET");
            connect.setRequestProperty("User-Agent", USER_AGENT);
            connect.connect();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connect.getInputStream()));
            String inputLine;
            StringBuffer Respone = new StringBuffer();
            int y = 0;
            while ((inputLine = in.readLine()) != null) {
                y++;
                if(y>5){
                    Respone.append(inputLine);
                }
            }
            
            String check = String.valueOf(Respone);
            if(!check.isEmpty()){
                String Result = String.valueOf(Respone.toString());
                JSONObject json = new JSONObject(Result);
                JSONArray jsonArray = json.getJSONArray("configs");
                for(int x=0; x<jsonArray.length(); x++){
                    JSONObject values = jsonArray.getJSONObject(x);
                    if(values.getString("status").matches("1")){
                        model.uidDb.add(values.getString("cardkey"));
                        model.statusDb.add(values.getString("status"));
                    }
                } 
                in.close();
                System.out.println("autentikasi berhasil");
                connect.disconnect();
            }
        } catch (Exception ex) {
            System.out.println("koneksi terputus");
            Menu frame = new Menu(MAC_ADDRESS);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(Menu.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
        } 
    }
    private void Get_UidTxt(Model model){
        try{
            model.uidTxt.clear();
            File file = new File("resources/listUID.txt");
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader readText = new BufferedReader(fileReader);
            String uid;
            while((uid = readText.readLine()) != null){
                model.uidTxt.add(uid);
            }
            readText.close();
            fileReader.close();
        }catch(IOException ex){  
            ex.printStackTrace();
        }
    }
    private void Write_ListUID(Model model) {
        try {
            File file = new File("resources/listUID.txt");
            String fileFos = String.valueOf(file.getAbsolutePath()).replaceAll("\\\\", "//");
            OutputStream fos = new FileOutputStream(fileFos);
            try (Writer osw = new OutputStreamWriter(fos)) {
                for(String x : model.update){
                    CharSequence from = x.trim() + "\n";
                    osw.append(from);
                    System.out.println("get uid : "+x);
                }
                osw.flush();
                osw.close();
                model.update.clear();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public String getMacAddress(){
        StringBuilder sb = new StringBuilder();
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i<mac.length-1) ? "-" : ""));
            }
        } catch (UnknownHostException | SocketException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }
    private boolean CheckConn_1(String url){  
        boolean status;
        try {                                                                                                                                                                                                                                 
            URL server = new URL(url);
            HttpURLConnection connect = (HttpURLConnection) server.openConnection(); 
            connect.connect();
            status = true;                                                                                                                                                                                                                      
        }catch (Exception ex) {                                                                                                                                                                                                   
            status = false;                                                                                                                                                                                              
        }
        return status;
    }
    
    /*
     *CATATAN DAN HISTORI
    */
    private void Check_Status(Display frame, Model model){
        try {
            File file = new File("resources/log.csv");
            CSVReader reader = new CSVReader(new FileReader(file.getAbsolutePath()), ',');
            List<String[]> csvBody = reader.readAll();
            int flag=0;
            for(int x=0; x<csvBody.size(); x++){
                if(csvBody.get(x)[0].matches(model.getUID()) 
                        && csvBody.get(x)[1].matches(Process_Date())){
                    flag++;
                    if(csvBody.get(x)[3].matches("Check-In")){
                        Write_History(model, "Akses Diterima");
                        frame.headerText.setText("Akses Diterima");
                    }
                    break;
                }  
            }
            if(flag==0){
                Write_Log(model, file, "Check-In");
                Write_History(model, "Check-In");
                frame.headerText.setText("Check-In");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void Write_Log(Model model, File logCsv, String status){
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(logCsv.getAbsolutePath(), true), ',');
                String[] csvBody = new String[5];
                csvBody[0] = model.getUID();
                csvBody[1] = Process_Date();
                csvBody[2] = Process_Time();
                csvBody[3] = status;    
                csvBody[4] = "-";
                writer.writeNext(csvBody);
                writer.flush();
                writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
    private String Process_Date(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
        Date date = new Date();
        return (dateFormat.format(date));
    }
    private String Process_Time(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return (dateFormat.format(date));
    }
    private void Write_History(Model model, String status){
        try {
            String history = model.getUID()+","+Process_Date()+"-"+Process_Time()+","+status ;
            File file = new File("resources/history.txt");
            String fileFos = String.valueOf(file.getAbsolutePath()).replaceAll("\\\\", "//");
            FileWriter wr = new FileWriter(fileFos, true);
                CharSequence from = history + "\n";    
                wr.append(from);
                wr.flush();
                wr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /*
     *TANGGAL DAN WAKTU
    */
    @Override
    public void Clock(JLabel dateLbl){
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                Date date = new Date();
                dateLbl.setText(Get_DateTime());
            }   
        },1000L, 1000L);
    }
    @Override
    public String Get_DateTime(){
        String dateTime = Process_Date()+" - "+Process_Time();
        return dateTime;
    }
    
    /*
     *DIRECT FRAME
    */
    @Override
    public void Direct_ToDisplay(Keypad frame, int flag){
        try{
            TIMER_2.cancel();
            TIMER_3.cancel();
            frame.frame = new Display(flag);
            frame.frame.setVisible(true);
            frame.frame.setDefaultCloseOperation(Display.DISPOSE_ON_CLOSE);
            frame.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.dispose();
        }catch(Exception ex){
            ex.printStackTrace();
        } 
    }
    @Override
    public void Direct_ToKeypad(Display frame){
        try{
            TIMER_1.cancel();
            Keypad keypad = new Keypad(frame);
            keypad.setVisible(true);
            keypad.setDefaultCloseOperation(Keypad.DISPOSE_ON_CLOSE);
            keypad.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.dispose();
        }catch(Exception ex){
            ex.printStackTrace();
        }  
    }
    @Override
    public void AutoDirect_ToDisplay(Keypad frame){
        TIMER_3.schedule(new TimerTask(){
            @Override
            public void run() {
                if(frame.pinText.getText().matches("_________")){
                    Direct_ToDisplay(frame, 0);
                    TIMER_3.cancel();
                }
            }
        },10000L ,10000L);
    }

    /*
     *ABSENSI
    */
    @Override
    public void Update_Absensi(){        
        try {
            if(CheckConn_2(URL_2) == true){
                Process_UpdateAbsensi();
            }
            else{
                Timer timer =  new Timer();
                timer.schedule(new TimerTask(){
                    @Override
                    public void run() {
                        if(CheckConn_2(URL_2) == true){
                            Process_UpdateAbsensi();
                            timer.cancel();
                        }
                        else{
                            System.out.println("menunggu sambungan...");
                        }
                    } 
                },5000L, 5000L);
                }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void Process_UpdateAbsensi(){
        try {
            File file = new File("resources/log.csv");
            CSVReader reader = new CSVReader(new FileReader(file.getAbsolutePath()), ',');
            List<String[]> csvBody = reader.readAll();
            for(int x=0; x<csvBody.size(); x++){
                JSONArray jsonArray = new JSONArray();
                if(csvBody.get(x)[4].matches("-")){
                    String JSONObject = JSONObject(jsonArray, csvBody, x);
                    URL url = new URL(URL_2+"?json="+JSONObject);
                    HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(httpUrl.getInputStream()));
                    String inputLine;
                    if ((inputLine = in.readLine()) != null) {
                        in.close();
                    }
                    updateCSV(file, x);
                    reader.close();
                    httpUrl.disconnect();
                    System.out.println("post absensi : "+csvBody.get(x)[0]+", "
                            + ""+csvBody.get(x)[1]+"-"+csvBody.get(x)[2]);
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private String JSONObject(JSONArray jsonArray, List<String[]> csvBody, int x){
        String JSONObject = null;
        try {
            JSONObject json = new JSONObject();
            json.put("uid", csvBody.get(x)[0]);
            json.put("date", csvBody.get(x)[1]);
            json.put("time", csvBody.get(x)[2]);
            json.put("status", csvBody.get(x)[3]);
            jsonArray.put(json);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Data", jsonArray);
            JSONObject = String.valueOf(jsonObject);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return JSONObject;
    }
    private void updateCSV(File logCsv, int row) {
        try {
            CSVReader reader = new CSVReader(new FileReader(logCsv.getAbsolutePath()), ',');
            List<String[]> csvBody = reader.readAll();
            csvBody.get(row)[4] = "post";
            reader.close();
            //------------------------------------------------------------------
            CSVWriter writer = new CSVWriter(new FileWriter(logCsv), ',');
            writer.writeAll(csvBody);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private boolean CheckConn_2(String url){  
        boolean status;
        try {                                                                                                                                                                                                                                
            URL server = new URL(url);
            HttpURLConnection connect = (HttpURLConnection) server.openConnection(); 
            connect.connect();
            status = true;
        }catch (Exception ex) {
            status = false;
        }
        return status;
    }
     
    /*
     *RELAY
    */
    private void Relay_ByCard(Display frame, Relay relay){
        frame.labelIconLock.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/Image/lock_off.png")));
        relay.activate(true);
        try{
            Thread.sleep(5000L);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        relay.activate(false);
    }
    @Override
    public void Relay_ByPin(Display frame, Relay relay){
        try{
            frame.labelIconLock.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/Image/lock_off.png")));
            relay.activate(true);
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                @Override
                public void run() {
                    relay.activate(false);
                    OnLockDisplay(frame);
                    Access_ByCard(frame, frame.model);
                    Update_ListUID(frame.model);
                    timer.cancel();
                }
            },5000L, 5000L);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void OnLockDisplay(Display frame){
        FLAG_1=0;
        frame.labelIconLock.setIcon(new javax.swing.ImageIcon(getClass()
                    .getResource("/Image/lock_on.png")));
        frame.headerText.setText("SCCIC");
    }
      
    @Override
    public void Write_Auth(String auth){
        try {
            File file = new File("resources/urlserver.txt");
            String fileFos = String.valueOf(file.getAbsolutePath()).replaceAll("\\\\", "//");
            FileWriter wr = new FileWriter(fileFos, false);
            wr.append(auth);
            wr.flush();
            wr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void Get_Auth(){
        try{
            File file = new File("resources/urlserver.txt");
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader readText = new BufferedReader(fileReader);
            String IP;
            while((IP = readText.readLine()) != null){
                URL_1 = "http://"+IP+"/smart-payment/getuid";
                URL_2 = "http://"+IP+"/smart-payment/updateabsen";
            }
            readText.close();
            fileReader.close();
        }catch(IOException ex){  
            ex.printStackTrace();
        }
    }
    /*
     *CREATE FILE
    */
    @Override
    public void CreateResources(Model model){
        try{
            File folder = new File("resources/");
            if(!folder.exists()){
                folder.mkdir();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        try{
            File file = new File("resources/log.csv");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        try{
            File file = new File("resources/listUID.txt");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        try{
            File file = new File("resources/tempUID.txt");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        try{
            File file = new File("resources/history.txt");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        try{
            File file = new File("resources/socket.txt");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        try{
            File file = new File("resources/urlserver.txt");
            if(!file.exists()){
                    file.createNewFile();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
