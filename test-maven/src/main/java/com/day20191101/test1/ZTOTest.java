package com.day20191101.test1;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class ZTOTest {

    public static void main(String[] args) {
        String str = "company_id=96c2c1e653c644609c9082e064dd38de&msg_type=NEW_TRACES&data=[\"680000000000\"]";

        String result = digest(str);
        System.out.println(result);
    }

    public static String digest(String str) {
        return Base64.encodeBase64String(DigestUtils.md5(str));
    }
}
