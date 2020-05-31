
package uuu.totalbuy.other;
// 15-8 Collection容器 hashCode

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//客戶 

public class Customer {

    public static final char MALE = 'M';
    public static final char FEMALE = 'F';

    //必要欄位，欄位必需要有內容，不能null，非必要欄位，沒資料可以null
    private String id;//身份證
    private String name;
    private String password;
    private char gender;//性別: M:男, F:女
    private String email;
    //以下5個非必要欄位
    private Date birthDate;
    private String address;//地址
    private String phone;
    private boolean married;//是否已婚
    private BloodType bloodType;//0:O型, 1:A型, 2:B型, 3:AB型 (enum用列舉)

    private int status;//狀態
    //0:新會員, 1:已確認,  > 1000:待確認(確認碼以亂數)，送確認信，-1:停用

    public Customer() {
//java幫沒有參數的建構子自動加super();的時候，父類別是Object
    }
    /*
     public Customer(String id, String name, String password,char gender,String address, 
     Date birthDate,boolean married, String email) {
     this(id, name, password,address);
     this.birthDate = birthDate;
     this.gender = gender;
     this.married = married;
     this.email = email;

     }
     */

    //重載(多個)建構子，以需求去建立

    public Customer(String id, String name,
              String password) {
        //其它建構子有寫過的就沒必要在寫了，用this();呼叫有的資料
        this(id, name);
        this.password = password;

     //this();建構子專用，必須在第一行，呼叫類別中其它建構子
        //this();呼叫這個class其它建構子裡有的參數，沒有參數時會出錯
        //this(id,name,address);
        //this.married = married;
    }

    public Customer(String id, String name, String password, String email) {
        this(id, name, password);
        this.email = email;
    }

