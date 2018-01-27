#include <QCoreApplication>
#include "acteur.h"
#include "films.h"
#include "realisateur.h"
#include "role.h"
#include <QTextStream>
#include <QList>
QTextStream qout(stdout,QIODevice::WriteOnly);

int main(int argc, char *argv[])
{

    Films *f1 = new Films(1,"le test",1996,Films::SF);
    Acteur *a1 = new Acteur(1,"toto","lefou",Personne::Masculin);
    Acteur *a2 = new Acteur(1,"tata","lafolle",Personne::Feminin);
    Realisateur *r1 = new Realisateur (1,"titi" ,"lefifou",Personne::Masculin);
    f1->ajouteRole("realisateur",r1);
    f1->ajouteRole("coucou ",a2);
    f1->ajouteRole("devine",a1);
    qout<<f1->getActeur() << endl;
    qout << f1->getAnnee() << endl ;
    qout << f1->getCode()<<endl;
    qout  << a1->getNom() << " " << a1->getPrenom() << " " << a1->getGenre() << "" <<endl ;

    qout << "casting du film "<<f1->toString() << " :"<<endl ;
    QList<Role * > casti = f1->getCasting();
    foreach (Role *pr, casti) {
        qout<< "\t"<<pr->getPersonne()->toString()<<endl;
    }


    QList<Films * > res = a1->joueAvec(a2);
    qout<< a1->toString() <<" joue avec "<<a2->toString() << " : Resultat = "<< res.size() << endl ;
    foreach (Films *pf, res) {
        qout<< "\t"<<pf->toString() <<endl;
    }


    QCoreApplication a(argc, argv);
    return a.exec();
}
