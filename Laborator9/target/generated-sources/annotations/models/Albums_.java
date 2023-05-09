package models;

import java.io.Serializable;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Genres;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-09T01:27:13", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(Albums.class)
public class Albums_ { 

    public static volatile SingularAttribute<Albums, String> artist;
    public static volatile SingularAttribute<Albums, Serializable> genre;
    public static volatile SingularAttribute<Albums, Integer> id;
    public static volatile SingularAttribute<Albums, String> title;
    public static volatile SingularAttribute<Albums, Integer> releaseYear;
    public static volatile CollectionAttribute<Albums, Genres> genresCollection;

}