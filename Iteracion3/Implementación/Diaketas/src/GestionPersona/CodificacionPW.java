package GestionPersona;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

public class CodificacionPW {

	private String password=""; 
	
	public CodificacionPW(String pass) {
		password=CodificarClave(pass);
	}

	public String CodificarClave(String c){
		byte[] defaultBytes = c.getBytes();
		try{
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[] = algorithm.digest();
		     
			StringBuffer password=new StringBuffer();
			
			for (int i=0;i<messageDigest.length;i++) {
				password.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			
			
			return this.password+password;
			}catch(NoSuchAlgorithmException e){
				JOptionPane.showMessageDialog(null, "Error al codificar la ocntraseña\n"+e.getMessage());
				return "";
			}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
