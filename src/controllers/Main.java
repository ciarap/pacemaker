package controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.User;
import utils.FileLogger;

public class Main
{
	 public static void main(String[] args) throws IOException
	  {
	    FileLogger logger = FileLogger.getLogger();
	    logger.log("Creating user list");

	    List<User> users = new LinkedList<User>();
	    users.add(new User("Bart", "Simpson", "bart@simpson.com", "secret"));
	    users.add(new User("Homer", "Simpson", "bart@simpson.com", "secret"));
	    users.add(new User("Lisa", "Simpson", "bart@simpson.com", "secret"));
	    System.out.println(users);

	    logger.log("Serializing contacts to XML");
	    XStream xstream = new XStream(new JettisonMappedXmlDriver());
	    ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("users.xml"));
	    out.writeObject(users);
	    out.close();    

	    logger.log("Finished - shutting down");
	  }
}