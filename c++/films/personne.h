#ifndef PERSONNE_H
#define PERSONNE_H

#include<QString>
#include<QList>

class Role;
//class Films;

class Personne
{
public :
    enum Genre{Masculin , Feminin};

protected:
    int m_code;
    QString m_nom;
    QString m_prenom;
    Genre m_genre;


public:
    Personne(int c,QString n, QString p,  Genre g);
    QString toString();
    virtual QList<Role*> getRoles();
    //void ajouteRole(QString lol , Films yolo);
    virtual QList<Role*> joueAvec();
    virtual QString getClassName();
    int getCode();
    QString getPrenom();
    QString getNom();
    Genre getGenre();
    virtual void ajouteFilmo(Role *r);

private :
};

#endif // PERSONNE_H
