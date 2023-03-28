package org.example;

import si.um.feri.jee.ejb.PatientEJBRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws NamingException {
        System.out.println("Hello world!");

        Properties props=new Properties();
        props.put("java.naming.factory.initial","org.jboss.naming.remote.client.InitialContextFactory");
        props.put("java.naming.provider.url","http-remoting://127.0.0.1:8080");
        props.put("jboss.naming.client.ejb.context","true");
        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
        InitialContext ctx=new InitialContext(props);

        PatientEJBRemote p = (PatientEJBRemote) ctx.lookup("sampleProject/PatientMemoryDao!si.um.feri.jee.ejb.PatientEJBRemote");


        p.getAllWithoutDoctor();

        System.out.println(p.getAllWithoutDoctor());
    }
}