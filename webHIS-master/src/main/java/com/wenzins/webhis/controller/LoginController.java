package com.wenzins.webhis.controller;


import java.util.Iterator;
import java.util.List;










import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.*;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;

import com.wenzins.webhis.entity.Login;
import com.wenzins.webhis.service.LoginMgmtService;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static String algorithm = "AES";
	private static byte[] keyValue=new byte[] 
	{ 'T', 'h', 'i', 's', 'I', 's', 'a', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
	@Autowired
	LoginMgmtService loginMgmtService;
	

	Logger logger = Logger.getLogger(LoginController.class);
	
	
	/*sigup page will call these method and encryption function*/
	@RequestMapping(value = "/loginuser", method = RequestMethod.POST)
	@ResponseBody
	public Long loginUser(@RequestBody Login login) throws Exception {
		System.out.println("*******************im inside login controller*******************");
	
	
		String password = login.getPassword();
		// encryption logic
		String encryptedPassword =encryptpass(password);
		System.out.println("Encrypted passwprd: "+encryptedPassword);
		login.setPassword(encryptedPassword);
		return loginMgmtService.loginUser(login);
		
	}
	
	//Encryption code

public static  String encryptpass(String Data) throws Exception {
	Key key = generateKey();
    Cipher chiper = Cipher.getInstance(algorithm);
    chiper.init(Cipher.ENCRYPT_MODE, key);
    byte[] encVal = chiper.doFinal(Data.getBytes());
    String encryptedValue = new BASE64Encoder().encode(encVal);
    return encryptedValue;

    }
// Secretkey generation function
	
	private static  Key generateKey() {
	// TODO Auto-generated method stub
		Key key = new SecretKeySpec(keyValue, algorithm);
        return key;
	
}
   /* Login page will call these method.and decryption function*/

	@RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
	public List<Login> getUser(ModelMap map) throws Exception {
		//System.out.println("Came inside this method listtt >>>>  ::::  "				+ loginMgmtService.getAllUser());
		List<Login> li=loginMgmtService.getAllUser();
		Iterator<Login> mylist=li.iterator();
		/*String pass="CyXxZCQePq8Dxt35RVQrXw==q";
		//String pass="lDEF6BIoaJ6E0Rd3TmAmfw==";
		String decryptionPass = decryptpass(pass.toString());
		System.out.println("Decrypted Password:: "+decryptionPass);
		
		*/
		String loginUserName = "niranjan";
		String loginPassword = "hello";

		while(mylist.hasNext()){
		Login val=mylist.next();
		String userName = val.getUserName();
		System.out.println("*****Username:"+userName);
		if (userName.equals(loginUserName))
		{
			String pass=val.getPassword();
			System.out.println("########################################################3Password:: "+pass);
			String decryptionPass = decryptpass(pass);
			if (loginPassword.equals(decryptionPass))
			{
				System.out.println("**********************Login is accepted*************************************");
			}
			//val.setPassword(decryptionPass);
	//	System.out.println("Decrypted Password:: "+decryptionPass);
		
		}
		
		}		
		return li;
	
	}
	
	public static String decryptpass(String encryptedData) 
		throws  Exception {
		 Key key = generateKey();
         Cipher chiper = Cipher.getInstance(algorithm);
         chiper.init(Cipher.DECRYPT_MODE, key);
      //   System.out.println("########################################33Before decrypting: "+encryptedData);
         @SuppressWarnings("restriction")
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData.toString());
         //below this line execute
         byte[] decValue = chiper.doFinal(decordedValue);
         String decryptedValue = new String(decValue, "UTF-8");
         System.out.println("decryptedValue:"+decryptedValue);
         return decryptedValue;
    }
	
	public void setLoginMgmtService(LoginMgmtService loginMgmtService) {
		this.loginMgmtService = loginMgmtService;
	}


}