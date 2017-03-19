package cn.itweet.modules.admin.licence.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * 说明：对字符串加密
 * 包名：cn.itweet.modules.admin.licence.utils
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/16.
 */
public class EncrpptionUtils {
    /*
	 * 对信息加密
	 */
    public static String encryption(String message) {
        message = stringToBase64(message);
        char[] messageCode = message.toCharArray();
        for(int i = 0; i < messageCode.length; i++){
            messageCode[i] = (char)(messageCode[i] ^ 'T'^'g');
        }
        String code = stringToBase64(new String(messageCode));
        StringBuilder sb = new StringBuilder(code);
        for(int i=4;i<code.length();i+=4){
            sb.insert(i, "-");
        }
        return sb.toString();
    }

    /*
     * 把加密的信息Base64
     */
    private static String stringToBase64(String encryptionCode){
        return Base64.encode(encryptionCode.getBytes());
    }

}
