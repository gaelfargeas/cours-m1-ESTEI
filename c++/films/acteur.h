#ifndef ACTEUR_H
#define ACTEUR_H

#include "personne.h"
#include<QString>
#include<QList>
//#include "films.h"
//#include"role.h"
class Films;
class Role;

class Acteur : public Personne
{
private:
    QList<Role*> filmographie;

public:
    Acteur(int c,QString n, QString p,  Genre g);
    //void ajouteRole(QString r ,Films *pa);
    QList<Films *> joueAvec(Acteur *A);
    //QString toString();
    QList<Role *> getRoles();
    QString getClassName();
    void ajouteFilmo(Role *r);
};

#endif // ACTEUR_H
