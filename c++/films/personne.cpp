#include "personne.h"


Personne::Personne(int c, QString n, QString p, Genre g) :
    m_code(c),m_nom(n),m_prenom(p),m_genre(g)
{
}

QString Personne::toString()
{
    QString res;
    QString genre;
    if(m_genre==0)
    {
        genre = "Masculin";
    }else
    {
        genre = "Feminin";
    }
    res=m_nom +" "+ m_prenom +" genre : "+genre;
    return res;
}

QList<Role *> Personne::getRoles()
{
    QList<Role *> l1;
    return l1;


}

QList<Role *> Personne::joueAvec()
{
 QList<Role *> l2;
return l2;
}


QString Personne::getClassName()
{
    return "personne";
}

int Personne::getCode()
{
    return m_code;
}

QString Personne::getPrenom()
{
    return m_prenom;
}

QString Personne::getNom()
{
    return m_nom;
}

Personne::Genre Personne::getGenre()
{
    return m_genre;
}

void Personne::ajouteFilmo(Role *r)
{

}
