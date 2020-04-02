package it.marconivr.microblog.entity;

import it.marconivr.microblog.entity.BlogUtente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-02T17:08:49")
@StaticMetamodel(BlogPost.class)
public class BlogPost_ { 

    public static volatile SingularAttribute<BlogPost, BlogUtente> utente;
    public static volatile SingularAttribute<BlogPost, Date> dataOra;
    public static volatile SingularAttribute<BlogPost, String> titolo;
    public static volatile SingularAttribute<BlogPost, String> contenuto;
    public static volatile SingularAttribute<BlogPost, Long> id;

}