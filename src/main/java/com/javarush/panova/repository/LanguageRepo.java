package com.javarush.panova.repository;

import com.javarush.panova.entities.Inventory;
import com.javarush.panova.entities.Language;
import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LanguageRepo {
    public static Language getLanguageById(Short id){

        String hql = "from Language l where l.id = :languageId";
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            Query<Language> query = session.createQuery(hql, Language.class);
            query.setParameter("languageId", id);
            Language language = query.getSingleResult();
            return  language;

        }
    }
}
