#ifndef ROLE_H
#define ROLE_H

#include<QString>

class Films;
class Personne;


class Role
{
private :
    Personne *m_personne;
    Films *m_film;
    QString m_role;
public:
    Role(Films *f , Personne *p, QString r);
    Films* getFilm();
    Personne* getPersonne();
    QString getRole();
};

#endif // ROLE_H
