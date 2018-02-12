#include <stdio.h>
#include <stdlib.h>

typedef struct List
{
    char valleur;
    struct List * precedent;
    struct List * suivant;
} List;

/*
List *head;
List *tail;
*/



List* init_List()
{

    printf("======== INIT START ========\n");

    //crée la liste
    List *head = (List *) malloc(sizeof(List)) ;

    List *tail = (List *) malloc(sizeof(List)) ;

//init head
    if(head != NULL)
    {
        head->valleur=0;
        head->suivant=NULL;
        head->precedent= tail;
        printf("head created\n");
    }
    else
    {
        printf("error on head creation\n");
        if (tail != NULL)
        {
            head = tail;
            printf("solution : head = tail\n");
        }

    }

//init tail
    if(tail != NULL)
    {
        tail->valleur=0;
        tail->suivant=head;
        tail->precedent= NULL;
        printf("tail created\n");

    }
    else
    {
        printf("error on tail creation\n");
        if (tail != NULL)
        {
            tail = head;
            printf("solution : tail = head\n");
        }
    }

    printf("======== INIT END ========\n");
    return head ;
}


void add_element(List *L, char nbr)
{
    printf("======== ADD ELEMENT LIST START ========\n");
    List *tmp = L;

    if(tmp->precedent == NULL)
    {
        for (int i =0; i<nbr; i++)
        {

        List *new_element = (List *) malloc(sizeof(List)) ;

 //init
        new_element->valleur=0;
        new_element->precedent=NULL;
        new_element->suivant=tmp;

//lie de head a la struct crée precedament
        tmp->precedent=new_element;
        tmp = new_element;
        }



    }
    else if( tmp->suivant == NULL)
    {
         for (int i =0; i<nbr; i++)
        {
        List *new_element = (List *) malloc(sizeof(List)) ;
        //init le nouvelle struct
        new_element->suivant=NULL;
        new_element->precedent=tmp;
        new_element->valleur=0;
        //lie de head a la struct crée precedament
        tmp->suivant=new_element;
        tmp = new_element;
        }
    }
    else
        //on a pris un element au millieu dun liste
    {
         for (int i =0; i<nbr; i++)
        {
        List *new_element = (List *) malloc(sizeof(List)) ;
        //init le nouvelle struct
        new_element->suivant=tmp->suivant;
        tmp->suivant->precedent=new_element;

        new_element->precedent=tmp;
        tmp->suivant=new_element;
        new_element->valleur=0;
        tmp = new_element;
        }
    }



    printf("======== ADD ELEMENT LIST END ========\n");
    return;
}

void reset_List(List *L)
{
    printf("======== RESET LIST START ========\n");
    L->valleur=0;
    List *suiv;
    List * prec;

    if (L->suivant != NULL)
    {
        suiv=L->suivant;
        while (suiv != NULL)
        {
            suiv->valleur =0;
            suiv = suiv->suivant;

        }

    }
    if (L->precedent != NULL)
    {
        prec=L->precedent;
        while (prec != NULL)
        {
            prec->valleur =0;
            prec = prec->precedent;

        }
    }

    printf("======== RESET LIST STOP ========\n");
}

void print_List(List *L)
{
    printf("======== PRINT LIST START ========\n");
    List *tmp = L;
    int v = 0;
//va au debut de la chaine
    while (tmp->precedent != NULL)
    {
        tmp= tmp->precedent;
    }

    while (tmp != NULL)
    {
        printf("list %d ", v);
        printf( " : ");
        printf("%c", tmp->valleur);
        printf("\n");
        v++;
        tmp= tmp->suivant;

    }





    tmp = L;
//va au debut de la chaine
    while (tmp->precedent != NULL)
    {
        tmp= tmp->precedent;
    }

    while (tmp != NULL)
    {
        printf("%c", tmp->valleur);
        v++;
        tmp= tmp->suivant;

    }
    printf("\n");




    printf("======== PRINT LIST END ========\n");
}

List* get_tail (List *L)
{
    printf("======== GET TAIL START ========\n");
    List *tmp = L;

    //va a la fin de la chaine
    while (tmp->suivant != NULL)
    {
        tmp = tmp->suivant;
    }
    printf("======== GET TAIL STOP ========\n");
    return tmp;
}

List* get_element_at_number (List *L,char val)
{
    printf("======== GET ELEMENT START ========\n");
    List *tmp = L;

    //va a la debut de la chaine
    while (tmp->precedent != NULL)
    {
        tmp = tmp->precedent;
    }

    for (int i = 0 ; i<val ; i++)
    {
        if (tmp != NULL)
        {
            tmp=tmp->suivant;
        }else
        {
        printf("======== GET ELEMENT ERROR ========\n");
        tmp = L;
        return tmp;
        }


    }

    printf("======== GET ELEMENT STOP ========\n");
    return tmp;
}

