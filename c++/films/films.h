#ifndef FILMS_H
#define FILMS_H
#include <QString>
#include <QList>



class Role;
class Personne;


class Films
{
public:
    enum GenreFilm {SF,action,polar};
private :
    int m_code ;
    QString m_titre;

    int m_annee;

    QList<Role *> m_casting;
    GenreFilm m_genrefilm;




public:
    Films(int code ,QString m_titre,int anne,GenreFilm g);
    void ajouteRole(QString r , Personne *p);
    //QString getInfoBase();
    QString getRealisateur();
    QString getActeur();
    QList<Role *> getCasting();
    int getCode();
    QString getTitre();
    int getAnnee();
    GenreFilm getGenre();
    QString toString();
};

#endif // FILMS_H
