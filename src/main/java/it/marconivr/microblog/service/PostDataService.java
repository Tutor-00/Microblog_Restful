package it.marconivr.microblog.service;

import it.marconivr.microblog.dao.CommentoDao;
import it.marconivr.microblog.dao.PostDao;
import it.marconivr.microblog.dao.exceptions.NonexistentEntityException;
import it.marconivr.microblog.entity.BlogCommento;
import it.marconivr.microblog.entity.BlogPost;
import java.net.URI;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Tutor-00
 */
@Path("/posts")
public class PostDataService {

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<BlogPost> getPosts() {
        List<BlogPost> posts = PostDao.findPostEntities();
        return posts;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BlogPost getPost(@PathParam("id") String postId) {
        BlogPost p = PostDao.findPost(Long.parseLong(postId));
        return p;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPost(BlogPost p) {
        p.setDataOra(new Date());
        PostDao.create(p);
        
     
        
        return Response.created(URI.create("Microblog/rest/posts/" + p.getId()))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }

    @DELETE
    @Path("/{id}")
    public void deletePost(@PathParam("id") String postId) throws NonexistentEntityException {
        BlogPost post = PostDao.findPost(Long.parseLong(postId));
        List<BlogCommento> comments = CommentoDao.findByPost(post);

        for (BlogCommento commento : comments) {
            CommentoDao.destroy(commento.getId());
        }

        PostDao.destroy(Long.parseLong(postId));
    }

    @OPTIONS
    @Path("*")
    public Response options() {
        return Response.ok("")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }

}
