package it.marconivr.microblog.service;

import it.marconivr.microblog.dao.CommentoDao;
import it.marconivr.microblog.dao.PostDao;
import it.marconivr.microblog.dao.exceptions.NonexistentEntityException;
import it.marconivr.microblog.entity.BlogCommento;
import it.marconivr.microblog.entity.BlogPost;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    public void addPost(BlogPost p) {
        p.setDataOra(new Date());
        PostDao.create(p);

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
}