List* get_head (List *L)
{
    printf("======== GET HEAD START ========\n");
    List *tmp = L;
    //va au debut de la chaine
    while (tmp->precedent != NULL)
    {
        tmp = tmp->precedent;
    }
    printf("======== GET HEAD STOP ========\n");
    return tmp;
}

void edit_element_from_tail(List *L,int nbr, int val)
{
    printf("======== EDIT ELEMENT FROM TAIL START ========\n");
    List *tmp = L;

    //va a la fin de la chaine
    while (tmp->suivant != NULL)
    {
        tmp = tmp->suivant;
    }
    //va a la struct voulue
    for (int i = 0 ; i<nbr ; i++)
    {
        if (tmp != NULL)
        {
            tmp = tmp->precedent;

        }
        else if (tmp == NULL)
        {
            printf("======== EDIT ELEMENT FROM TAIL ERROR ========\n");
            return;
        }

    }

//change sa valeur si il est pas null
    tmp->valleur=val;
    printf("======== EDIT ELEMENT FROM TAIL STOP ========\n");
    return;
}

void edit_element_from_head(List *L,int nbr, int val)
{
    printf("======== EDIT ELEMENT FROM HEAD START ========\n");
    List *tmp = L;

    //va au debut de la chaine
    while (tmp->precedent != NULL)
    {
        tmp = tmp->precedent;
    }

    //va a la struct voulue
    for (int i = 0 ; i<nbr ; i++)
    {
        if (tmp != NULL)
        {
            tmp = tmp->suivant;

        }
        else if (tmp == NULL)
        {
            printf("======== EDIT ELEMENT FROM HEAD ERROR ========\n");
            return;
        }

    }

//change sa valeur si il est pas null
    tmp->valleur=val;

    printf("======== EDIT ELEMENT FROM HEAD STOP ========\n");
    return;
}

void remove_element_from_tail( List *L,int nb )
{
    printf("======== REMOVE ELEMENT FROM TAIL START ========\n");
    List *tmp = L;

//va a la fin de la chaine
    while (tmp->suivant != NULL)
    {
        tmp = tmp->suivant;
    }

    for (int i = 0 ; i < nb ; i++)
    {
        tmp = tmp->precedent;
        free(tmp->suivant);
        tmp->suivant = NULL;
    }

//tail = tmp;
    printf("======== REMOVE ELEMENT FROM TAIL STOP ========\n");
    return ;
}

void remove_element_from_head( List *L,int nb )
{
    printf("======== REMOVE ELEMENT FROM HEAD START ========\n");
    List *tmp = L;

//va au debut de la chaine
    while (tmp->precedent != NULL)
    {
        tmp = tmp->precedent;
    }

    for (int i = 0 ; i < nb ; i++)
    {
        tmp = tmp->suivant;
        free(tmp->precedent);
        tmp->precedent = NULL;
    }

//head = tmp;
    printf("======== REMOVE ELEMENT FROM HEAD STOP ========\n");
    return;
}

void delete_list (List *L)
{
//probleme si il y a qu'une struct on la supprime pas : probleme regler
    printf("======== DELETE LIST START ========\n");
    List *tmp = L;

    //va au debut de la chaine
    while (tmp->precedent != NULL)
    {
        tmp = tmp->precedent;
    }

    if(tmp->suivant == NULL)
    {
        free(tmp);
        tmp=NULL;
    }
    else
    {
//va a la struct suivante
        tmp = tmp->suivant;
    }

    while ( tmp!= NULL)
    {
        free(tmp->precedent);

        if (tmp->suivant == NULL)
        {
            free(tmp);
            tmp = NULL;
        }
        else
        {
            tmp =tmp->suivant ;
        }

    }
    printf("======== DELETE LIST END ========\n");

}




int main()
{
    //probleme pas d'uptate auto sur le head et le tail
    List *test = init_List();
    print_List(test);


    List *test_head = get_head(test);
    List *test_tail = get_tail(test);

    add_element(test_head,2);
    add_element(test_tail,2);
    print_List(test);

    edit_element_from_head(test,0,'S');
    edit_element_from_head(test,1,'A');
    edit_element_from_head(test,2,'L');
    edit_element_from_head(test,3,'U');
    edit_element_from_tail(test,1,'T');
    edit_element_from_tail(test,0,'!');
    print_List(test);

    reset_List(test);
    print_List(test);

    remove_element_from_head(test,2);
    //remove_element_from_tail(test,1);
    edit_element_from_tail(test,2,'L');
    print_List(test);
    delete_list(test);

    return 0;
}
