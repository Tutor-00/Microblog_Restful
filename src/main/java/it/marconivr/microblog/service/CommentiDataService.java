/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconivr.microblog.service;


import it.marconivr.microblog.dao.CommentoDao;
import it.marconivr.microblog.dao.PostDao;
import it.marconivr.microblog.entity.BlogCommento;
import it.marconivr.microblog.entity.BlogPost;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
        
        c.setDataOra(new Date());
        CommentoDao.create(c);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<BlogCommento> getCommenti() {
        List<BlogCommento> commento = CommentoDao.findCommentoEntities();
        return commento;
    }
    
    @GET
    @Path("post/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<BlogCommento> getCommentiByPost(@PathParam("id") String postId) {
        BlogPost p = PostDao.findPost(Long.parseLong(postId));
        List<BlogCommento> commento = CommentoDao.findByPost(p);
        return commento;
    }
}
