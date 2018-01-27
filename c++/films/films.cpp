#include "films.h"
#include "role.h"
#include "personne.h"

Films::Films(int code, QString t, int anne, GenreFilm g):
    m_code(code),m_titre(t),m_annee(anne),m_genrefilm(g)
{
}

void Films::ajouteRole(QString r, Personne *p)
{
    bool b1;
    for (int i = 0; i < m_casting.size(); ++i)
    {
        //verifie dans la liste que le role na pas dejas etait ajouter
        if ((m_casting[i]->getRole() == r) && (m_casting[i]->getPersonne()== p))
        {//si il y en as une met on bool a true
            b1 = true;
        }
    }
    if (!b1)
    {//si il n'est pas dans la list on le rajoute
        //ajoute un nouveau role

        m_casting.append(new Role(this,p,r));
        p->ajouteFilmo(new Role(this,p,r));

    }


}

//QString Films::getInfoBase()
//{
//}

QString Films::getRealisateur()
{
    QString buf="";
    for (int i = 0; i < m_casting.size(); ++i)
    {
        if (m_casting[i]->getPersonne()->getClassName() == "realisateur")
        {
            buf = buf+ m_casting[i]->getPersonne()->getNom() +" "+ m_casting[i]->getPersonne()->getPrenom() ;
        }

    }
    return buf;
}

QString Films::getActeur()
{
    QString buf="";
    for (int i = 0; i < m_casting.size(); ++i)
    {
        if (m_casting[i]->getPersonne()->getClassName() == "acteur")
        {
            buf = buf +" , " + m_casting[i]->getPersonne()->getNom() +" "+ m_casting[i]->getPersonne()->getPrenom() + "\n" ;
        }

    }
    return buf;
}

QList<Role *> Films::getCasting()
{
    return m_casting;
}

int Films::getCode()
{
    return m_code;
}

QString Films::getTitre()
{
    return m_titre;
}

int Films::getAnnee()
{
    return m_annee;
}

Films::GenreFilm Films::getGenre()
{
    return m_genrefilm;
}

QString Films::toString()
{
    QString res;
    QString genre ;
    QString code = QString::number( m_code );
    QString annee= QString::number( m_annee) ;
            switch (m_genrefilm) {
        case 0:
            genre = "SF";
            break;
        case 1:
            genre = "action" ;
            break;
        case 2:
            genre = "polar";
            break;
        default:
            break;
    }
    res=code +" : " + m_titre +" film " + genre  +", sortie en "+ annee +" realiser par "+ this->getRealisateur();
    return res;
}


