package com.bike.dto.usuario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.bike.api.usuarios.UsuarioRequest;

public class FabricaUsuario {
	public static void addConfigurationBD(String tipoAplicacion) {
		
		try {
			Properties opciones = new Properties();
			opciones.load(new FileReader("src/main/resources/config-bd.properties"));
			
			Properties configApp = new Properties();
			configApp.load(new FileReader("src/main/resources/application.properties"));
			
			switch(tipoAplicacion) {
			
			case "1":
				configApp.setProperty("spring.datasource.url", opciones.getProperty("social.bike.url"));
				configApp.setProperty("spring.datasource.username", opciones.getProperty("social.bike.username"));
				configApp.setProperty("spring.datasource.password", opciones.getProperty("social.bike.password"));
				break;
			case "2":
				configApp.setProperty("spring.datasource.url", opciones.getProperty("go.bike.url"));
				configApp.setProperty("spring.datasource.username", opciones.getProperty("go.bike.username"));
				configApp.setProperty("spring.datasource.password", opciones.getProperty("go.bike.password"));
				break;
			case "3":
				configApp.setProperty("spring.datasource.url", opciones.getProperty("bici.bogo.url"));
				configApp.setProperty("spring.datasource.username", opciones.getProperty("bici.bogo.username"));
				configApp.setProperty("spring.datasource.password", opciones.getProperty("bici.bogo.password"));
				break;
			
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static Usuario getUsuarioAplicacion(UsuarioRequest request) throws Exception {
		// FabricaUsuario.addConfigurationBD(request.getTipoAplicacion());
		
		String usuUsuario = request.getUsuario(); 
		String usuNombre =  request.getNombre();
		String usuCorreo = request.getCorreo();
		String usuPassword = request.getPassword();
		String usuTipoIdentificacion = request.getTipoIdentificacion();
		String usuNumIdentificacion = request.getNumIdentificacion();
		String usuTelefono = request.getTelefono();
		String usuDireccion = request.getDireccion();
		
		if (request.getTipoAplicacion().equals("1")) {
			return new UsuarioSocial(usuUsuario, usuNombre, usuCorreo, usuPassword);
			
		} else if (request.getTipoAplicacion().equals("2") || request.getTipoAplicacion().equals("3")) {
			String usuEmpresa = request.getEmpresa();
			return new UsuarioCiudadano(usuUsuario, usuNombre, usuCorreo, usuPassword, usuTipoIdentificacion, usuNumIdentificacion, usuTelefono, usuDireccion, usuEmpresa);
					
		} else {
			throw new Exception("Tipo Aplicacion no existe");
		}
		
	}

}
