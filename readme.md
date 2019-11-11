# android-eservices-staticfragmenttabs

Ce premier TP pour le cours d'Android en E-Services a pour but de faire découvrir les fragments utilisés de manière statique.



### Je vous propose ...
###### de s'entraider ?
Le principe d'Android étant d'être ouvert, je vous propose de garder le même principe. 
Qui n'est jamais allé trouver la réponse à un problème sur StackOverflow ou autre ?
Je vous invite à utiliser le système de Wiki de GitHub pour partager vos trouvailles avec les autres.
Si vous avez été bloqué sur quelque chose, écrivez le problème et la solution que vous avez trouvé dans un Wiki :)
Plusieurs choses, ça me permettra de vous aider si je vois que ce n'était pas la meilleure chose à faire, et ça permettra de découvrir ce sur quoi vous bloquez.
En plus, si tout le monde joue le jeu, ça permettra de créer une petite base de données de connaissance sur ces sujets.
###### deux manières de faire.
Le temps de cours est limité donc le temps pour faire les TP l'est aussi. 
Je vous laisse deux possibilités : soit on profite du temps pour vous laisser coder et je peux passer vous aider, soit à partir d'un moment on bascule sur le code corrigé et on le regarde ensemble.
Quel est votre choix ?
###### de réfléchir :)
Je suis là pour vous aider et répondre à vos questions, mais Google est votre ami. Je ne répondrai que si j'ai le sentiment que vous avez un minimum cherché (ou si vous me le montrez directement). 


### Description
Très simplement, cette application présente deux fragments intégrés dans un viewpager, et navigables via un TabLayout.
Chaque fragment possède un bouton qui permet d'incrémenter ou de décrémenter le compteur géré par l'activité.

### Aspects techniques
Les concepts manipulés dans ce TP sont :
- Les [fragments](https://developer.android.com/guide/components/fragments) (utilisés de manière statique)
- Le [TabLayout](https://developer.android.com/reference/android/support/design/widget/TabLayout)
- Le [ViewPager](https://developer.android.com/training/animation/screen-slide)


P.S. : je donne, pour la première, je donne les liens vers la doc. Pour la suite, vous prendrez le réflexe d'aller faire la recherche seuls dès qu'on parle d'un concept du genre ;)


Mais aussi plus généralement :
- La communication fragment/activité
- Les layouts simples


### A découvrir
- Faites un petit tour dans les drawables pour découvrir le système de vecteurs (svg). Android propose plein de vecteurs directement depuis Android Studio, essayez d'en ajouter un.
- Les boutons contenus dans les fragments utilisent un fond particulier, ce n'est pas un image fixe. Regardez ce que c'est et retenez le bien ;)
- Les textes ne sont pas mis en dur dans les layouts ni les activités mais ailleurs. Où ça ? A quoi ça sert ?


### Objectifs
Ce TP est découpé en deux partie qui se suivent, faites d'abord l'une puis l'autre.

###### Première partie : faire fonctionner les fragments
Dans la version initiale du projet, nous vous mettons à disposition toutes les ressources du projet ainsi qu'un Fragment vide.
Il vous faut tout d'abord :
- [x] Remplir les méthodes du fragment, en comprenant leur rôle.
- [x] Remplir les méthodes de l'activité en suivant les TODOs. Le principe est d'initialiser les références vers les vues, de préparer les instances des fragments (pour l'instant d'un seul fragment), et d'écrire le comportement du viewpager (autrement dit, lui associer un adapter). 
- [x] A ce stade, faites en sorte que les deux onglets affichent deux instances du même fragment et testez l'application.
- [x] Si tout fonctionne bien, créer un deuxième fragment, associez lui l'autre layout disponible (fragment_two) et associez le à l'onglet correspondant. 
- [x] A priori, maintenant les deux onglets fonctionnent. Vous savez maintenant mettre en place des onglets basiques associés à des fragments.

###### Deuxième partie : brancher la logique des fragments
On veut maintenant que, lorsque l'on clique sur les boutons des fragments, le compteur en variable dans l'activité soit incrémenté ou décrémenté.


La bonne manière pour faire ça est expliquée dans la doc, il s'agit de faire communiquer un fragment avec son activité.


Une question : est-ce plus simple de faire communiquer activité -> fragment ou fragment -> activité ?
