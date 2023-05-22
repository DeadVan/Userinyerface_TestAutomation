package Utils;

import java.util.*;

public final class DomainUtils {
    private DomainUtils(){}


    public static String generateRandomEmailDomain(){
        List<String> domains = Arrays.asList("yahoo", "gmail", "outlook", "mail", "yandex");
        int index = new Random().nextInt(domains.size());
        return domains.get(index);
    }
}
