package ReadProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    Config config =readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("TestProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
//    UserData1---------------------------------
    String USER_NAME_SURNAME_1 = readConfig().getString("creditRequest.userData1.nameSurname");
    String PHONE_NUMBER_1 = readConfig().getString("creditRequest.userData1.phoneNumber");
    Integer NEEDED_SUM_1 = readConfig().getInt("creditRequest.userData1.neededSum");
    Integer PAYMENT_TERM_1  = readConfig().getInt("creditRequest.userData1.paymentTerm");
    //    UserData2---------------------------------
    String USER_NAME_SURNAME_2 = readConfig().getString("creditRequest.userData2.nameSurname");
    String PHONE_NUMBER_2 = readConfig().getString("creditRequest.userData2.phoneNumber");
    Integer NEEDED_SUM_2 = readConfig().getInt("creditRequest.userData2.neededSum");
    Integer PAYMENT_TERM_2  = readConfig().getInt("creditRequest.userData2.paymentTerm");
    //    UserData3---------------------------------
    String USER_NAME_SURNAME_3 = readConfig().getString("creditRequest.userData3.nameSurname");
    String PHONE_NUMBER_3 = readConfig().getString("creditRequest.userData3.phoneNumber");
    Integer NEEDED_SUM_3 = readConfig().getInt("creditRequest.userData3.neededSum");
    Integer PAYMENT_TERM_3  = readConfig().getInt("creditRequest.userData3.paymentTerm");
    //    UserData4---------------------------------
    String USER_NAME_SURNAME_4 = readConfig().getString("creditRequest.userData4.nameSurname");
    String PHONE_NUMBER_4 = readConfig().getString("creditRequest.userData4.phoneNumber");
    Integer NEEDED_SUM_4 = readConfig().getInt("creditRequest.userData4.neededSum");
    Integer PAYMENT_TERM_4  = readConfig().getInt("creditRequest.userData4.paymentTerm");
}
