#include "role.h"


Role::Role(Films *f , Personne *p, QString r) :
     m_film(f) ,m_personne(p),m_role(r)
{

}

Films* Role::getFilm()
{
return m_film;
}

Personne* Role::getPersonne()
{
return m_personne;
}

QString Role::getRole()
{
return m_role;
}
