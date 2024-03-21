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
    String USER_NAME_SURNAME = readConfig().getString("creditRequest.userData.nameSurname");
    String PHONE_NUMBER = readConfig().getString("creditRequest.userData.phoneNumber");
    Integer NEEDED_SUM = readConfig().getInt("creditRequest.userData.neededSum");
    Integer PAYMENT_TERM  = readConfig().getInt("creditRequest.userData.paymentTerm");


}
