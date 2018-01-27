#include "acteur.h"
#include "films.h"
#include "role.h"
#include <QList>

Acteur::Acteur(int c, QString n, QString p, Genre g):
   Personne(c,n,p,g)
{

}

//void Acteur::ajouteRole(QString r, Films *pa)
//{
//    Role *r1 =new Role(pa,this,r);
//    filmographie.append(r1);
//    pa->ajouteRole(r,this);
//}

QList<Films*> Acteur::joueAvec(Acteur *A)
{
    QList<Films*> f1;
    for(int i=0 ; i< filmographie.size() ; i++)
    {
        if(filmographie[i]->getFilm()->getActeur().contains( (A->getNom() +" "+A->getPrenom()) ) )
        {
            f1.append(filmographie[i]->getFilm());
        }

    }
    return f1;
}

QList<Role*> Acteur::getRoles()
{
return filmographie;
}

QString Acteur::getClassName()
{
    return "acteur";
}

void Acteur::ajouteFilmo(Role *r)
{
    filmographie.append(r);
}

//QString Acteur::toString()
//{
//    return Personne::toString();
//}

