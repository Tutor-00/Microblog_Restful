/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconivr.microblog.service;


import it.marconivr.microblog.dao.CommentoDao;
import it.marconivr.microblog.entity.BlogCommento;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Tutor-00
 */
@Path("/comments")
public class CommentiDataService {
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCommento(BlogCommento c){
        CommentoDao.create(c);
    }
    
}
