#ifndef REALISATEUR_H
#define REALISATEUR_H
#include "personne.h"
#include<QList>

class Role;
class Films;

class Realisateur : public Personne
{
private :
    QList<Role *> realisation;
public:
    Realisateur(int c , QString n, QString p, Genre g);
    //void ajouteRole(QString r ,Films *pa);
    QList<Films *> joueAvec(Personne *A);
    //QString toString();
    QList<Role *> getRoles();
    QString getClassName();
    
};

#endif // REALISATEUR_H
