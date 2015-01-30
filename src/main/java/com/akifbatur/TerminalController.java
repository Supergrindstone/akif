package com.akifbatur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpUtils;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Enumeration;
import java.lang.management.*;
import java.util.*;

@RequestScoped
@ManagedBean(name = "terminalController")
public class TerminalController implements Serializable 
{

	private static final long serialVersionUID = 1L;
	RequestContext context = RequestContext.getCurrentInstance();
	
	//Commands
	public String handleCommand(String command, String[] params) 
	{
		command = StringEscapeUtils.escapeHtml4(command);
		if(command.equals("")) //Empty
		{
			context.execute("window.scrollTo(0,document.body.scrollHeight);");
			return "";
		}		
		else if(command.equals("komutlar")) //Clear
		{
			context.execute("window.scrollTo(0,document.body.scrollHeight);");
			return "clear<br>"
					+"hakkında<br>"
					+"linkler<br>";
		}
		else if(command.equals("clear")) //Clear
		{
			context.execute("PF('term').clear();");
			context.execute("window.scrollTo(0,0);");
			return "";
		}
		else if(command.equals("hakkında")) //Clear
		{
			context.execute("window.scrollTo(0,document.body.scrollHeight);");
			return "Akif Batur (aqui)<br>"
					+"Marmara Üniversitesi Bilgisayar Mühendisliği<br>"
					+"Copyleft - 2014<br>";
		}
		else if(command.equals("linkler")) //Clear
		{
			context.execute("window.scrollTo(0,document.body.scrollHeight);");
			return "";
		}
		else //Illegal command
		{
			
			System.out.println("you've made an illegal command");
			System.out.println("i doing it just for trial ");
			//komut hakikaten çalışsın mı? o zaman burayı uncomment...
//			StringBuffer output = new StringBuffer();
//			 
//			Process p;
//			try {
//				p = Runtime.getRuntime().exec(command);
//				p.waitFor();
//				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//				String line = "";			
//				while ((line = reader.readLine())!= null) {
//					output.append(line + "\n");
//				}
//	 
//			} catch (Exception e) {
//				return e.getMessage();
//			}
//	 
//			return output.toString();
			context.execute("window.scrollTo(0,document.body.scrollHeight);");
			return command + " komutu bulunamadı. komut listesi için: komutlar<br />";
		}
	}
}
