package it.marconivr.microblog.entity;

import it.marconivr.microblog.entity.BlogPost;
import it.marconivr.microblog.entity.BlogUtente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-02T17:08:49")
@StaticMetamodel(BlogCommento.class)
public class BlogCommento_ { 

    public static volatile SingularAttribute<BlogCommento, BlogUtente> utente;
    public static volatile SingularAttribute<BlogCommento, Date> dataOra;
    public static volatile SingularAttribute<BlogCommento, BlogPost> post;
    public static volatile SingularAttribute<BlogCommento, String> contenuto;
    public static volatile SingularAttribute<BlogCommento, Long> id;

}