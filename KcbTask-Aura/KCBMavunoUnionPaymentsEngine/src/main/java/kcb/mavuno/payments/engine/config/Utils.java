package kcb.mavuno.payments.engine.config;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;

public class Utils {

	public String getTimestamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date());
    }

    public String sanitizePhoneNumber(String phone) {

        if (phone.equals("")) {
            return "";
        }

        if (phone.length() < 11 & phone.startsWith("0")) {
            String p = phone.replaceFirst("^0", "254");
            return p;
        }
        if (phone.length() == 13 && phone.startsWith("+")) {
            String p = phone.replaceFirst("^+", "");
            return p;
        }
        return phone;
    }

    public String getPassword(String businessShortCode, String passkey, String timestamp) throws UnsupportedEncodingException {
        String str = businessShortCode + passkey + timestamp;
        //encode the password to Base64
		byte[] bytes          = str.getBytes("ISO-8859-1");
		String auth           = Base64.getEncoder().encodeToString(bytes);
        return auth;
    }
	
}