    public Customer(String id, String name) {
        
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws TotalBuyException {
        //trim()前後去空白,id=id.trime,id去前後空白，在指派回去id
        if (id != null && (id = id.trim()).length() == 10 && checkId(id)) {
            this.id = id;
        } else {
            throw new TotalBuyException("id欄位必須輸入且格式正確");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TotalBuyException {
        if (name != null && (name = name.trim()).length() > 0) {
            this.name = name;
        } else {
            throw new TotalBuyException("姓名欄位必須輸入");

        }

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
    //取得客戶的詳細資料
    /*   改成toString  
     public String getDetails() {
     //不用show的情況下回傳 資料
     return "Id:     " + getId() + "\n" + 
     "Name:   " + getName() + "\n" + 
     "Address:" + getAddress() + "\n" +
     "Married:" + isMarried();
     }
     */

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) throws TotalBuyException {
        //new Date現在的時間
        if (birthDate == null || birthDate.before(new Date())) {
            this.birthDate = birthDate;
        } else {
            throw new TotalBuyException("出生日期必須小於今天");

        }

    }

    public void setBirthDate(String sDate) throws TotalBuyException {
        if (sDate != null && (sDate = sDate.trim()).length() > 0) {
            //把日期-換成/
            sDate = sDate.replace('-', '/');
            try {
            //(取得預設日期.parse檢查sDate是否符合的字串，
                //格式化後傳回sDate)(HTML規格//yyyy/M/d
                this.setBirthDate(DateFormat.getDateInstance().parse(sDate));
            } catch (ParseException ex) {
                throw new TotalBuyException("出生日期資料格式不正確");
            }
        } else {
                this.birthDate = null;
        }
    }
    //網站用
    public String getBirthDateString(){
        if(this.birthDate != null) {
            //把生日日期格式化成建立的日期格式字串
            return new SimpleDateFormat("yyyy-MM-dd").format(this.birthDate);
        }else{
            return "";
        }
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) throws TotalBuyException {
        if (gender == MALE || gender == FEMALE) {
            this.gender = gender;
        } else {
            throw new TotalBuyException("性別資料不正確");
        }
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws TotalBuyException {
        //matches檢查email格式
        if (email != null && (email = email.trim()).length() > 0) {
            this.email = email;
        } else {
            throw new TotalBuyException("email欄位必須輸入且格式符合email格式");
        }


//        if (email != null && (email = email.trim()).matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
//            this.email = email;
//        } else {
//            throw new TotalBuyException("email欄位必須輸入且格式符合email格式");
//        }
    }

    //檢查身份證字數,並回傳true或false
    public static boolean checkId(String id) {
        return (id != null && id.length() == 10);

    }
   /* 老師的
    private static final String idPattern = "^[A-Z][12][0-9]{8}$";

    public static boolean checkId(String id) {
        boolean answer = false;
        if (id == null || id.length() != 10) {
            return answer;
        } else {
            if (id.matches(idPattern)) {
                char last_char = id.charAt(9);
                if (last_char == getLastNumberFromId(id.substring(0, 9))) {
                    answer = true;
                }
            }
        }
        return answer;
    }
    
    public static char getLastNumberFromId(String id_9) {
        char first_char = id_9.charAt(0);
        char last_char = '\u0000';

        int s = 0;
        if (first_char >= 'A' && first_char <= 'H') {
            s = (first_char - 'A' + 10);
        } else if (first_char >= 'J' && first_char <= 'N') {
            s = (first_char - 'J' + 18);
        } else if (first_char >= 'P' && first_char <= 'V') {
            s = (first_char - 'P' + 23);
        } else {
            switch (first_char) {
                case 'I':
                    s = 34;
                    break;
                case 'O':
                    s = 35;
                    break;
                case 'W':
                    s = 32;
                    break;
                case 'X':
                    s = 30;
                    break;
                case 'Y':
                    s = 31;
                    break;
                case 'Z':
                    s = 33;
                    break;
                default:
                    System.out.println("不可能");
            }
        }
        int data = (s / 10) * 1 + (s % 10) * 9;
        for (int i = 1; i < 9; i++) {
            int c = Integer.parseInt(id_9.charAt(i) + "") * (8 - i + 1);
            data += c;
        }
        last_char = (char) ((10 - (data % 10)) % 10 + '0');
        assert (last_char >= '0' && last_char <= '9') : "id尾碼不正確: " + last_char;
        return last_char;
    }
    */
    @Override
    public int hashCode() {
        //因為id是String, 所以要用hashCode先運算
        return id.hashCode();
    }
    
      //09-20 例-09-24
    
    @Override
    public boolean equals(Object obj) {
        //判斷結果
        boolean result = false;
        //1.先排除null值(參數)
        if (obj != null) {
            //2.判斷參數物件種類
            if (obj instanceof Customer) {
                //判斷完在轉型
                Customer c = (Customer) obj;
              //判斷兩個物件是否一樣，沒有固定的寫法
                //3.判斷資料，兩個物件是否一樣 
                //if (getId().equals(c.getId() ) ){
                //在自已類別裡面可以直接id就好
                if (id.equals(c.id) && email.equals(c.email)) {
                    result = true;
                }

            }
        }
        return result;
    }
//printf這個類的物件時，就會呼叫toString
     @Override
    public String toString() {
        return String.format("ID:        %s%n"
                + "Name:      %s%n"
                + "Address:   %s%n"
                + "BirthDate: %s%n"
                + "Gender:    %s%n"
                + "Married:   %b%n"
                + "EMail:     %s%n",
                getId(), getName(), getAddress(), getBirthDate(),
                getGender(), isMarried(), getEmail());
        /*
         return "ID:     " + getId() + "\n" + 
         "Name:   " + getName() + "\n" + 
         "Address:" + getAddress() + "\n" +
         "Gender: " + getGender() + "\n" +
         "Married:" + isMarried() + "\n" +
         "Email:  " + getEmail();
         */
    }
    
    
  

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws TotalBuyException {
        if (password != null && (password = password.trim()).length() >0) {
            this.password = password;
        } else {
            throw new TotalBuyException("密碼欄位必須輸入");
        }

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
