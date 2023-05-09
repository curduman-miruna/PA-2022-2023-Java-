package models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Albums;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-09T01:27:13", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(Genres.class)
public class Genres_ { 

    public static volatile CollectionAttribute<Genres, Albums> albumsCollection;
    public static volatile SingularAttribute<Genres, String> name;
    public static volatile SingularAttribute<Genres, Integer> id;

}