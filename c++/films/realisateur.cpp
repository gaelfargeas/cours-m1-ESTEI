#include "realisateur.h"
#include "role.h"
#include "films.h"
#include "QList"

Realisateur::Realisateur(int c,QString n, QString p,  Genre g):
    Personne(c,n,p,g) {}

//void Realisateur::ajouteRole(QString r, Films *pa)
//{
//    Role *r1 =new Role(pa,this,r);
//    realisation.append(r1);
//    pa->ajouteRole(r,this);
//}

QList<Films *> Realisateur::joueAvec(Personne *A)
{
    QList<Films *> f1;
    for(int i=0 ; i< realisation.size() ; i++)
    {
        if(realisation[i]->getFilm()->getActeur().contains( (A->getNom() +" "+A->getPrenom()) ) )
        {
            f1.append(realisation[i]->getFilm());
        }
        if(realisation[i]->getFilm()->getRealisateur().contains( (A->getNom() +" "+A->getPrenom()) ) )
        {
            f1.append(realisation[i]->getFilm());
        }

    }
    return f1;
}

//QString Realisateur::toString()
//{
//    return Personne::toString();
//}

QList<Role*> Realisateur::getRoles()
{
 return realisation;
}

QString Realisateur::getClassName()
{
    return "realisateur";
}

